
public class BubbleSort implements SortingAlgorithm {

	@Override
	public String getName() {
		return "Bubble Sort";
	}
	
	@Override
	public void sort(int[] data) {
		boolean swapped = true;
		int j = 0;
		int temp = 0;
		
		while(swapped) {
			swapped = false;
			j++;
			for(int i = 0; i < data.length - j; i++) {
				if(data[i] > data[i + 1]) {
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

}


