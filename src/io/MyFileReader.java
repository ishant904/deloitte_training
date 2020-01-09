package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

	public class MyFileReader {
		
		private static String fileName = "D://data.txt";
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			File file =new File(fileName);
			if(file.exists()) {
				System.out.println(file.getPath());
				FileReader reader=null;
				BufferedReader buffer=null;
				try {
					reader = new FileReader(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("File doesnt exist");
				}
				String line ="";
				buffer = new BufferedReader(reader);
				try {
					line = buffer.readLine();
					while(line!=null) {
						System.out.println(line);
						line = buffer.readLine();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Error reading file"+e.getMessage());
				}
	
			}
					
			
	
		}
	
	}
