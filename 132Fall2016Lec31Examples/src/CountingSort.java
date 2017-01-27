
public class CountingSort implements SortingAlgorithm {

	@Override
	public String getName() {
		return "Counting Sort";
	}

	@Override
	public void sort(int[] a) {
		int RANGE = 100000;    // 0 - 99,999
		int[] b = new int[a.length];
		int[] c = new int[RANGE];
		for (int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}
		for (int i = 1; i < RANGE; i++) {   
			c[i] += c[i-1];
		}
		for (int i = a.length - 1; i >= 0; i--) { 
			b[c[a[i]]-1] = a[i];   
			c[a[i]]--;                            
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}

}
