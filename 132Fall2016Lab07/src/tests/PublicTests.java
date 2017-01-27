package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import implementation.MyArrayStack;
import implementation.MyLinkedListStack;
import implementation.MyStack;

import org.junit.Test;
import implementation.MyArrayStack;
import implementation.MyLinkedListStack;
import implementation.MyStack;

import org.junit.Test;
import implementation.MyArrayStack;
import implementation.MyLinkedListStack;
import implementation.MyStack;

public class PublicTests {

	@Test
	public void testEashArrayImplementation() {
		stackTest(new MyArrayStack<Integer>());
	}
	
	@Test
	public void testEasyLinkedListImplementation() {
		stackTest(new MyLinkedListStack<Integer>());
	}
	
	private static void stackTest(MyStack<Integer> s) {
		s.push(5);
		s.push(8);
		s.push(11);
		assertTrue(s.pop().equals(11));
		assertTrue(s.pop().equals(8));
		assertTrue(s.pop().equals(5));
		
	}

}
