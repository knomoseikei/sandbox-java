package pe.knomo.snippets.image.load;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ImageTest {
	public static void main(String[] args) {

		JFrame f = new JFrame("Load Image Sample");

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.add(new LoadImageApp());
		f.pack();
		f.setVisible(true);
	}
}
