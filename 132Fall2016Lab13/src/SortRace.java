import java.util.Random;

public class SortRace {
	
	public static void main(String[] args) {
		timeSort(new BubbleSort(), 100000);
		timeSort(new SelectionSort(), 100000);
	}
	
	private static void timeSort(SortingAlgorithm sorter, int dataSize) {
		Random r = new Random();
		int[] a = new int[dataSize];
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt();
		}
		System.out.println("\nPerforming " + sorter.getName() + " on size " + dataSize);
		long startTime = System.nanoTime();
		sorter.sort(a);
		long endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime) / 1000000000.0 + " seconds");
		
	}
}
