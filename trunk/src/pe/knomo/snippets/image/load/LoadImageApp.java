package pe.knomo.snippets.image.load;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


/**
 * This class demonstrates how to load an Image from an external file
 */
@SuppressWarnings("serial")
public class LoadImageApp extends Component {

	BufferedImage img;

	public void paint(Graphics g) {
		//img = EqfxUtil.convertBufferedImage(img, BufferedImage.TYPE_BYTE_BINARY);
		//img = EqfxUtil.scaleImage(img, 50);
		g.drawImage(img, 0, 0, null);
	}

	public LoadImageApp() {
		try {
			// img = ImageIO.read(new File("rsc/strawberry.jpg"));
			img = ImageIO.read(new File("rsc/AirMech_Poster_small.jpg"));
		} catch (IOException e) {
		}

	}

	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}
	
}