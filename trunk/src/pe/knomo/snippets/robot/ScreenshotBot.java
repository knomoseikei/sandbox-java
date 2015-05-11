package pe.knomo.snippets.robot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

public class ScreenshotBot extends Thread {

	private Robot robot;
	private Rectangle screenRectangle;

	@Override
	public void run() {
		for(int i = 0; i<3; i++){
			try {
				System.out.println("saving "+(i+1));
				saveScreenshot();
				Thread.sleep(4000);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void saveScreenshot() throws IOException {
		BufferedImage bi = robot.createScreenCapture(screenRectangle);
		String filename = "rsc/ss_"+Calendar.getInstance().getTimeInMillis()+".png";
		System.out.println(filename);
		File file = new File(filename);
		ImageIO.write(bi, "PNG", file);
	}

	public ScreenshotBot() throws AWTException {
		robot = new Robot();
		screenRectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	}

	public ScreenshotBot(Runnable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ScreenshotBot(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ScreenshotBot(ThreadGroup arg0, Runnable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ScreenshotBot(ThreadGroup arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ScreenshotBot(Runnable arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ScreenshotBot(ThreadGroup arg0, Runnable arg1, String arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public ScreenshotBot(ThreadGroup arg0, Runnable arg1, String arg2, long arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
