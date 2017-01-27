package threadSafeIntegerExample;

public class BadSyncrhonizationWithIntegerObject {

	private static class MyThreadCode implements Runnable {

		private static Integer x = 0;

		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				synchronized(x) {
					x++;
				}
				synchronized(x) {
					x--;
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
