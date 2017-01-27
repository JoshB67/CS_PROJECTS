import java.util.ArrayList;

public class ArrayListProblem {

	private static class MyThreadCode implements Runnable {

		private static ArrayList<String> x = new ArrayList<String>();

		@Override
		public void run() {
			for (int i = 0; i < 10000000; i++) {
				x.add("hi");
				x.remove(0);
			}
			System.out.println(x + "  " + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
	    for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new MyThreadCode());
            t.start();
	    }
    }
}
