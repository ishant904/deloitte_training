package handon;

import java.util.Scanner;

public class Atm {
	
	private double withdrawLimit;
	private double totalAmount;
	private Account account;
	public Atm() {
		totalAmount = 150000;
		withdrawLimit=4000;
	}
	
	//public Atm(Account a) {this.account=a;}
	
	public double withdraw(double amount,int pin) {
		if(validatePin(pin)) {
			if(amount<=withdrawLimit && amount<account.getAcctBalance()-Account.minBalance) {
				totalAmount-=amount;
				account.acctBalance-=amount;
				return amount;	
			}
			
			System.out.println("wrong trans");
		}
		System.out.println("wrong pin");
		return 0.0;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double deposit(double amount,int pin) {
		if(validatePin(pin))
		   totalAmount+=amount;
		   account.acctBalance+=amount;
		return amount;
	}
	
	public boolean validatePin(int pin) {
		return account.getAcctPin() == pin;
	}
	
	public String toString() {
		return "total amount="+totalAmount + "total balance"+account.getAcctBalance();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atm atm =new Atm();
		Account a =new Account("Ram",123,20000);
		atm.setAccount(a);
		atm.withdraw(2000,123);
		atm.deposit(3000,123);
		System.out.println(atm);
	}

}
