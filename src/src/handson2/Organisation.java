package handson2;

public class Organisation {
	
	static Employee[] emps=new Employee[5];

	public static void main(String[] args) {
		Department testing=new Department("test","hyd");
		
		Address a1=new Address("12E","JCly","Hyd","TS");
		Department hr=new Department("hr","hyd");
		Employee e1 = new Employee("Amit",a1,1,hr);
		
		Address a2=new Address("13E","JCly","Hyd","TS");
		Department dev=new Department("dev","hyd");
		Employee e2 = new Employee("Ram",a2,2,dev);
		
		Address a3=new Address("14E","JCly","Hyd","TS");
		Employee e3 = new Employee("Shyam",a3,3,dev);
		
		Address a4=new Address("15E","JCly","Hyd","TS");
		Employee e4 = new Employee("Jam",a4,4,dev);
		
		Address a5=new Address("16E","JCly","Hyd","TS");
		Employee e5 = new Employee("James",a5,1,null);
		
		emps[0]=e1;emps[1]=e2;emps[2]=e3;emps[3]=e4;emps[4]=e5;
		
		deptName("Amit");
		noDept();
		
	}
	
	public static void deptName(String name) {
		for(int i=0;i<5;i++) {
			if((emps[i].name).equals(name))
			System.out.println("Dept:"+emps[i].getDept().getName());
		}
		
	}
	
	public static void employeeNo(String dept) {
		for(int i=0;i<5;i++) {
			if(emps[i].getDept()!=null)
			if((emps[i].getDept().getName()).equals(dept))
				System.out.println(emps[i].getName());
		}
		
	}
	
	public static void noDept() {
		for(int i=0;i<5;i++) {
			if(emps[i].getDept() == null) {
				System.out.println(emps[i].getName());
			}
		}
		
	}

}
