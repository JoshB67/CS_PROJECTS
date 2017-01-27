package abstractClassExample;

public class Octagon extends Shape{

	public Octagon(int size) {
		super(size);
	}
	
	@Override
	public void drawMe() {
		System.out.println("Drawing Octagon of size " + getSize());
	}

}
