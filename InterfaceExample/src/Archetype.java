
public class Archetype {
	
	private String name;
	private int age;
	private int healthPoints;
	private int damagePoints;
	private String weapon;
	
	
	public Archetype(String localName, int localAge, int localHP, int localDamage, String localWeapon){
		this.name = localName;
		this.age = localAge;
		this.healthPoints = localHP;
		this.damagePoints = localDamage;
		this.weapon = localWeapon;
	}
	
	
	public String concat(String one, String two){
		return one + two;
	}
	
	public int damage(int healthPoints, int damagePoints){
		return healthPoints - damagePoints;
	}

	public String toString(String name){
		return name;
	}

	
}
