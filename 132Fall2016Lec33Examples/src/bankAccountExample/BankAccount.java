package bankAccountExample;

public class BankAccount {

	private int balance;
	
	public BankAccount(int b) {
		balance = b;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int amount) {
		balance = amount;
	}
	public synchronized void deposit(int amount) {
		balance += amount;
	}
}
