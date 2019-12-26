package handon;

public class Student {
	
	private String name;
	private int roll;
	
	public Student() {
		
	}
	
	public Student(String name,int r) 
	{
		this.name=name;
		roll=r;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRoll(int num) {
		this.roll = num;
	}
	
	public long getRoll() {
		
		return roll;
	}
	
	public String toString() {
		return name + ":" + roll;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s =new Student("Ram",001);

	}

}
