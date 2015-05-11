package pe.knomo.snippets.robot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RobotMainTest {

	static Robot robot = null;
	
	public static void main(String[] args) throws AWTException {
		
		ScreenshotBot ssBot = new ScreenshotBot();
		ssBot.start();
	}
	
	public static void simpleScreenshotTest(){
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Rectangle screenRectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bi = robot.createScreenCapture(screenRectangle);
		try {
			ImageIO.write(bi, "PNG", new File("rsc/screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
