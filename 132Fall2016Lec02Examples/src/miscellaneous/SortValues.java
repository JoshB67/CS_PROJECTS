//this whole thing confuses me to no end need description of what's happening here

package miscellaneous;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;


public class SortValues {

	public static void main(String[] args) {
		ArrayList<Integer> allValues = new ArrayList<Integer>();
		final String PROMPT = "Enter integer or \"quit\" to stop";

	    /*
		String valueStr = JOptionPane.showInputDialog(PROMPT);
		while (!valueStr.equals("quit")) {
			allValues.add(Integer.parseInt(valueStr));
			valueStr = JOptionPane.showInputDialog(PROMPT);
		}
		 */

		while(true) {
			String valueStr = JOptionPane.showInputDialog(PROMPT);
			if (valueStr.equals("quit")) {
				break;
			}
			allValues.add(Integer.parseInt(valueStr));
		}


		if (allValues.size() != 0) {
			/* Sorting the values */
			Collections.sort(allValues);

			/* Printing the values */
			String output = "Values provided (in sorted order):\n";
			for (Integer item : allValues) {
				output += item + "  ";
			}
			JOptionPane.showMessageDialog(null, output);
		}
	}
}
