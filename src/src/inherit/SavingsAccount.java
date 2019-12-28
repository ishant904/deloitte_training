package inherit;

public class SavingsAccount extends Account {
	
	private static final double MINIMUM=10000;

	public SavingsAccount(String name, int number, double balance) {
		super(name, number, balance);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void print(String s) {
		System.out.println("Printing saving account info---"+s);
	}

	@Override
	public void withdraw(double amount) {
		if(balance - amount>=MINIMUM) {
			balance-=amount;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
