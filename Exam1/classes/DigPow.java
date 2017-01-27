
public class DigPow {


	public static long digPow(int n, int p) {

		int results = 0;

		String num = String.valueOf(n);
		for (int i = 0; i < num.length(); i++) {

			int x = Character.getNumericValue(num.charAt(i));
			results = (int) (results + Math.pow(x, p++));          
		}

	
	int k = 0;
	
	while ( k < results ) {
		k++;
		if(n*k == results){
			return k;
		}
	}
	
	return -1;
	
		
	}

	public static void main(String[] args) {
		System.out.println(DigPow.digPow(92, 1));
	}
}