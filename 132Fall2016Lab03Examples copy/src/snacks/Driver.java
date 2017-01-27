package snacks;

import java.util.ArrayList;
import java.util.List;

import snacks.Cookie.CookieType;

public class Driver {

	public static void main(String[] args) {

		List<Snack> list = new ArrayList<Snack>();
		
		/* The user will be prompted by the Snack
		 * constructor to enter the dimensions
		 * for each snack.
		 */
		list.add(new Dorito()); //WHY DON'T THESE HAVE STUFF INSIDE CONSTRUCTORS?
		list.add(new Triscuit()); //
		list.add(new Cookie(CookieType.CHOCOLATE_CHIP));
		list.add(new Cookie(CookieType.LEMON_SQUARE));
		list.add(new Cookie(CookieType.OATMEAL));
		
		System.out.println("Calorie Amounts: ");
		
		double totalCalories = 0;
		
		for (Snack snack : list) { //WHAT DATA STRUCTURE ARE WE STORING THE SNACKS IN?
			double calories = snack.computeTotalCalories();
			System.out.println("   " + snack.getDescription() + ": " + calories);
			totalCalories += calories;
		}
		System.out.println("Total: " + totalCalories);
	}

}
