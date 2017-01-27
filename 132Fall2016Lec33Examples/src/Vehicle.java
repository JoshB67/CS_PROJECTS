
public class Vehicle {

	
	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		System.out.println(v);
	}
	public String toString(){
		return "Hello world, i am an instance of " + super.toString();
	}
}
