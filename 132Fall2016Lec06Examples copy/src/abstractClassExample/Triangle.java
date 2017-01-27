package abstractClassExample;

public class Triangle extends Shape{

	public Triangle(int size) {
		super(size);
	}
	
	@Override
	public void drawMe() {
		System.out.println("Drawing triangle of size " + getSize());
	}

}
