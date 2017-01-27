package tests;

import java.util.NoSuchElementException; 
import static org.junit.Assert.*;  

import org.junit.Test; 	

import searchTree.EmptyTree;
import searchTree.SearchTreeMap;
import searchTree.Tree;


public class PublicTests{


	@Test
	public void testEasyBSTSearch() {
		Tree<Integer,String> t = EmptyTree.getInstance();
		assertTrue(t.search(0) == null);
		t = t.insert(5, "THIS IS 5");
		assertEquals("THIS IS 5", t.search(5));
		t = t.insert(8, "THIS IS 8");
		assertEquals("THIS IS 8", t.search(8));
	}


	@Test
	public void testEmptySearchTreeMap() {
		SearchTreeMap<String, Integer> s = new SearchTreeMap<String, Integer>();
		assertEquals(0, s.size());
		try {
			assertEquals(null, s.getMin());
			fail("Should have thrown NoSuchElementException");
		} catch (NoSuchElementException e) {
			assert true; // as intended
		}
		try {
			assertEquals(null, s.getMax());
			fail("Should have thrown NoSuchElementException");
		} catch (NoSuchElementException e) {
			assert true; // as intended
		}
		assertEquals(null, s.get("a"));
	}


	@Test
	public void testBasicSearchTreeMapStuff() {

		SearchTreeMap<Integer,String> s = new SearchTreeMap<Integer,String>();

		assertEquals(0, s.size());
		s.put(2, "Two");
		s.put(1, "One");
		s.put(3, "Three");
		s.put(1, "OneSecondTime");

		assertEquals(3, s.size());
		assertEquals("OneSecondTime", s.get(1));
		assertEquals("Two", s.get(2));
		assertEquals("Three", s.get(3));
		assertEquals(null, s.get(8));

	}


	@Test
	public void testingInsert() {

		Tree<String, Integer> itree = EmptyTree.getInstance();

		Tree<Integer, String> peachTree = new EmptyTree<Integer, String>();

		Tree<String, Integer> actual = itree.insert("Bart", 10); // key-value pairings


		peachTree = peachTree.insert(39, "Homer");
		peachTree = peachTree.insert(37, "Marge");
		peachTree = peachTree.insert(2, "Maggie");
		Integer expected = 10;

		assertEquals(expected , actual.search("Bart"));
		
		assertEquals("Homer" , peachTree.search(39));
		assertEquals("Marge" , peachTree.search(37));
		assertEquals("Maggie" , peachTree.search(2));

	}


	@Test
	public void testingInsertAgain() {

		Tree<Integer, String> peachTree = new EmptyTree<Integer, String>();

		Tree<Integer, String> one = peachTree.insert(10, "Bart"); // key-value pairings
		Tree<Integer, String> two = peachTree.insert(39, "Homer");
		Tree<Integer, String> three = peachTree.insert(37, "Marge");
		Tree<Integer, String> four = peachTree.insert(2, "Maggie");

		assertEquals("Bart" , one.search(10));
		assertEquals("Homer" , two.search(39));
		assertEquals("Marge" , three.search(37));
		assertEquals("Maggie" , four.search(2));

	}


	@Test public void testThatInsert() {

		Tree<String, Integer> appleTree = new EmptyTree<String, Integer>();

		Tree<String, Integer> actualOne = appleTree.insert("Bill", 60);
		Tree<String, Integer> actualTwo = appleTree.insert("Sarah", 21);
		Tree<String, Integer> actualThree = appleTree.insert("Soren", 38);
		Tree<String, Integer> actualFour = appleTree.insert("Jack", 365);

		Integer expectedOne = 60;
		Integer expectedTwo = 21;
		Integer expectedThree = 38;
		Integer expectedFour = 365;

		assertEquals(expectedOne, actualOne.search("Bill"));
		assertEquals(expectedTwo, actualTwo.search("Sarah"));
		assertEquals(expectedThree, actualThree.search("Soren"));
		assertEquals(expectedFour, actualFour.search("Jack"));

	}
	

	@Test
	public void testingMax() {

		Tree<Double, String> numTree = EmptyTree.getInstance();

		numTree = numTree.insert(new Double(3.14), "pi");
		numTree = numTree.insert(new Double(2.71), "e");
		numTree = numTree.insert(new Double(0.571), "Econst");
		numTree = numTree.insert(new Double(7.0), "Luck");

		try{
			assertEquals(new Double(7.0), numTree.max());
		} catch (Exception e) {
		}
		
	}
	
	
	@Test
	public void testingMin() {

		Tree<Double, String> numTree = EmptyTree.getInstance();

		numTree = numTree.insert(new Double(3.14), "pi");
		numTree = numTree.insert(new Double(2.71), "e");
		numTree = numTree.insert(new Double(0.571), "Econst");
		numTree = numTree.insert(new Double(7.0), "Luck");

		try{
			assertEquals(new Double(0.571), numTree.min());
		} catch (Exception e) {
		}
		
	}


	@Test
	public void testingDelete() {

		Tree<Integer, String> hollyTree = EmptyTree.getInstance();
		Tree<Integer, String> WillowTree = EmptyTree.getInstance();

		hollyTree = hollyTree.insert(10, "Yep");
		hollyTree = hollyTree.delete(10);

		assertEquals(hollyTree, WillowTree);

	}

	
//	private String toString() {
//	String result = "";
//	
//	if (this.left.size() == 0) {
//	}
//	if (this.left.size() > 0) {
//		result += left.toString();
//	}
//	
//	result += this.key.toString() + " " + this.value.toString();
//
//	if (this.right.size() == 0) {
//	}
//	if (this.right.size() > 0) {
//		result += right.toString();
//	}
//	return result;
//	
//}
	
	
	// call toString on a populated tree 
	@Test
	public void testingPrintTree() {
		
		Tree<Double, String> oakTree = EmptyTree.getInstance();
		
		oakTree = oakTree.insert(10.5, "-> (ok) ");
		oakTree = oakTree.insert(16.7, "-> (yeah) ");
		oakTree = oakTree.insert(19.8, "-> (hey) ");
		oakTree = oakTree.insert(32.9, "-> (what) ");
		
		System.out.println(oakTree.toString());
	}
	
	
	// call toString on an empty tree
	@Test
	public void testingPrintAnEmptyTree() {
		Tree<Double, String> oakTree = EmptyTree.getInstance();
		
		System.out.println(oakTree.toString());
	}

	
	@Test
	public void testDeleteAgain() {

		Tree<Integer, String> appleTree = EmptyTree.getInstance();

		appleTree = appleTree.delete(5);
		appleTree = appleTree.delete(9);

		assertNull(appleTree.search(5));
		assertNull(appleTree.search(9));

	}


	@Test
	public void testingSizeEmpty() {

		Tree<Integer, String> pineTree = EmptyTree.getInstance();
		assertEquals(pineTree.size(), 0);

	}
	
	
	@Test
	public void testingSizeWithStuff() {

		Tree<Integer, String> pineTree = EmptyTree.getInstance();
		pineTree = pineTree.insert(8, "Eight");
		pineTree = pineTree.insert(2, "Two");
		pineTree = pineTree.insert(11, "Eleven");
		pineTree = pineTree.insert(23, "Twenty-Three");
		
		pineTree.delete(8);
		assertEquals(3, pineTree.size());
		assertEquals(null, pineTree.search(8));
		
	}
	
	
	@Test
	public void testingSearch() {

		Tree<Integer, String> pineTree = EmptyTree.getInstance();

		assertEquals(null, pineTree.search(2));
	}


}