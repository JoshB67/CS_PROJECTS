package hurricaneImplementation;

public class Hurricane implements Comparable<Hurricane> {
	private String name;
	private int windSpeed;
	private int rainFall;


	public Hurricane(String name, int windSpeed, int rainFall){
		this.name = name;
		this.windSpeed = windSpeed;
		this.rainFall = rainFall;
	}


	public String getName(){
		return this.name;
	}


	public int getWindSpeed(){
		return this.windSpeed;
	}


	public int getRainFall(){
		return this.rainFall;
	}

	
	//the equals method must be in-sync with the compareTo() in the way that method defines equality
	public boolean equals(Hurricane other){
		return this.getName() == other.getName() &&
			   this.getWindSpeed() == other.getWindSpeed() &&
			   this.getRainFall() == other.getRainFall();
	}


	public int compareTo(Hurricane temp) { //compare "natural order" based on windSpeed

		Hurricane other = (Hurricane)temp;

		if (this.equals(other)) { //now it's compatible with the equals method
			return 0;
		} else if(this.getWindSpeed() > other.getWindSpeed()) {
			return 1;
		} else {
			return -1;
		}
	}
}
