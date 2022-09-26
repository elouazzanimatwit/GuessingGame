package game;

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
		for(int i = 0; i < size; i++) {
			int a = (int) ((Math.random() * (range - 1)) + 1);
			game.add(a);
		}
	}
	
	private int getSize() {
		return game.getCurrentSize();
	}
	
	private void addFromUser(Integer value) {
		user.add(value);
	}
	
	private int numIntersections() {
		return game.intersection(user).getCurrentSize();
	}
	
	private void clearUser() {
		user.clear();
	}
	
	public static void play() {
		
	}
	
}
