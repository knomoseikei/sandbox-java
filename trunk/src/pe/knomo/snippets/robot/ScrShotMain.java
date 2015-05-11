package pe.knomo.snippets.robot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScrShotMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
			Rectangle captureSize = new Rectangle(0, 0, 500, 500);
			File file = new File("rsc\\screen1.png");
			BufferedImage bufferedImage = robot
					.createScreenCapture(captureSize);
			ImageIO.write(bufferedImage, "png", file);
		} catch (AWTException e) {
			System.err.println("Something fishy is going on...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {

			Robot robot = new Robot();
			Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize());
			BufferedImage bufferedImage = robot
					.createScreenCapture(captureSize);
			File file = new File("scrshot\\screen2.png");
			ImageIO.write(bufferedImage, "png", file);
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
