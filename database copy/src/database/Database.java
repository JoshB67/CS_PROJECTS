package implementation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Database {


	/* Leave this public for our testing */
	public Map<String, ArrayList<String>> courses; // key = string, value = List<String. Use the instance variable


	public Database() {
		Collections.emptyMap();
	}
	
	


	public void add(String student, String course) { //key, value

//		To get the list for a kid: list = map.get(kid); // may return null if no kid in map 
//		To create a new list: list = new ArrayList<String>(); // only necessary if above is null 
//		To put into map: map.put(kid,list); // only necessary if above is null 
//		To add game to list: list.add(game);
		
		
		ArrayList<String> list = courses.get(student);
		
		
		if (list == null) {
			list = new ArrayList<String>();
			courses.put(student, list);
			//list.add(course);
		} else {
			list.add(course);
	}
	}
		
	
//        
//		 ArrayList<String> coursesTaking = courses.get(student); //extracts the games that kid is currently taking and stores it in gamesTaking
//         
//	      //  ArrayList<String> varList = new ArrayList<String>(); //creating an arrayList to store courses from method parameter variable
//	        
//	        ArrayList<String> list = new ArrayList<>();
//	        
//	    
//	        
//	        if (coursesTaking == null) {
//	        	list = courses.get(student);
//	        	list.add(course);
//	            courses.put(student, list);
//	        } else if (coursesTaking != null){
//	        	list = courses.get(student);
//	        	list.add(course);
//	            courses.put(student, list);
//	        }
		
		
		
		
		
		
//		ArrayList<String> myKeyList = new ArrayList<>();
//
//		ArrayList<String> myCourseList = new ArrayList<>();
//		
//	
//		Map<String, ArrayList<String>> hMap = new HashMap<String, ArrayList<String>>();
//		
//
//		Iterator<Map.Entry<String, ArrayList<String>>> mapIter = hMap.entrySet().iterator();
//		
//		
//		while (mapIter.hasNext()) {
//			
//		    Map.Entry<String, ArrayList<String>> entry = mapIter.next();
//		    
//		    myKeyList.add(entry.getKey());
//		    myCourseList.add(entry.getValue());
//
//
//		}
//		
//		
//		
//		for(Map.Entry<String, ArrayList<String>> z : courses.entrySet()) {
//			//myKeys = z.getKey(); //get keys
//			myCourses = z.getValue(); //get values
//			hMap.put(myKeys, myCourses);
//			
//			
//			
//			}
//		
//		for (String x : z.getKey()) {
//			myList.add(x);
//		}
//		
//		for(ArrayList<String> y : ) {
//			
//		}
//			
//		
//	}
//	
//		
//	
//		
//		
//		ArrayList<String> temp = courses.get(student);
//		
//		courses.put(student, value)
//		
//		ArrayList<String> allCourses = new ArrayList<>();
//		
//		
////		for(String x : courses.get(student)){
////			allCourses.add(x);
////		}
//
//		//if (allCourses != null && !(allCourses.isEmpty())) {
//			allCourses.add(course);
//			courses.put(student, allCourses);
//		//}
//
//	}	


	//		courses = new HashMap<String, ArrayList<String>>();
	//		
	//		//Map<String, String> hMap = new HashMap<String, String>(); 
	//		Map<String, String> hMap = courses.get(student, course); 
	//		
	//		for(Map.Entry<String, String> entry : hMap.entrySet()) {
	//			hMap.put(student, course);
	//		}
	//		
	//		
	//		Iterator<Map.Entry<String, String>> iter = hMap.entrySet().iterator(); 
	//		while(iter.hasNext()){
	//		    String key = iter.next().getKey();
	//		    System.out.println(key+ " : " + hMap.get(key));
	//		}


	//two cases to handle
	//1. student is not in the system yet
	//2. student is already there n we are adding this course to his/her existing course list


	public void remove(String student, String course) {
		
		ArrayList<String> list = courses.get(student);

		
		if (list.contains(course) || student != null) {
			list.remove(course);
			courses.put(student, list);
		}

	}

	
	public boolean isAnyoneTaking(String course) {

		return false;  // remove this statement and do it right!
	}

	public void studentAndTheirCourses() {
		
		
		
		//courses = new HashMap<String, ArrayList<String>>();

		for(Map.Entry<String, ArrayList<String>> z : courses.entrySet()) {
			String myKey = z.getKey(); //get keys
			ArrayList<String> myList = z.getValue(); //get values


			for(String s : myList) {
				for(String l : myKey){
					
				}
			}

		}

	}

}
