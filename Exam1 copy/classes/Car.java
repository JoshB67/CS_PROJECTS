//especially helpful for sorting objects!


public class Car implements Comparable<Car>{
	private String carName;
	private String carColor;
	private int carMiles;
	private int carSpeed;
	
	public Car(String name, String color, int miles, int speed){
	this.carName = name;
	this.carColor = color;
	this.carMiles = miles;
	this.carSpeed = speed;
	}
	
	
	public String getCarName() {
		return carName;
	}


	public String getCarColor() {
		return carColor;
	}


	public int getCarMiles() {
		return carMiles;
	}


	public int getCarSpeed() {
		return carSpeed;
	}

	//the way you define equality b/w two objects
	public boolean equals(Car other){
		return this.carSpeed == other.carSpeed;
	}

	//the way you are sorting and ordering
	public int compareTo(Car temp){
		Car other = (Car)temp;
		
		if(this.getCarSpeed() > other.getCarSpeed()){
			return 1;
		}else if(this.getCarSpeed() < other.getCarSpeed()){
			return -1;
		}else{
			return 0;
		}
	
	}
	
	public static void main(String[] args) {
		Car c1 = new Car("the Civic", "Eternal Blue", 160000, 120);
		Car c2 = new Car("the Viper", "Red", 89000, 250);
		
		int result = c1.compareTo(c2);
		
		System.out.println("ComareTo result: " + result);
		
		if(result > 0){
			System.out.println(c1.getCarName() + " is faster than " + c2.getCarName());
		}else if( result < 0){
			System.out.println(c2.getCarName() + " is faster than " + c1.getCarName());
		}else{
			System.out.println(c1.getCarName() + " is the same speed as " + c2.getCarName());
		}

	}

}
