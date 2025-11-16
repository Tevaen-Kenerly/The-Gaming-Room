package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	private List<Player> players = new ArrayList<>();
	
	public Team (long id, String name) {
		super(id, name);
	}
    public Player addPlayer(String name) {
    	Player existingPlayer = null;
    	Iterator<Player> iterator = players.iterator();
    	
    	while(iterator.hasNext()) {
    		Player player = iterator.next();
    		if (player.getName().equalsIgnoreCase(name)) {
    			existingPlayer = player;
    			break;
    		}
    	}
    	if (existingPlayer != null)
    		return existingPlayer;
    	
    	Player newPlayer = new Player(GameService.getInstance().getNextPlayerId(),name);
    	players.add(newPlayer);
    	return newPlayer;
    	
    }
	
	/*
	 * Constructor with an identifier and name
	 */

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
