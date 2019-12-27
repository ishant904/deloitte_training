package compare;

import java.util.Comparator;

public class Employee implements Comparable<Employee>,Comparator<Employee>{
	
	private String name;
	private int id;
	private double salary;
	
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object o) {
		Employee e = (Employee) o ;
		return this.id == e.id ;
	}
	
	@Override
	public int hashCode() {
		return id/12;
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int)(o1.salary - o2.salary);	
		
	}

}
