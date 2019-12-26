package core;

import java.util.Scanner;

public class MathRandom {

	static int target = (int)(Math.random()*100)+1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(target);
		play(sc);
	}
	
	private static int userInput(Scanner sc) {
		return sc.nextInt();
		}
	
	private static void play(Scanner sc) {
		 
		for(int i=0;i<5;i++) {
			if(userInput(sc) == target)
			{System.out.println("yes");System.exit(0);}	
			else
				System.out.println("No");
		}

	}

}
