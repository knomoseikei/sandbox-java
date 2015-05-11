package pe.knomo.snippets.image.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShrinkImageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("rsc/AirMech_Poster_small.jpg");
		// for(String s : ImageIO.getWriterFormatNames()) System.out.println(s);
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			System.out.println(img.getData().getWidth() + " " + img.getData().getHeight() + " "
					+ img.getData().getDataBuffer().getSize());
			//img = EqfxUtil.convertBufferedImage(img, BufferedImage.TYPE_BYTE_BINARY);
			
			img = EqfxUtil.scaleImage(img, 100);

			for (int i = 0; i < img.getWidth(); i++) {
				for (int j = 0; j < img.getHeight(); j++) {
					img.setRGB(i, j, getGrayPixel(img.getRGB(i,j)));
					//System.out.print(Integer.toHexString(img.getRGB(i, j)) + "\t");
					
				}
				//System.out.println();
			}
			img = EqfxUtil.scaleImage(img, 50);

			File shrinkedFile = new File("rsc\\shrinkedFile.jpg");
			System.out.println(img.getData().getWidth() + " " + img.getData().getHeight() + " "
					+ img.getData().getDataBuffer().getSize());
			ImageIO.write(img, "jpg", shrinkedFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getGrayPixel(int pixel){
		int r = (pixel & 0xFF0000) >> 0x000010;
//		System.out.println(r + " : " + Integer.toHexString(r));

		int g = (pixel & 0x00FF00) >> 0x000008;
//		System.out.println(g + " : " + Integer.toHexString(g));

		int b = (pixel & 0x0000FF) >> 0x000000;
//		System.out.println(b + " : " + Integer.toHexString(b));

		int prom = (r + g + b)/3;
		
		
//		System.out.println(prom);
		int newR = prom << 16;
		int newG = prom << 8;
		int newB = prom << 0;
		int newPixel = newR+newG+newB;
		if(b > 127){
			newPixel = 0;
		}else{
			newPixel = 0xffffffff;
		}
		System.out.println("+"+newPixel);
		return newPixel;
	}

}
