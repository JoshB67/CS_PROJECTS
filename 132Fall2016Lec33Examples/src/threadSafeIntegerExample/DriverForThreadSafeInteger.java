package threadSafeIntegerExample;

public class DriverForThreadSafeInteger {

	private static class MyThreadCode implements Runnable {

		private static ThreadSafeInteger x = new ThreadSafeInteger(0);

		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				x.increment();
				x.decrement();
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
