package prac;

public class MutableInteger {
	
	
	
	private static int value = -1;
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	private MutableInteger(int val){
		this.value = -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
