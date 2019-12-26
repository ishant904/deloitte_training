package handon;

public class Account {
	
	String acctHolder;
	int acctPin;
	double acctBalance;
	public static final double minBalance=10000;
	public Account(String acctHolder, int acctPin, double acctBalance) {
		super();
		this.acctHolder = acctHolder;
		this.acctPin = acctPin;
		this.acctBalance = acctBalance;
	}
	
	public String getAcctHolder() {
		return acctHolder;
	}

	public void setAcctHolder(String acctHolder) {
		this.acctHolder = acctHolder;
	}

	public int getAcctPin() {
		return acctPin;
	}

	public void setAcctPin(int acctPin) {
		this.acctPin = acctPin;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}
	

	@Override
	public String toString() {
		return "Account [acctHolder=" + acctHolder + ", acctPin=" + acctPin + ", acctBalance=" + acctBalance + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
