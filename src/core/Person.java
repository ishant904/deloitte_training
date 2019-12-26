package core;

public class Person {
	
	private String name;
	private long mobileNumber;
	private static int instance =0;
	
	public Person() 
	{
		instance++;
		
	}
	
	public Person(String name) {
		this(name,0L);
	}
	
	public Person(String name,long number) 
	{
		this();
		this.name=name;
		mobileNumber=number;
	}
	
	public int getInstance() {return instance;}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setMobileNumber(long num) {
		mobileNumber = num;
	}
	
	public long getMobileNumber() {
		
		return mobileNumber;
	}
	
	public String toString() {
		return name + ":" + mobileNumber;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person neha = new Person();
		Person ramesh = new Person("Ramesh",8645498715L);
		Person ram = new Person("ram");
		System.out.println(ramesh);
		neha.setName("neha");
		neha.setMobileNumber(7986546516L);
		System.out.println(instance);
		System.out.println(neha);
		System.out.println(ram);
		Person[] p= {neha , ramesh, ram};
		System.out.println(p[2]);
	}

}
