package game;

public class GuessingGame {

	private LinkedBag <Integer> user;
	private LinkedBag <Integer> game;
	
	public GuessingGame() {
		user = new LinkedBag<Integer>();
		game = new LinkedBag <Integer>();
		System.out.println("In this game you select a number of integers to guess "
				+ "The system generates this number of random integers. "
				+ "They are not necessarily distinct "
				+ "You will try to guess them in several attempts.");
	}
	
	
}
