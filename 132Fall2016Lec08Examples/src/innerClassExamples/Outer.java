package innerClassExamples;

public class Outer {
	
	private int x = 4;
    private void printHi() {
    	System.out.println("HI");
    }
    
    public class Inner {
    	private int y = 12;
    	private void foo() {
    		x = 7;       // accessing state of outer class object
    		printHi();   // running method on outer class object
    	}
    }
    
    private void bar() {
    	Inner innerObject = new Inner();
    	innerObject.foo();
    	innerObject.y = 15;
    }

}
