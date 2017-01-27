package eventHandlingIntro;

import java.awt.Dimension;

import javax.swing.*;
public class Driver {

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Message Board");
		int width = 450, height = 80;
		frame.setSize(new Dimension(width, height));

		/* Adds the panel to the content pane of the frame */
		frame.setContentPane(new MessageJPanel());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		/* Shows the GUI */
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		/* Scheduling the GUI processing in the EDT */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}