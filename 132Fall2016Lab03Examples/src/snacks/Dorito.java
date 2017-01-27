package snacks;

/* Doritos are delicious triangular snacks.
 */
public class Dorito extends Snack {
	
	private static final double CALORIES_PER_SQUARE_INCH = 7.4; //CONSTANT
	private static final String DESCRIPTION = "Dorito"; //CONSTANT

	public Dorito() { //SO IT'S DEFAULT CONSTRUCTOR JUST RETURNS THE CONSTANT DORITO?
		super(DESCRIPTION); //WHY SUPER?
	}
	
	@Override
	String[] getDimensionNames() { //WHY A STRING[]????
		return new String[] {"Side 1", "Side 2", "Side 3"};
	}

	/* We use "Huron's forumula" to calculate the area of
	 * a triangle, given the three side lengths (a, b, and c).
	 */
	@Override
	protected double getArea() {
		double a = dimensions.get(0); //DON'T UNDERSTAND THE DIMENSIONS PART
		double b = dimensions.get(1);
		double c = dimensions.get(2);
		
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	protected double getCaloriesPerSquareInch() {
		return CALORIES_PER_SQUARE_INCH;
	}
}
