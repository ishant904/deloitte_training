package inherit;

public class CurrentAccount extends Account {
	
	public CurrentAccount(String name, int number, double balance) {
		super(name, number, balance);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount<balance)
		balance-=amount;
	}

}
