//Hangman with JFrame

import java.util.Scanner;

public class Game {
	public static void main(String[]args) {
		Hangman man = new Hangman();
		Scanner scan = new Scanner(System.in);
		boolean b = true;
		while(b == true) {
			int s = scan.nextInt();
			if(s==0) {
				man.drawALine(true);
			}
			if(s==-1) 
				b = false;
		}
	}
}
