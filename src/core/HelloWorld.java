package core;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hello = "Hello, Java World!";
		System.out.println(hello);
		int len=hello.length();
		System.out.println("THe no. of char in the text =" + len);
		System.out.println("Is this true:" + (len == 18));
		if(len==10) 
		{
			System.out.println("THis is correct!");
		}
		else 
		{
			System.out.println("Wrong! Try again");
		}
		
		System.out.println((len == 18)? "Correct":"Wrong");
		int n=45,m=34;
		if(m<n) 
		{
			System.out.println(n-m);
		}
		else 
		{
			System.out.println(n-m);
		}
		
		for(int i='a';i<='z';i++)
		{
			System.out.print(i + " ");
			
		}
		System.out.println();
		for(int i='A';i<='Z';i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		for( int i = '0';i<='9';i++) {System.out.print(i + " ");}
		System.out.println();
		//rangeSum(10,5);
		calculate(5,0,"8");
	}
	
	public static void rangeSum(int m, int n) 
	{
		//if(m>n) swap(m,n);
		int sum=0;
		for(int i=m;i<=n;i++) 
		{
			sum+=i;
		}
	}
	
	/*public static void swap(int m,int n) {
		int temp;
		temp = m;
		m=n;
		n=temp;
	}*/
	
	public static void calculate(double a,double b,String op) {
		switch(op.charAt(0)) {
		case '+' : System.out.println(a+b); break;
		case '-' : System.out.println(a-b); break;
		case '*' : System.out.println(a*b); break;
		case '/' : if(b!=0)System.out.println(a/b); break;
		default:System.out.println("wrong");break;
		}
		
	}

}
