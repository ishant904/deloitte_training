package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import collection.Student;

public class ObjectReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStream fis= new FileInputStream("D://std.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student st=(Student) ois.readObject();
			System.out.println(st);
			ois.close();
		}catch(IOException ioe) {
			System.out.println("Object not read"+ioe.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class not"+e.getMessage());
		}

	}

}
