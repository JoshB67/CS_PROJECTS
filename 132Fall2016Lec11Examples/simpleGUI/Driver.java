package simpleGUI;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Driver {
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Simple Example");
		frame.setContentPane(new SimpleGUI1());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
