
public class JoinExample {

	private static class CodeForThread implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[100];
		for (int i = 0; i < 100; i++) {
			threads[i] = new Thread(new CodeForThread());
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		System.out.println("All Done");
	}
}
