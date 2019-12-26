package handon;

import core.People;
import core.Person;

public class Course {
	private String subject1;
	private String subject2;
	private Student[] s;
	private int counter=0;
	private int limit=3;
	private int numCourse=0;
	private Course[] course = new Course[1];
	
	public Course() {
		s=new Student[limit];
	}
	
	public void addStudents(Course c) {
		if(numCourse<limit)
		course[numCourse++]=c;
	}
	
	public void addStudents(Student st) {
		if(counter<limit)
		s[counter++]=st;
	}
	
	
	
	public void displayStudents() {
		for(Student p:s) {
			System.out.println(p);
		}
		
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	
	public void printStudentNames(String subject) {
		for(Course c:course) {
			if((c.getSubject1().equalsIgnoreCase(subject)) ||(c.getSubject1().equalsIgnoreCase(subject))) {
				Student[] students = c.s;
				for(Student student:students) {
				    System.out.println(student);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Course c = new Course();
		c.setSubject1("c");
		c.setSubject2("java");
		c.addStudents(new Student("amit",1));
		c.addStudents(new Student("asha",2));
		c.addStudents(new Student("rupa",3));
		c.displayStudents();


	}

}
