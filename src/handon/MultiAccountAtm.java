package handon;

public class MultiAccountAtm {
	private Account[] account;
	private Atm atm;
	private double withdrawLimit;
	private double totalAmount;
	private int counter=0;
	private int limit=3;
	Account currentAccountHolder;
	
	public MultiAccountAtm() {
		totalAmount = 150000;
		withdrawLimit=4000;
		account = new Account[limit];
	}
	
	public void addAccount(Account acct) {
		if(counter<limit) {
			account[counter++]=acct;
			
		}
		
	}
	
	public boolean validatePin(int pin) {
		for(Account a:account) {
			if(a.getAcctPin()==pin) {
				currentAccountHolder=a;
				return true;
			}
		}
		return false;
	}
	
	public double withdraw(double amount,int pin) {
		if(validatePin(pin)) {
			if(amount<=withdrawLimit && amount<currentAccountHolder.getAcctBalance()-Account.minBalance) {
				totalAmount-=amount;
				currentAccountHolder.setAcctBalance(currentAccountHolder.getAcctBalance()-amount);
				return amount;	
			}
			
			System.out.println("wrong trans");
		}
		System.out.println("wrong pin");
		return 0.0;
	}
	
	public double deposit(double amount,int pin) {
		if(validatePin(pin))
		   totalAmount+=amount;
		   currentAccountHolder.setAcctBalance(currentAccountHolder.getAcctBalance()+amount);
		return amount;
	}
	
	@Override
	public String toString() {
		return "totalAmount=" + totalAmount + "Cust Balnce"+ currentAccountHolder.getAcctBalance();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiAccountAtm matm=new MultiAccountAtm();
		matm.addAccount(new Account("Ram",123,20000));
		matm.addAccount(new Account("shyam",321,15000));
		matm.addAccount(new Account("jam",234,25000));
		matm.withdraw(2000,321);
		System.out.println(matm);

	}

}
