
public class BubbleSort implements SortingAlgorithm {

	@Override
	public String getName() {
		return "Bubble Sort";
	}
	
	@Override
	public void sort(int[] data) {
		for (int pass = 0; pass < data.length - 1; pass++) {
			for (int i = 0; i < data.length - pass - 1; i++) {
				if (data[i] > data[i + 1]) {
					swap(data, i, i + 1);
				}
			}
		}
	}
	
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}



}
