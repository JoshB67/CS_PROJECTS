package abstractClassExample;

import java.awt.Color;

public abstract class Shape {

	private int size;
	private Color color;
	
	public Shape(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	public Color getColor() {
		return color;
	}
	
	abstract public void drawMe(); //a method prototype because it states abstract
}
