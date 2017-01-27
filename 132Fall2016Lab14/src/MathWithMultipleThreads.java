import java.util.Random;

public class MathWithMultipleThreads {

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
		
		
		/* Fill this in!! */
		
		
		long end = System.nanoTime();
		System.out.println((end - start)/1000000000.0);
	}

}
