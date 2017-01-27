package innerClassExamples;

import javax.swing.JOptionPane;

public class PrimeNumberDriver {

	public static void main(String[] args) {
		String answer = JOptionPane.showInputDialog("How many primes?");
		int numberOfPrimes = Integer.parseInt(answer);
		PrimeNumberList list = new PrimeNumberList(numberOfPrimes);
		for (Integer value : list) {
			System.out.println(value);
		}
	}

}
