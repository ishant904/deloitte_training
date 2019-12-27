package sort;

import java.util.Arrays;
import java.util.Comparator;

import compare.Employee;

public class ArrayStringSort {
	
	public static void main(String[] args) {
		Arrays.sort(args);
		for(String s:args)
			System.out.println(s);
		Employee e1=new Employee("ankit",123);
		e1.setSalary(1000);
		Employee e2=new Employee("Rahul",345);
		e2.setSalary(2000);
		Employee[] emps=new Employee[2];
		emps[0]=e1;
		emps[1]=e2;
		Arrays.sort(emps,e2);
		Arrays.sort(emps,new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getId() - o2.getId();
			}
			
		});
		
		for(Employee e:emps)
			System.out.println(e);
		
		Arrays.sort(emps,new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getName().compareToIgnoreCase(o1.getName());
			}
			
		});
		
		for(Employee e:emps)
			System.out.println(e);

	}
	
}

