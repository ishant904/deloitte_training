package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

	public class FileReaderEx {
		private static String fileName = "D://userpass.txt";
		
		public static void main(String[] args) {
			File file =new File(fileName);
			if(file.exists()) {
				System.out.println(file.getPath());
				FileReader reader=null;
				BufferedReader buffer=null;
				try {
					reader = new FileReader(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("File doesnt exist");
				}
				String line ="";
				buffer = new BufferedReader(reader);
				try {
					line = buffer.readLine();
					while(line!=null) {
						String s[]=line.split(";");
						for(String a:s)
						{
							System.out.println(a);	
						}
						line = buffer.readLine();
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error reading file"+e.getMessage());
				}
				finally {
					if(buffer !=null) {
						try {
							buffer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(reader!=null) {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
					
		}
	}
