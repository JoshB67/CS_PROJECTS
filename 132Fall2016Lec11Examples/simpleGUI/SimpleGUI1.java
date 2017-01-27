package simpleGUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI1 extends JPanel{

	private JButton button = new JButton("Don't Click");
	
	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Stop clicking that!");
		}
	}
	
	public SimpleGUI1() {
		button.addActionListener(new MyButtonListener());
		add(button);
	}

}
