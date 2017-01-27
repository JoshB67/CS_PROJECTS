import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class SortTests {

	@Test
	public void testBubbleSort() {
		doTest(new BubbleSort());
	}
	
	@Test
	public void testSelectionSort() {
		doTest(new SelectionSort());
	}
	
	private void doTest(SortingAlgorithm sorter) {
		Random r = new Random();
		int DATA_SIZE = 100000;
		int[] a = new int[DATA_SIZE];
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt();
		}
		sorter.sort(a);
		for (int i = 1; i < a.length; i++) {
			assertTrue(a[i] >= a[i - 1]);
		}
	}

}
