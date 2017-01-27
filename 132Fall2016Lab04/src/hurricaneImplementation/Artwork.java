
public class Artwork {
	private String artist;
	private String title;
	public Artwork(Artwork other) {
		artist = other.artist;
		title = other.title;
	}
	public String toString() {
		return title + " by " + artist;
	}
}


public class Painting extends Artwork {
	private int width;
	private int height;
	
	public Painting(Painting other) { //A copy-constructor?
		super(other); //Why do we need this "super" keyword? confused
		this.width = other.width; //easy copies because both are PDT's
		this.height = other.height;
	}
	
	public String toString(){
		return width + "X" + height + " painting: " + supertitle + " by " + artist;
	}
	
}