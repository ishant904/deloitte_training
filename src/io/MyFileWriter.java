package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileWriter {
	private static String fileName = "D://userpass.txt";

	public static void main(String[] args) {
		FileWriter fw=null;
		try {
			fw= new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter out=null;
		out=new PrintWriter(fw);
		out.println("admin:admin123");
		out.println("user1:user123");
		out.println("user2:user123");
		out.println("user3:user123");
		out.flush();
		if(fw!=null) {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
	}

}
