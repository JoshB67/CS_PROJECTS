package simpleGUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI2 extends JPanel{

	private JButton button = new JButton("Don't Click");
	
	public SimpleGUI2() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Stop clicking that!");
			}
		});
		add(button);
	}
}
