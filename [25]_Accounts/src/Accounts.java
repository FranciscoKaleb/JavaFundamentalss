import java.util.ArrayList;

public abstract class Accounts {
	private static String DEFAULT_NAME = "Unnamed Account";
	private static double DEFAULT_BALANCE = 0;
	
	
	// fields
	private String account_name;
	private double balance;
	
	
	// for transaction history
	protected int count = 0;
	protected ArrayList<Integer> id = new ArrayList<Integer>();
	protected ArrayList<Double> amount = new ArrayList<Double>();
	protected ArrayList<String> transaction_type = new ArrayList<String>();
	
	
	// properties
	public String getAccountName() {
		return this.account_name;
	}
	
	public void setAccountName(String name) {
		this.account_name = name;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double b) {
		this.balance = b;
	}
	
	// constructors
	public Accounts() {
		setAccountName(DEFAULT_NAME);
		setBalance(DEFAULT_BALANCE);
	}
	public Accounts(String n, double b) {
		setAccountName(n);
		setBalance(b);
	}
	
	// methods
	public void deposit(double b) {
		
	}
	public void withdraw(double b) {
		
	}
	public void updateHistory(String t, double a) {
		
	}
	public void displayHistory() {
		
	}
	

	
}
