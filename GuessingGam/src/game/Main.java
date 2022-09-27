package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		GuessingGame felburt = new GuessingGame();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("How many numbers do you want to guess? ");
			System.out.println("Specify the range : 2 to (your choice) ");
			
			GuessingGame.play(felburt, input);
			
			System.out.println("Does the User want to play again? true or false");
			String choice = input.nextLine();
			if(choice.equals("false")) {
				break;
			}
		} while(true);

	}

}
