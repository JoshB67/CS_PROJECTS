package implementation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Database {


	/* Leave this public for our testing */
	public Map<String, ArrayList<String>> courses; // key = string, value = List<String. Use the instance variable


	//List<String> courses;

	public Database() {
		//courses = new ArrayList<String>();
		courses = new HashMap< String, ArrayList<String> >();
	}

	public void add(String student, String course) {

		// Create an ArrayList of String which extracts the courses from the student parameters
		ArrayList<String> value = courses.get(student); // local variables is value

		// check if the courses is not null, therefore the student has courses
		if (value != null){
			System.out.println("student in the map");
			// add course to the existing list
			value.add(course);

		} else { // therefore it follows that student is not in the list 
			String key = student; // create a String variable key to store student

			value = new ArrayList<String>(); // creates an empty ArrayLst

			value.add(course);

			courses.put(key, value);
			System.out.println("student not in map");
		}


	}


	public void remove(String student, String course) {
		// get the courses being taken by the student
		ArrayList<String> values = courses.get(student);
		// is student in the map?
		if ( values != null) { // student is in the map
			// remove the variable course from the students ArrayList
			values.remove(course);			
		} else { // student is not in the map
			// do nothing
		}

	}

	public boolean isAnyoneTaking(String course) {
		
		return false;
	}

}