package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringManip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String();
		str="This is a text";
		String st=new String("this is a line of text");
		System.out.println(str==st);
		System.out.println(str.equals(st));
		str=st;
		System.out.println(str==st);
		System.out.println(str.equals(st));
		int len=str.length();
		int indexOfC = str.indexOf('t');
		System.out.println(indexOfC);
		int lastIndexOft=str.lastIndexOf('t');
		System.out.println(lastIndexOft);
		int count=0;
		for(char c:str.toCharArray()) {
			if(c == 't') {
				++count;
			}
		}
		
		System.out.println("t occurs "+count+"times.");
		
		locate("text",str);
		
		StringBuffer buffer= new StringBuffer();
		buffer.append("<html>");
		buffer.append("<head><title>My Web Page</title></head>");
		buffer.append("<body>");
		buffer.append("<h1> This is my web profile </h1>");
		buffer.append("</body></html>");
		System.out.println(buffer.toString());
		
		palindrome("sas");
		

	}
	
	public static boolean palindrome(String s) {
		StringBuffer buffer = new StringBuffer(s);
		buffer=buffer.reverse();
		return s.equals(buffer.toString());
		
	} 
	
	public static void locate(String word,String line) {
		String str[]=line.split(" ");
		int flag=0;
		for(int i=0;i<str.length;i++) {
			if(str[i].equals(word)) {
				flag=1;
			}
			
		}
		if(flag==0)
			System.out.println("not present");
		else
			System.out.println("present");
		System.out.println(line.indexOf(word));
		System.out.println(word.length()+line.indexOf(word)-1);
		
	}
	
	public static void alphabetWord(String s) {
		Set<Character> texts = new HashSet();		
		for(int i=0;i<s.length()-1;i++) {
			texts.add(s.charAt(i));
		}
		System.out.println(texts.size());
		
		/*String chars="";
		for(char c:s.toCharArray()) {
			if(!chars.contains(c+"")&&c!=' ') {
				chars+=c;
			}
		}
		char[] ch=chars.toCharArray();
		Arrays.sort(ch);
		System.out.println(new String(ch));
		System.out.println();
		return chars.length();*/
		
	}
		
	

}
