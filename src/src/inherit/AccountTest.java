package inherit;

public class AccountTest {
	
	public static void showBalance(Account ac) {
		System.out.println(ac.getBalance());
	}
	
	public static void printAccount(Account ac,Printer p) {
		ac.print("from accounts");
		p.print("from printer class");
	}

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount("Neha",123,100000);
		System.out.println(sa);
		sa.withdraw(4000);
		System.out.println(sa);
		
		CurrentAccount ca = new CurrentAccount("riya", 123, 20000);
		System.out.println(ca);
		ca.withdraw(2000);
		System.out.println(ca);
		
		Account ac=new SavingsAccount("Amit",678,200000);
		System.out.println(ac);
		ac.withdraw(1000);
		System.out.println(ac);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println(sa);
		
		ac.print("hello account");
		sa.print("From savings..");
		
		printAccount(ac, new ConsolePrinter());
		printAccount(ac, new FilePrinter());
	}

}
