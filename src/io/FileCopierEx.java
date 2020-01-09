package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopierEx {
	private static String fileName = "D://data.txt";
	private static String fileName1 = "D://userpass.txt";
	public static void main(String[] args) {
		File file =new File(fileName);
		FileWriter fwriter=null;
		try {
			fwriter= new FileWriter(fileName1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		PrintWriter out=null;
		out=new PrintWriter(fwriter);
		if(file.exists()) {
		System.out.println("yes");	
		FileReader freader=null;
		BufferedReader buffer=null;
		try {
			freader=new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line="";
		buffer=new BufferedReader(freader);
		try {
			line=buffer.readLine();
			while(line!=null) {
				System.out.println(line);
				out.println(line);
				line=buffer.readLine();
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

}
