package pe.knomo.snippets.image.resize;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTest {

	@SuppressWarnings("unused")
	private static final int IMG_WIDTH = 10;
	@SuppressWarnings("unused")
	private static final int IMG_HEIGHT = 15;

	public static void main(String[] args) {

		try {

			// ImageIO.write(resizeImageHintPng, "png", new
			// File("c:\\image\\mkyong_hint_png.jpg"));
			BufferedImage originalImage = ImageIO.read(new File("rsc/AirMech_Poster_small.jpg"));
			@SuppressWarnings("unused")
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, 450, 675);
//			resizeImageJpg = resizeImage(resizeImageJpg, 450, 675);
			ImageIO.write(resizeImageJpg, "jpg", new File("rsc/img1.jpg"));

			BufferedImage resizeImagePng = resizeImage(originalImage, 450, 675);
//			resizeImagePng = resizeImage(resizeImagePng, 450, 675);
			ImageIO.write(resizeImagePng, "png", new File("rsc/img2.png"));

			BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, 450, 675);
//			resizeImageHintJpg = resizeImage(resizeImageHintJpg, 450, 675);
			ImageIO.write(resizeImageHintJpg, "jpg", new File("rsc/img3.png"));

			BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, 450, 675);
//			resizeImageHintPng = resizeImage(resizeImageHintPng, 450, 675);
			ImageIO.write(resizeImageHintPng, "png", new File("rsc/img4.png"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.rotate(1);
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		return resizedImage;
	}

	private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int width, int height) {

		BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
}