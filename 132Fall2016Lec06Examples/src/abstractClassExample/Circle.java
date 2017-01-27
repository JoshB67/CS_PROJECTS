package abstractClassExample;

public class Circle extends Shape{

	public Circle(int size) { //constructor method which implements super(size)
		super(size);
	}
	
	@Override
	public void drawMe() {
		System.out.println("Drawing Circle of size " + getSize());
	}

	
}
