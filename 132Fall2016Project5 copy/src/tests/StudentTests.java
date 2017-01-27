package tests;

import static org.junit.Assert.*;
import listClasses.BasicLinkedList;

import org.junit.Test;

public class StudentTests {

	//run down the list of possible test scenarios by emulating a similar coding environment
	//list of size 0 and of size 1
	
	
	@Test
	public void testGetFirst() {
		
		//checking to see if when something is added to front that it can be accessed with getFirst()!
		System.out.println("Testing GetFirst!");
		BasicLinkedList<String> b = new BasicLinkedList<>();
		b.addToFront("Cat"); //add to front of b list
		assertTrue(b.getFirst().equals("Cat")); //check if it's there
	
	}
	
	
	@Test
	public void testGetFirstMaybeEmpty() {
		
		System.out.println("Testing GetFirstMaybeEmpty!");
		BasicLinkedList<String> x = new BasicLinkedList<>();
		assertNull(x.getLast()); //Asserts that this should be null since nothing has been added to x list
		assertTrue(x.isEmpty()); //Asserts that this should be true if you haven't added anything it should be empty, therefore 0
		assertEquals(0, x.getSize()); //Asserts that the length should be 0 if nothing has been added
	}
	
	
	@Test
	public void testGetLast() {
		
		//checking to see that when something has been added to end that it can be accessed with getLast()!
		System.out.println("Testing GetLast!");
		BasicLinkedList<String> z = new BasicLinkedList<>();
		z.addToEnd("Dog"); //add to end of z list
		assertTrue(z.getLast().equals("Dog")); //check if it's there
		
	}
	
	
	@Test
	public void testGetLastMaybeEmpty() {
		
		System.out.println("Testing GetFirstMaybeEmpty!");
		BasicLinkedList<String> c = new BasicLinkedList<>();
		assertNull(c.getLast()); //Asserts that this should be null since nothing has been added to c list
		assertTrue(c.isEmpty()); //Asserts that this should be true if you haven't added anything it should be empty, therefore 0
		assertEquals(0, c.getSize()); //Asserts that the length should be 0 if nothing has been added
		
	}
	
	
	@Test
	public void testRetriveFirst() {
		
		System.out.println("Testing retreivefirst!");	
		BasicLinkedList<String> sut = new BasicLinkedList<>();
		sut.addToFront("Mouse");
		assertTrue(sut.retrieveFirstElement().equals("Mouse")); //Asserts that an object is null. If you didn't add anything in there then null elements
		
	}

	
	@Test
	public void testRetriveLast() {
		
		System.out.println("Testing RetreiveLast!");
		BasicLinkedList<String> sut2 = new BasicLinkedList<>();
		sut2.addToEnd("Lizard");
		assertTrue(sut2.retrieveLastElement().equals("Lizard"));
		
	}
	
	
	@Test
	public void testRemoveAllInstances() {
		//System.out.println(sut3.addToFront("Goat"));
		System.out.println("Testing removeAllInstances!");
		BasicLinkedList<String> sut3 = new BasicLinkedList<>();
		sut3.addToFront("Goat");
		//sut3.removeAllInstances("Goat");

		assertEquals(null,sut3.removeAllInstances("Goat"));
		//assertNull(sut3.removeAllInstances("Goat"));
	}
	
	
	@Test
	public void testForEmptyList() {
		
		//checking for empty lists:
		System.out.println("Testing for an empty list!");
		BasicLinkedList<String> sut4 = new BasicLinkedList<>();
		assertNull(sut4.retrieveLastElement());
		assertNull(sut4.retrieveFirstElement());
		assertNull(sut4.getLast());
		assertNull(sut4.getFirst());
		
	}
	
	
	@Test
	public void testForListSizeOne() {
		//checking for list of with just size one:
		System.out.println("Testing for an list of size one!");
		BasicLinkedList<String> sut5 = new BasicLinkedList<>();
		sut5.addToFront("Hat");
		
		assertEquals(1,sut5.getSize());
		assertEquals("Hat",sut5.getFirst());
		assertEquals("Hat",sut5.getLast());
		assertEquals("Hat",sut5.retrieveLastElement());
		//assertEquals("Hat",sut5.retrieveFirstElement());
	}
	
	
}