
public class Singleton {

	private static Singleton theInstance = new Singleton();
	public static Singleton getInstance() {
		return theInstance;
	}
	
	private Singleton() {
	}
	
}
