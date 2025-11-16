package com.gamingroom;
//Tevaen Kenerly -  11/09/25
/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXME: obtain reference to the singleton instance
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		Team t1 = game1.addTeam("Team 1");
		System.out.println(t1);
		Team t2 = game1.addTeam("Team 2");
		System.out.println(t2);
		
		Player p1 = t1.addPlayer("Player 1");
		System.out.println(p1);
		Player p2 = t1.addPlayer("Player 2");
		System.out.println(p2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
