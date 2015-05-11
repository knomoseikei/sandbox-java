package pe.knomo.snippets.image.save;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SaveImageTest {

	/**
	 * @param args
	 */
	public static void main(String s[]) {
      JFrame f = new JFrame("Save Image Sample");
      f.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {System.exit(0);}
      });
      SaveImageComponent si = new SaveImageComponent();
      f.add("Center", si);
      JComboBox choices = new JComboBox(si.getDescriptions());
      choices.setActionCommand("SetFilter");
      choices.addActionListener(si);
      JComboBox formats = new JComboBox(si.getFormats());
      formats.setActionCommand("Formats");
      formats.addActionListener(si);
      JPanel panel = new JPanel();
      panel.add(choices);
      panel.add(new JLabel("Save As"));
      panel.add(formats);
      f.add("South", panel);
      f.pack();
      f.setVisible(true);
  }

}
