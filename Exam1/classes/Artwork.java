
public class Artwork {
	public String artist;
	public String title;
	
	
	public Artwork(String title, String artist){
		this.artist = artist;
		this.title = title;
	}
	
	public Artwork(Artwork copy){ //copy constructor
		this.artist = copy.artist;
		this.title = copy.title;
	}
	
	public String toString() {
		return title + " by " + artist;
	}
	
	public void setTitle(String s){
		this.title = s;
	}
	
	public static void main(String[] args){
		
	}
	
}
