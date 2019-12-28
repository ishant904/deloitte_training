package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MyCollection {

	public static void main(String[] args) {

		Vector<String> v=new Vector<>();
		v.add("ankit");
		v.add("Laptop");
		v.add("Computer");
		v.add("mobile");
		System.out.println(v.size());
		for(String s:v)
			System.out.println(s);
		System.out.println(v);
		
		Enumeration<String> E=v.elements();
		while(E.hasMoreElements()) {
			System.out.println(E.nextElement());
		}
		
		Iterator<String> it=v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		int sum=0;
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(12);
		list.add(23);
		list.add(43);
		list.add(51);
		
		Iterator<Integer> iter =list.iterator();
		while(iter.hasNext()) {
			sum+=iter.next();
		}
		System.out.println(sum);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		List<Student> students= new ArrayList<>();
		students.add(new Student("nina",123));
		students.add(new Student("asha",321));
		students.add(new Student("venu",121));
		students.add(new Student("samir",435));
		students.add(new Student("ananya",321));
		
		Iterator<Student> sdIt = students.iterator();	
		while(sdIt.hasNext()) {
			Student st=sdIt.next();
			System.out.println(st.getName());
		}
		
		Collections.sort(students,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
			
		});
	System.out.println(students);
	
	Collections.sort(students,new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o1.getRoll() - o2.getRoll();
		}
		
	});
	System.out.println(students);
	
	//Collections.sort(students,new StudentNameSorter());
	//System.out.println(students);
	
	filter(students);
	System.out.println("-----------------");
	Hashtable<String,String> table = new Hashtable<>();
	table.put("admin","admin123");
	table.put("user","user123");
	
	Enumeration<String> enums= table.keys();
	while(enums.hasMoreElements()) {
		String key = enums.nextElement();
		String val = table.get(key);
		System.out.println(key + ":" + val);
	}
	
}
	
	public static void filter(List<Student> a) {
		
		Iterator<Student> sdIt = a.iterator();	
		while(sdIt.hasNext()) {
			Student st=sdIt.next();
			if(st.getName().startsWith("a"))
				System.out.println(st);
		}
		
		
	}
	
}
