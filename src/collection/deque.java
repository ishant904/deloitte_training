package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class deque {
	
	public static void main(String[] args) {
		Deque <Integer> d= new ArrayDeque();
		d.add(12);
		d.addFirst(32);
		d.addLast(45);
		Iterator it=d.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
