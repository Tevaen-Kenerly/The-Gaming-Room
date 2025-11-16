package com.gamingroom;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	private List<Team> teams = new ArrayList<>();
	
	public Game (long id, String name) { 
		super(id, name);
	}
	public Team addTeam(String name) {
		Team existingTeam = null;
		Iterator<Team> iterator = teams.iterator();
		
		while (iterator.hasNext()) {
			Team team = iterator.next();
			if (team.getName().equalsIgnoreCase(name)) {
				existingTeam = team;
				break;
			}
		}
		if (existingTeam != null)
			return existingTeam;
		
		Team newTeam = new Team(GameService.getInstance().getNextTeamId(),name);
		teams.add(newTeam);
		return newTeam;
	}
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	/**
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
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
