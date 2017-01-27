
public class SelectionSort implements SortingAlgorithm {

	@Override
	public String getName() {
		return "Selection Sort";
	}
	
	@Override
	public void sort(int[] data) {
		for (int pass = 0; pass < data.length - 1; pass++) {
			int smallestSoFar = data[pass];
			int smallestIndex = pass;
			for (int i = pass + 1; i < data.length; i++) {
				if (data[i] < smallestSoFar) {
					smallestSoFar = data[i];
					smallestIndex = i;
				}
			}
			swap(data, pass, smallestIndex);
		}
	}
	
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
