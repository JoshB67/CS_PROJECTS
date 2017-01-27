package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class testerJ {

	@Test
	public void testingAdd() {
		Junit test = new Junit;
		String result = test.practice("one","two");
		assertEquals("OneTwo",result);
	}

}
