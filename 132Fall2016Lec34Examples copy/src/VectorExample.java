import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;

public class VectorExample {

	private static class MyThreadCode implements Runnable {

		private static Vector<String> x = new Vector<String>();

		@Override
		public void run() {
			for (int i = 0; i < 1000000; i++) {
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
