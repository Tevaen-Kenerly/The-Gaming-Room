package com.gamingroom;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
//Tevaen Kenerly -  11/09/25
/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();
    private static long nextGameId = 1;
    private static long nextTeamId = 1;
    private static long nextPlayerId = 1;
    
	/*
	 * Holds the next game identifier
	 */

    private static GameService instance = new GameService();
    private GameService() {};
     
    public static GameService getInstance() {
    	return instance;
    }

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game existingGame = null;

        for(Iterator<Game> iterator = games.iterator(); iterator.hasNext();) {
        	Game game = iterator.next();
        	if (game.getName().equalsIgnoreCase(name)) {
        		existingGame = game;
        		break;
        	}
        }
		// if not found, make a new game instance and add to list of games
		if (existingGame != null) {
			return existingGame;
		}
        Game newGame = new Game(nextGameId++, name);
        games.add(newGame);
        return newGame;
		// return the new/existing game instance to the caller
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
        	Game existingGame = iterator.next();
        	if (existingGame.getId() == id) {
        		game = existingGame;
        		break;
        	}
        }
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
        	Game existingGame = iterator.next();
        	if (existingGame.getName().equalsIgnoreCase(name)) {
        		game = existingGame;
        		break;
        	}
        }
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	public long getNextTeamId() {
		return nextTeamId++;
	}
}
