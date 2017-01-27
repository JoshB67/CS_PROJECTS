package snacks;

/* Cookies come in three varieties.  Chocolate Chip
 * and Oatmeal cookies are round; Lemon Square Cookies 
 * are Squares.
 */
public class Cookie extends Snack { 

	//WHAT'S THE PURPOSE OF THESE ENUMS? WHY ARE THEY HERE?
	public enum CookieType {CHOCOLATE_CHIP("Chocolate Chip"), 
						OATMEAL("Oatmeal"), 
						LEMON_SQUARE("Lemon Square");

		private String name; //OK INSTANCE VARIABLES GOTCHA
		
		CookieType(String name) { //BUT WHAT'S THIS DOING? IS IT A CONSTRUCTOR?
			this.name = name;
		}
		
		public String toString() { //OK toSting() METHOD GOTCHA
			return name;
		}
	}

	public Cookie(CookieType type) { //HUH? FIRST A CONSTRUCTOR THEN ANOTHER CONSTRUCTOR?
		super(type + " Cookie"); //WHY THIS SUPER KEYWORD IS NEEDED? CONFUSED HERE
	}

	/* Round cookies have a diameter.
	 * Square cookies have a width.
	 */
	@Override //I THOUGHT WITH INHERITANCE YOU DIDN'T HAVE TO OVERRIDE ABSTRACT METHODS ON REGULAR DEFINED ONES?
	String[] getDimensionNames() { //WHY IS THIS USING A RETURN TYPE STRING[]?
		if (getDescription().equals("Chocolate Chip Cookie") || 
				getDescription().equals("Oatmeal Cookie")) {
			return new String[] {"diameter"};
		} else {
			return new String[] {"width"};
		}
	}

	/* Round cookies have area:  PI * r^2
	 * Square cookies have area:  width^2
	 */
	@Override //again with the override?
	protected double getArea() {
		if (getDescription().equals("Chocolate Chip Cookie") || 
				getDescription().equals("Oatmeal Cookie")) {
			double radius = dimensions.get(0) / 2; //WHY get(0)????
			return Math.PI * radius * radius;
		} else {
			double width = dimensions.get(0);
			return width * width;
		}
	}

	@Override //again with the override?
	protected double getCaloriesPerSquareInch() {
		switch (getDescription()) {
		case "Chocolate Chip Cookie":
			return 10.5;
		case "Oatmeal Cookie":
			return 6.4;
		case "Lemon Square Cookie":
			return 8.9;
		default:
			throw new RuntimeException("Unknown cookie!");
		}
	}

}
