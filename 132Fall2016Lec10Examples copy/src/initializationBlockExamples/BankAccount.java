package initializationBlockExamples;

import java.util.Calendar;

public class BankAccount {

	private static final String TODAY;
	
	static {
		Calendar calendar = Calendar.getInstance();
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		TODAY = month + "/" + day + "/" + year;
	}	
	
	private int balance;
	private String name;
	
	// Accounts created in September start with $200
	// Accounts created in October start with $500
	{
		if (TODAY.startsWith("9/")) {
			balance = 200;
		} else if (TODAY.startsWith("10")) {
			balance = 500;
		}
	}
	
	public BankAccount(String name) {
		this.name = name;
	}
	
	public BankAccount() {
		name = "Unknown";
	}
	
	public BankAccount(String name, int initialDeposit) {
		this.name = name;
		this.balance += initialDeposit;
	}
	
	public String toString() {
		return TODAY + ": " + name + " has $" + balance;
	}
	
	public static void main(String[] args) {

		BankAccount account1 = new BankAccount("Fred");
		BankAccount account2 = new BankAccount("Joe", 1000);
		BankAccount account3 = new BankAccount();
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
		
	}

}
