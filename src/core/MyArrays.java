package core;

import java.util.Arrays;
import java.util.Random;

public class MyArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {22,1,3,49,74,54};
		//for(int i=0;i<nums.length;i++) {System.out.println(nums[i]*nums[i]);}
		String[] name;
		name= new String [1];
		name[0]="anand";
		//System.out.println(name[0]);
		//strLengths(args);
		//strChange(name);
		//System.out.println(name[0]);
		intSort(nums);
		Random r = new Random();
		r.ints();
		

	}
	
	public static void strLengths(String[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
			System.out.println(a[i].length());
			
		}
	}
	
	public static void strChange(String[] name) 
	{
		name[0]="Ishant";
		System.out.println(name[0]);
	}
	
	public static void intSort(int[] n) 
	{
	    Arrays.sort(n);
	    for(int i=0;i<n.length;i++)
	    System.out.println(n[i]);
	}

}
