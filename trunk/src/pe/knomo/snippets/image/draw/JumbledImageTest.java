package pe.knomo.snippets.image.draw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JumbledImageTest {
	public static void main(String[] args) {

		JFrame f = new JFrame("Jumbled Image");

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		final JumbledImage ji = new JumbledImage(new File("rsc/lexi_recycle.png"));
		
		JButton jumbleButton = new JButton("Jumble");
		jumbleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ji.jumble();
				ji.repaint();
			};
		});

		f.add("Center",ji);
		f.add("South",jumbleButton);
		f.pack();
		f.setVisible(true);
	}
}
