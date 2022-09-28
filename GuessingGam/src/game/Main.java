package game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GuessingGame g = new GuessingGame();
        Scanner input = new Scanner(System.in);

        boolean a = false;
        
        do {
            System.out.println("How many numbers do you want to guess? ");
            System.out.println("Specify the range : 2 to (your choice) ");

            GuessingGame.play(g, input);

            System.out.println("Does the User want to play again? yes or no");
            String choice = input.nextLine();


            if(choice.equals("yes") || choice.equals("Yes")) {
                a = true;
            } else if(choice.equals("no") || choice.equals("No")) {
            	a = false;
            }
        } while(a);

    }

}