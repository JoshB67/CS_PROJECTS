package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultTest {

	@Test
	public void testMultipy() {
		Mathy test = new Mathy();
		int result = test.multNum(3,3);
		assertEquals(9, result);
	}

}
