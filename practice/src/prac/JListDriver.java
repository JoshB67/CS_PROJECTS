package prac;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class JListDriver {
// nothing needed up here
	
	public static void main(String[] args) {
		ArrayList< JList<String> > list = new ArrayList< JList<String> >();
		
		int howMany = Integer.parseInt(JOptionPane.showInputDialog("So how many pairs would you like?"));
		
		for (int i = 0; i < howMany; i++){
			
			String left = JOptionPane.showInputDialog("Enter left thing: ");
			String right = JOptionPane.showInputDialog("Enter right thing");
			
			JList<String> JL = new JList<String>(left,right);
			// the T type you specified was OVERALL a string, but the constructor takes in two strings
			// why can't we use anytype T for where all the string are?
			list.add(JL);
		}
		
		System.out.println("Here are your pairs: ");
		for (JList<String> x : list) {
			System.out.println(x);
		}

	}

}
