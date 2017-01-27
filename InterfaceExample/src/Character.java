
public class Character extends Archetype implements characterActions{

	
	private static final String James = null;
	
	Archetype warrior = new Archetype(James, 27, 100, 10, Mallet);

	
	@Override
	public void swordSound() {
		System.out.println("SWOOSH!!!!");
	}

	@Override
	public void shieldSound() {
		System.out.println("CLANK!!!!");
	}

	@Override
	public void warSound() {
		System.out.println("YAHHHHH!!!!");
	}

	@Override
	public int playerHealth() {
		return 100;
	}

	@Override
	public int playerDamage() {
		return 10;
	}

}
