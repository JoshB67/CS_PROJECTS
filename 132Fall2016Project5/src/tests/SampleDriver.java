package tests;

import listClasses.BasicLinkedList;

public class SampleDriver {

	public static void main(String[] args) {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue");
		
		//red added to end.....red
		//yellow added to front.....yellow red
		//then blue added to front..... blue yellow red
		//should look like: Blue Yellow Red
		
		System.out.println("First: " + basicList.getFirst()); //seems correct: Blue
		System.out.println("Last: " + basicList.getLast()); //seems correct: Red
		System.out.println("Size: " + basicList.getSize()); //seems correct: 3
		System.out.println("Retrieve First: " + basicList.retrieveFirstElement()); //seems correct: Blue
		System.out.println("Retrieve Last: " + basicList.retrieveLastElement()); //seems correct: Red
		System.out.println("Removing Red"); 
		basicList.removeAllInstances("Red"); //so now we have blue yellow
		System.out.print("Iteration: ");
		
		for (String entry : basicList) {
			System.out.print(entry + " ");
		}
		//should print blue yellow
	}

}