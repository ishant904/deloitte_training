package io;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileOperation {
	
	public static void main(String[] args) {
		File file = new File("D://mydate");
		boolean done = file.mkdir();
		System.out.println(done);
		String[] files =file.list();
		for(String s:files) {
			File f = new File (file.getPath()+"/"+s);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			System.out.println(f.getName()+"   "+ f.length()+"   "+sdf.format(file.lastModified()));
		}
	}

}
