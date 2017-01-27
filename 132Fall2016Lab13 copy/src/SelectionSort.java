
public class SelectionSort implements SortingAlgorithm {

	@Override
	public String getName() {
		return "Selection Sort";
	}
	
	@Override
	public void sort(int[] data) {
		int i = 0;
		int j = 0;
		int minValue = 0;
		int minIndex = 0;
		int temp = 0;
		
		for(i = 0; i < data.length - 1; i++) {
			minValue = data[i];
			minIndex = i;
			
			for(j = i + 1; j < data.length; j++) {
				if (minValue > data[j]) {
					minValue = data[j];
					minIndex = j;
				}
			}
			if (minValue < data[i]) {
				temp = data[i];
				data[i] = minValue;
				data[minIndex] = temp;
			}
		}
	}

}
