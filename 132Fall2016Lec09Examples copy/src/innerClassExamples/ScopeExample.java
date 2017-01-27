package innerClassExamples;

public class ScopeExample {

	int x = 2;
	
	private class IC {
		
		int x = 6;
		
		private void getX() {
			
			int x = 8;
			
			System.out.println(x);
			System.out.println(this.x);
			System.out.println(ScopeExample.this.x);
		}
	}

}
