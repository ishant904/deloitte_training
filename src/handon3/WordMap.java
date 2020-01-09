package handon3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> word = new ArrayList<>();
		getWord(word);
		System.out.println(word);
		Map<String,Integer> map =addWordToMap(word);
		Scanner s=new Scanner(System.in);
		System.out.println("enter word to find vowel");
		String str=s.nextLine();
		System.out.println(getVowel(map,str));

	}
	
	public static void getWord(List<String> a) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter word and 1 to exit");
	    while(true) {
	    	String str = s.nextLine();
	    	if(str.equals("1"))
	    		break;
	    	else
	    		a.add(str);
	    }
		
	}
	
	public static Map<String,Integer> addWordToMap(List<String> l){
		Iterator<String> itr=l.iterator();
		Map <String,Integer> m = new HashMap();
		while(itr.hasNext()) {
			int cnt=0;
			String str=itr.next();
			String strl=str.toLowerCase();
			for(int i=0;i<strl.length();i++) {
				if((strl.charAt(i)=='a') ||(strl.charAt(i)=='e') || (strl.charAt(i)=='i')||(strl.charAt(i)=='o')||(strl.charAt(i)=='u'))
					cnt++;	
			}
			System.out.println(cnt);
			m.put(str,cnt);
		}
		return m;
		
	}
	
	public static int getVowel(Map<String,Integer> m,String s) {
		if(m.containsKey(s))
			return m.get(s);
		else
			return -1;
		
	}
	
	

}
