package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import implementation.Database;

public class PublicTests {
//	static Database db;
//	static {
//		db = new Database();
//		db.add("Joe", "CMSC131");
//		db.add("Fred", "CMSC131");
//		db.add("Susan", "CMSC131");
//		db.add("Susan", "CMSC132");
//		db.add("Susan", "CMSC250");
//		db.add("Sam", "CMSC131");
//		db.add("Sam", "CMSC132");
//	}
	
	@Test
	public void conTest() {
		Database db = new Database();
		assertTrue(db.courses != null);
	}
	
	@Test
	public void testIntialAdd() {
		// testing that the student is not already in the list
		Database db = new Database();
		db.add("James", "CMSC132"); 
		// keys in the map before that call and after that call:
		
		
		
		// test code
		ArrayList<String> value = db.courses.get("James");
		assertTrue(value.contains("CMSC132"));
		//assertTrue();
	}
	
	@Test
	public void testMultipleAdd(){
		Database db = new Database();
		
		db.add("James", "CMSC132");
		db.add("James", "CALC2");
		
		
		ArrayList<String> value = db.courses.get("James");
		assertTrue(value.contains("CMSC132"));
		assertTrue(value.contains("CALC2"));
	}
	
	
	@Test
	public void testRemove() {
		Database db = new Database();
		
		db.add("Wells", "CMSC450");
		db.add("Wells", "CMSC754");
		db.remove("Wells", "CMSC450");
		
		ArrayList<String> value = db.courses.get("Wells");
		assertFalse(value.contains("CMSC450"));
	}
	
	
	@Test
	public void testRemoveNotPresent() {
		Database db = new Database();
		
		db.remove("Tony", "Hist357");
		
		ArrayList<String> value = db.courses.get("Tony");
		assertTrue(value == null);
		
	}
	
	// there are no entries in the map - is anyone taking CMSC132?
			// James is taking "CMSC132" - is anyone taking CMSC132?
			// James and Wells are Taking CALC2 - is anyone taking CMSC132?
	
	@Test
	public void testIsAnyoneTakingEmptyDB() {
		// create empty Database
		Database db = new Database();
		// check if anyone is taking CMSC132
		Boolean logic = db.isAnyoneTaking("CMSC132");
		
		assertFalse(logic);

	}
	
	@Test
	public void testIsAnyoneTakingTrue() {
		// create empty Database
		Database db = new Database();
		// add James is taking CMSC132 to the Database
		db.add("James", "CMSC132");
		// is anyone taking CMSC132 at all
		assertTrue(db.isAnyoneTaking("CMSC132"));
	}
	
//	@Test
//	public void testSimple1() {		
//		assertTrue(db.courses.size() == 4);  // there are 4 students (keys)
//	}
	
//	@Test
//	public void testSimple2() {
//		List<String> courseList = db.courses.get("Susan");
//		assertTrue(courseList.size() == 3);  // Susan is taking 3 courses
//	}
//		
//	@Test
//	public void testSimple3() {
//		db.remove("Sam", "CMSC433");
//		db.remove("Sam", "CMSC411");
//		List<String> courseList = db.courses.get("Sam");
//		assertTrue(courseList.size() == 2);   // nothing happened
//		db.remove("Sam", "CMSC131");
//		courseList = db.courses.get("Sam");
//		assertTrue(courseList.size() == 1);   // one course was removed
//	}
//	
//	@Test
//	public void testSimple4() {
//		assertTrue(db.isAnyoneTaking("CMSC132"));
//		assertFalse(db.isAnyoneTaking("CMSC430"));
//	}

}
