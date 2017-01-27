

public class BankAccount {

	private int balance;

	public BankAccount(int b) {
		balance = b;
	}

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int amount) {
		balance = amount;
	}

	public synchronized void deposit(int amount) {
		balance += amount;
	}

	public static void swap(BankAccount a, BankAccount b) {
		synchronized(a) {
			synchronized(b) {      // DON'T DO THIS!!  CAUSES DEADLOCK!!
			int temp = a.getBalance();
			a.setBalance(b.getBalance());
			b.setBalance(temp);
			}
		}
	}
}
