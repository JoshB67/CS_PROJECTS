
public class Painting extends Artwork{
	private int width;
	private int height;
	
	public Painting(String title, String artist, int width, int height){
	super(title, artist);
	this.width = width;
	this.height = height;
	}
	
	public Painting(String title, String artist, Painting copy){
		super(title, artist);
		this.width = copy.width;
		this.height = copy.height;
	}


	public String toString(){
		return this.width + " X " + this.height + " painting: " + 
				title + artist;
	}
	
	public static void main(String[] args){
		Painting p = new Painting("Starry night", "Van gogh", 12, 4);
		System.out.println(p.toString());
	}
}
