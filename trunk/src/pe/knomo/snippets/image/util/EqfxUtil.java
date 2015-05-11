package pe.knomo.snippets.image.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class EqfxUtil {

	public static BufferedImage convertBufferedImage(BufferedImage src, int bufImgType) {
		BufferedImage img = new BufferedImage(src.getWidth(), src.getHeight(), bufImgType);
		Graphics2D g2d = img.createGraphics();
		g2d.drawImage(src, 0, 0, null);
		g2d.dispose();
		return img;
	}

	public static BufferedImage scaleImage(BufferedImage src, float percent) {
		float coef = percent / 100;
		int newWidth = Math.round(src.getWidth() * coef);
		int newHeight = Math.round(src.getHeight() * coef);
		BufferedImage img = new BufferedImage(newWidth, newHeight, src.getType());
		Graphics2D g2d = img.createGraphics();
		g2d.drawImage(src, 0, 0, newWidth, newHeight, null);
		g2d.dispose();
		return img;
	}

}
