
public class Cat {
	private String breed;
	private String name;
	private int size;
	private double weight;
	
	
	public Cat(String b, String n, int s, double w) {
		this.breed = b;
		this.name = n;
		this.size = s;
		this.weight = w;
	}
	
	public boolean equals(Cat other) { //My example of an equals method
		if (other == this) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (!(other instanceof Cat)) {
			return false;
		}
		Cat temp = (Cat)other;
		if(this.breed.equals(temp.breed) && this.name.equals(temp.name)
			&& this.size == temp.size && this.weight == temp.weight){
			return true;
		}else{
			return false;
		}
			
	}
	
	public Cat(Cat copy){ //My example of a copy-constructor
		this.breed = copy.breed;
		this.name = copy.name;
		this.size = copy.size;
		this.weight = copy.weight;
	}
	
	
}
