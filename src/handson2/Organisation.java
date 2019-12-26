package handson2;

public class Organisation {

	public static void main(String[] args) {
		Address a1=new Address("12E","JCly","Hyd","TS");
		Department hr=new Department("hr","hyd");
		Employee e1 = new Employee("Amit",a1,1,hr);
		
		Address a2=new Address("13E","JCly","Hyd","TS");
		Department dev=new Department("dev","hyd");
		Employee e2 = new Employee("Ram",a2,2,dev);
	}

}
