
public class CheckingsAccount extends Accounts {
	
	
	// fields
	private final double withdrawal_fee = 1.5;
	
	
	// Constructor
	public CheckingsAccount(String a_n, double b) {
		setAccountName(a_n);
		setBalance(b);
	}
	
	//deposit method override
	@Override
	public void deposit(double b) {
		if(b < 0) {
			System.out.println("Invalid amount");
		}
		else {
			setBalance(getBalance() + b);
			updateHistory("deposit", b);
		}
	}
	
	// withdraw method
	@Override
	public void withdraw(double a) {
		if(a < 0) {
			System.out.println("Invalid amount");
		}
		else if(a > (getBalance() - withdrawal_fee)) {
			System.out.println("Insufficient balance");
		}
		else {
			setBalance(getBalance() - (a + withdrawal_fee));
			updateHistory("withdraw", (a + withdrawal_fee));
		}
	}
	
	@Override
	public void updateHistory(String t_type, double t_amount) {
		id.add(count++);
		transaction_type.add(t_type);
		amount.add(t_amount);
	}
	
	@Override
	public void displayHistory() {
		System.out.println("======== transaction history ========");
		for(int i = 0; i < id.size(); i++ ) {
			System.out.println(id.get(i) + " ---- " + transaction_type.get(i) + " ---- " + amount.get(i));
		}
		
	}
	
}
