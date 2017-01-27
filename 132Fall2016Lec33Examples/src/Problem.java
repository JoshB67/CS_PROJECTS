
public class Problem {

	private static class MyThreadCode implements Runnable {

		private static int x = 0;
		private static Object o = new Object();

		@Override
		public void run() {
			for (int i = 0; i < 1000000; i++) {
				synchronized(o) {
					x--;
					x++;
				}
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
