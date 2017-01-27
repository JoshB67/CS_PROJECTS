import java.util.ArrayList;
import java.util.Iterator;

public class Factorial implements Iterable<Long>{
	private int lowerLimit;
	private int upperLimit;
	ArrayList<Integer> myList = new ArrayList<Integer>();

	public Factorial(int lowerLimit, int upperLimit){
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
	public int Factorial(int lowerLimit, int upperLimit){
		Factorial x = new Factorial(lowerLimit, upperLimit);
		
		int result = 1;
		
		for(int i = lowerLimit; i<upperLimit; lowerLimit++){
			result = result*i;
			
		}
		
		
		for(Long y : x){
			System.out.println(y);
		}
	}
		
	//between [lowerLimit, upperLimit]

	
	@Override
	public Iterator<Long> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String toString(){
		return lowerLimit;
	}


}



