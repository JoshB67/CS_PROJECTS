package abstractClassExample;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>(); //List<Shape>>...polymorphism
		list.add(new Circle(5)); //remember the new keyword for adding objects to the list
		list.add(new Octagon(7));
		list.add(new Circle(26));
		list.add(new Triangle(2));
		list.add(new Triangle(91));
		for (Shape s : list) { //the compiler asks if all shape s has the drawMe() Method for all shapes!
			s.drawMe(); //at every iteration it's polymorphic, it's late binding goes to the reference type strictly the type
		}
	}

}
