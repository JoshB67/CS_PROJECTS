import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PairDriver {

	public static void main(String[] args) {
		
			// Pair<String> p = new Pair<String>("Apple", "Bananna");

			ArrayList< Pair<String> > list = new ArrayList< Pair<String> > ();
			
			
			// Nesting generics
			
			int pairs = Integer.parseInt(JOptionPane.showInputDialog("How many pairs will you enter?"));
			
			
			for (int i = 0; i < pairs; i++) {
				
				String left = JOptionPane.showInputDialog("Left: ");
				
				String right = JOptionPane.showInputDialog("Right: ");
				
				Pair<String> pair = new Pair<String>(left, right);
				
				list.add(pair);
			}
			
			System.out.println("Here are your pairs: ");
			for (Pair<String> p : list) {
				System.out.println(p);
			}
		
	}

}
