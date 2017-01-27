package snacks;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/* Snacks are delicious, and they come in different 
 * shapes.  Some are rectangles, some are circles,
 * some are triangles, etc.
 *  
 * This class can be extended to allow for Snacks
 * of any shape you want!
 */
public abstract class Snack { //SO IN INHERITANCE SOME OF THE METHODS CAN BE ABSTRACT AN OTHER REGULAR?
	
	/* Brief description of snack.
	 * E.g.:  "Dorito", or "Chocolate Chip Cookie"
	 */
	private String description;
	
	/* List of dimensions for this snack.
	 * 
	 * For a rectangular snack, there will be two dimensions
	 *   (length and width).
	 * For a round snack, there will be one dimension
	 *   (diameter)
	 * For a triangular snack, there will be three dimensions
	 *   (side 1, side 2, side 3)
	 * Etc.
	 */
	protected List<Double> dimensions = new ArrayList<Double>();
	
	/* Returns the names of the dimensions this snack has.
	 * e.g. {"width", "length"} for a rectangular snack,
	 * or {"Diameter"} for a round snack,
	 * or {"Side 1", "Side 2", "Side 3"} for a triangular snack.
	 * Etc.
	 * 
	 * These names will be used to prompt the user for 
	 * the snack's dimensions.
	 */
	abstract String[] getDimensionNames();
	
	abstract protected double getArea();
	
	abstract protected double getCaloriesPerSquareInch();
	
	/* This constructor is unusual in that it prompts
	 * the user to enter the dimensions of the snack
	 * being constructed.
	 * 
	 * There will be one prompt for each dimension.  
	 * E.g. Triscuits are rectangles, so they would 
	 * require the user to enter two things:  
	 * length and width.  
	 * 
	 * The prompts look like these examples:
	 *    "Enter Dorito Side 2"
	 *    "Enter Triscuit length"
	 *    "Enter Chocolate Chip Cookie Diameter"
	 *    Etc.
	 */
	public Snack(String description) { //THE REST SORT OF MADE SENSE THIS DOES NOT
		this.description = description;
		String[] dimensionNames = getDimensionNames(); //ARRAY HUH?
		for (String dimensionName : dimensionNames) { //WHY A FOR LOOP?
			String value = JOptionPane.showInputDialog(
					"Enter " + description + " " + dimensionName);
			dimensions.add(Double.valueOf(value));
		}
	}
	
	public String getDescription() {
		return description;
	}
	
	public double computeTotalCalories() {
		return getCaloriesPerSquareInch() * getArea();
	}
	
}
