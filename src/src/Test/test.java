package Test;

import java.util.ArrayList;
import java.util.List;

public class test {
	private static List<Employee> e;
	public void addEmployee(Employee emp) {
		e.add(emp);
	}
	public static void listEmployee() {
		for(Employee emp:e)
			System.out.println(emp.getName());
	}
	
	public static void listEmployeesByDept(String deptname) {
		for(Employee emp:e) {
			if((emp.getDept().getName()).equals(deptname))
				System.out.println(emp.getName());
		}
	}
	
	public static void listEmployeesByRole(String rolename) {
		for(Employee emp:e) {
			if((emp.getRole().getName()).equals(rolename))
				System.out.println(emp.getName());
		}
	}
	
	public static void incrementSalEmp(Employee emp,Employee man,double inc,Role r) {
		if(((man.getName()).equals(emp.getManager().getName()))&&((emp.getRole().getName()).equals(r.getName()))) {
			emp.setSalary(emp.getSalary()+emp.getSalary()*inc);
			emp.setIncr(true);
		}
	}
	
	public static void incrementSalMan(Employee man,double inc) {
		if((man.getManager()==null)&&(man.getRole().getName().equals("man"))) {
			man.setIncr(true);
			man.setSalary(man.getSalary()+man.getSalary()*inc);	
		}
	}
	
	public static void listIncEmployee() {
		for(Employee emp:e) {
			if(emp.getManager().isIncr())
				System.out.println(emp.getManager().getName()+" "+emp.getManager().getSalary());
			if(emp.isIncr()) {
				System.out.println(emp.getName()+" "+ emp.getSalary());
			}
				
		}
	}
	
	public static void listEmployeeMan(Employee man) {
		for(Employee emp:e) {
			if((emp.getManager().getName()).equals(man.getName())) {
				System.out.println(emp.getName());
			}
		}
	}

	public static void main(String[] args) {
		e=new ArrayList<Employee>();
		Role r=new Role("dev");
		Role m=new Role("man");
		Role t=new Role("tester");
		Department dev=new Department("developer", "hyd");
		Department tes=new Department("testing", "hyd");
		Employee man =new Employee("Shyam",11,100000,m,dev,null,false);
		Employee man2 =new Employee("jam",11,100000,m,tes,null,false);
		Employee ram=new Employee("Ram",1,10000,r,dev,man,false);
		Employee james=new Employee("james",1,10000,t,tes,man2,false);
		e.add(ram);
		e.add(james);
		//listEmployee();
		listEmployeesByDept("testing");
		listEmployeesByRole(r.getName());
		incrementSalEmp(ram, man, 0.2, r);
		incrementSalMan(man2, 0.5);
		listIncEmployee();
		listEmployeeMan(man2);

	}

}
