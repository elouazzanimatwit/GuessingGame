package game;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	private LinkedBag <Integer> user;
	private LinkedBag <Integer> game;
	
	public GuessingGame() {
		user = new LinkedBag<Integer>();
		game = new LinkedBag <Integer>();
		System.out.println("In this game you select a number of integers to guess "
				+ "The system generates this number of random integers (2 to whatever you select). "
				+ "They are not necessarily distinct "
				+ "You will try to guess them in several attempts.");
	}
	
	private void initializeGame(int size, int range) {
		Random random = new Random();
		for(int i = 0; i < size; i++) {
		    int much =random.nextInt(range - 2) + 2;
			game.add(much);
		}
	}
	
	private int getSize() {
		return game.getCurrentSize();
	}
	
	private void addFromUser(Integer value) {
		user.add(value);
	}
	
	private int numIntersections() {
		return (game.intersection(user)).getCurrentSize();
	}
	
	private void clearUser() {
		user.clear();
	}
	
	public static void play(GuessingGame g, Scanner input) {
		int size = input.nextInt();
		int range = input.nextInt();
		g.initializeGame(size, range);
		
		int i = 1;
		
		while(i < g.getSize()+1) {
			System.out.println("Hello User! Please input your guess for element #" + (i));
			int guess = input.nextInt();
			g.addFromUser(guess);
			i++;
		}
		
		if(g.numIntersections() == g.getSize()) {
			System.out.println("You Win!");
		} else{
			System.out.println("You Lose!");
			g.clearUser();
		}
	}
	
}
