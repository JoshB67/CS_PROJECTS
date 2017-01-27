import java.util.Random;

public class MathWithSingleThread {

	/*******************************************
	 * 
	 *  
	 *  STUDENTS:  DO NOT MODIFY THIS CLASS
	 *  (Other than changing the size of the 
	 *  array.)
	 *  
	 *  
	 *******************************************/
	
	private static Random random = new Random();

	private static double[][] makeArray(int height, int width) {
		double[][] answer = new double[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				answer[row][col] = random.nextDouble();
			}
		}
		return answer;
	}


	public static void main(String[] args) throws InterruptedException {
		double[][] array = makeArray(1000, 1000);
		long start = System.nanoTime();
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++){
				array[row][col] = Math.sqrt(array[row][col]);
			}
		}
		long end = System.nanoTime();
		System.out.println((end - start)/1000000000.0);
	}
}
