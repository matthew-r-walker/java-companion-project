package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.organization.mvcproject.model.Game;

@Repository
public class GameDao implements IGameDao {

	/**
	 * TODONE 2.0 The class that interacts with persistent data is called a Data Access Object(DAO)
	 *  or a Repository class. The private static list is mocking our persistence of games.
	 *   
	 *  Move this list, and methods operating on this list to an appropriately named package and class.
	 */
	
	private static Long gameId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	@Override
	public List<Game> findAllGames() {
		List<Game> gamesCopy = new ArrayList<>(games);
		return gamesCopy;
	}

	@Override
	public Game saveGame(Game game) {
		if (game.getId() != null) {
			if (findGameById(game.getId()) != null) {
				for (int i = 0; i < games.size(); i++) {
					if (game.getId().equals(games.get(i).getId())) {
						return games.set(i, game);
					}
				}
			}
		}
		game.setId(++gameId);
		games.add(game);
		return game;
	}
	
	@Override
	public Game findGameById(long gameId) {
		for (Game game : games) {
			if (gameId == (long) game.getId()) {
				return game;
			}
		}
		return null;
	}
	
	@Override
	public boolean deleteGameById(long gameId) {
		Game gameToRemove = findGameById(gameId);
		if (gameToRemove != null) {
			games.remove(gameToRemove);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Game> findGamesByGenre(String genre) {
		return null;
	}

	
	

}