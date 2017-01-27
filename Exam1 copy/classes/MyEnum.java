
public enum MyEnum {
	//so these are basically object constants
	GF1("Tiffany", "evil", 17),
	GF2("Ashely", "wonderful", 20),
	GF3("Animegirl", "crazy", 24);
	
	
	private final String name; //why not static?
	private final String descr; //why not static?
	private final int myAge; //why not static?
	
	
	private MyEnum(String name, String descr, int myAge){
		this.name = name;
		this.descr = descr;
		this.myAge = myAge;
	}
	
	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	
	public int getMyAge(){
		return myAge;
	}
	
	
	
}
