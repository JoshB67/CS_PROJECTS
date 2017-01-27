package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcatTest {

	@Test
	public void ConcatTest() {
		Mathy test = new Mathy();
		String result = test.concat("one", "two");
		assertEquals("onetwo", result);
	}

}
