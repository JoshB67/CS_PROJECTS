package innerClassExamples;

public class InnerOuterDriver {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner(); //what's happening here exactly?
	}

}
