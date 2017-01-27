import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Some test cases distributed as part of the project.
 */
public class PublicTests {

	
	/**
     * Utility function Given a String, return a list consisting of one
     * character Strings
     */
    public static List<String> makeListOfCharacters(String s) {
        List<String> lst = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++)
            lst.add(s.substring(i, i + 1));
        return lst;
    }

    /**
     * Test adding to a Bag
     * 
     */
    @Test
    public void testDenseBagAddSizeUniqueElements() {
        List<String> lst = makeListOfCharacters("aaabbc");
        DenseBag<String> b = new DenseBag<String>();
        b.addAll(lst);
        assertEquals(6, b.size());
        assertEquals(3, b.uniqueElements().size());
    }

    /**
     * Test checking if a Bag contains a key, and the count for each element
     * 
     */
    @Test
    public void testDenseBagContainsAndCount() {
        List<String> lst = makeListOfCharacters("aaabbc");
        DenseBag<String> b = new DenseBag<String>();
        b.addAll(lst);
        assertEquals(6, b.size());
        assertEquals(3, b.uniqueElements().size());
        assertTrue(b.contains("a"));
        assertTrue(b.contains("b"));
        assertTrue(b.contains("c"));
        assertFalse(b.contains("d"));
        assertEquals(3, b.getCount("a"));
        assertEquals(2, b.getCount("b"));
        assertEquals(1, b.getCount("c"));
        assertEquals(0, b.getCount("d"));
    }

 
}