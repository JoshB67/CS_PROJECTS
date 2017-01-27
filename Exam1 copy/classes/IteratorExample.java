import java.util.ArrayList;
import java.util.Iterator;


public class IteratorExample {


	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++){
			myList.add( (int) (Math.random()*10) + 1);
		}
		//after they are filled
		Iterator<Integer> iter = myList.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	
}
