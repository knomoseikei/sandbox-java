package pe.knomo.snippets.image.drawing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
class ImageDrawingComponent extends Component {

    static String descs[] = {
        "Simple Copy",
        "Scale Up",
        "Scale Down",
        "Scale Up : Bicubic",
        "Convolve : LowPass",
        "Convolve : Sharpen", 
        "RescaleOp",
        "LookupOp",
    };

    int opIndex;
    private BufferedImage bi;
    int w, h;
    
    public static final float[] SHARPEN3x3 = { // sharpening filter kernel
        0.f, -1.f,  0.f,
       -1.f,  5.f, -1.f,
        0.f, -1.f,  0.f
    };

    public static final float[] BLUR3x3 = {
        0.1f, 0.1f, 0.1f,    // low-pass filter kernel
        0.1f, 0.2f, 0.1f,
        0.1f, 0.1f, 0.1f
    };

    public ImageDrawingComponent(URL imageSrc) {
        try {
            bi = ImageIO.read(imageSrc);
            w = bi.getWidth(null);
            h = bi.getHeight(null);
            if (bi.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 =
                    new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(bi, 0, 0, null);
                bi = bi2;
            }
        } catch (IOException e) {
            System.out.println("Image could not be read");
            System.exit(1);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    static String[] getDescriptions() {
        return descs;
    }

    void setOpIndex(int i) {
        opIndex = i;
    }
    
    /* In this example the image is recalculated on the fly every time
     * This makes sense where repaints are infrequent or will use a
     * different filter/op from the last.
     * In other cases it may make sense to "cache" the results of the
     * operation so that unless 'opIndex' changes, drawing is always a
     * simple copy.
     * In such a case create the cached image and directly apply the filter
     * to it and retain the resulting image to be repainted.
     * The resulting image if untouched and unchanged Java 2D may potentially
     * use hardware features to accelerate the blit.
     */
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        switch (opIndex) {
        case 0 : /* copy */
            g.drawImage(bi, 0, 0, null);
            break;

        case 1 : /* scale up using coordinates */
            g.drawImage(bi,
                        0, 0, w, h,     /* dst rectangle */
                        0, 0, w/2, h/2, /* src area of image */
                        null);
            break;

        case 2 : /* scale down using transform */
            g2.drawImage(bi, AffineTransform.getScaleInstance(0.7, 0.7), null);
            break;

        case 3: /* scale up using transform Op and BICUBIC interpolation */
            AffineTransform at = AffineTransform.getScaleInstance(1.5, 1.5);
            AffineTransformOp aop =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
            g2.drawImage(bi, aop, 0, 0);
            break;

        case 4:  /* low pass filter */
        case 5:  /* sharpen */
            float[] data = (opIndex == 4) ? BLUR3x3 : SHARPEN3x3;
            ConvolveOp cop = new ConvolveOp(new Kernel(3, 3, data),
                                            ConvolveOp.EDGE_NO_OP,
                                            null);
            g2.drawImage(bi, cop, 0, 0);
            break;

        case 6 : /* rescale */
            RescaleOp rop = new RescaleOp(1.1f, 20.0f, null);
            g2.drawImage(bi, rop, 0, 0);
            break;

        case 7 : /* lookup */
            byte lut[] = new byte[256];
            for (int j=0; j<256; j++) {
                lut[j] = (byte)(256-j); 
            }
            ByteLookupTable blut = new ByteLookupTable(0, lut); 
            LookupOp lop = new LookupOp(blut, null);
            g2.drawImage(bi, lop, 0, 0);
            break;

        default :
        }
    }
}