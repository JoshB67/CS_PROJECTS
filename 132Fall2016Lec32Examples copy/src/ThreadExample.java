 
public class ThreadExample {

	private static class CodeForThread implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++){
			Thread thread = new Thread(new CodeForThread());
			thread.start();
		}
		
		System.out.println("All Done");
	}
}
