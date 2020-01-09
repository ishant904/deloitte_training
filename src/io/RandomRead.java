package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomRead {
	private static String fileName="D://data.txt";

	public static void main(String[] args) {
		File f= new File(fileName);
		RandomAccessFile rm=null;
		try {
			rm=new RandomAccessFile(f,"r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line="";
		try {
			line=rm.readLine();
			rm.seek(line.length());
			while(line!=null) {
				line=rm.readLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

	}

}
