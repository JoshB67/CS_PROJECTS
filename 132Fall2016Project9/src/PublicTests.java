import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class PublicTests {

	@Test
	public void testSimpleAdd() {
		MyHashSet<String> s = new MyHashSet<String>();
		s.add("hello");
		s.add("apple");
		assertEquals(4, s.getCapacity());
		assertEquals(2, s.getSize());
	}
	
	@Test
	public void testReHash() {
		MyHashSet<String> s = new MyHashSet<String>();
		for (int i = 0; i < 1000; i++) {
			s.add("Entry " + i);
		}
		assertEquals(2048, s.getCapacity());
		assertEquals(1000, s.getSize());
	}

	@Test
	public void testNoDuplicates() {
		MyHashSet<String> s = new MyHashSet<String>();
		for (int i = 0; i < 10; i++) {
			s.add("hello");
			s.add("apple");
			s.add("cat");
			s.add("last");
		}
		assertEquals(8, s.getCapacity());
		assertEquals(4, s.getSize());
	}
	

	@Test
	public void testIterator() {
		MyHashSet<String> s = new MyHashSet<String>();
		
			s.add("hello");
			s.add("apple");
			s.add("cat");
			s.add("last");
		
		Iterator<String> iter = s.iterator();
		for(int i =  0; i < 4; i++){
		assertTrue(iter.hasNext());
		assertNotNull(iter.next());
		}
	}
	
}
