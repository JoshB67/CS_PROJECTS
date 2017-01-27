package prac;

public class MyMixedPair<P,Q> {
	
	private P thing1;
	private Q thing2;
	
	
	public MyMixedPair(P p, Q q) {
		this.thing1 = p; // represent that as whatever I pass into my constructor
		this.thing2 = q;
	}
	
	public P getThing1() {
		return this.thing1;
	}
	
	public Q getThing2() {
		return this.thing2;
	}
	
	public String toString() {
		return "[" + thing1 + ":" + thing2 + "]";
	}

}
