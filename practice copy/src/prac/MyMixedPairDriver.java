package prac;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MyMixedPairDriver {

	public static void main(String[] args) {
		
		ArrayList<MyMixedPair<Integer, String>> list = new ArrayList<>(); // making an empty AL

		int ask = Integer.parseInt(JOptionPane.showInputDialog("Enter some number: "));
		
		for (int i = 0; i <= ask; i++) {
			
			String binary = Integer.toBinaryString(i);
			
			MyMixedPair<Integer, String> pair = new MyMixedPair<>(i, binary);
			
			list.add(pair);
		}
		
		System.out.println("Here they are: ");
		for (MyMixedPair<Integer,String> x : list) {
			System.out.println(x);
		}
	
	}
	

}
