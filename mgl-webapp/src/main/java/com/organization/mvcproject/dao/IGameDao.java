package com.organization.mvcproject.dao;

import java.util.List;

import com.organization.mvcproject.model.Game;

//TODONE 1.0  follow java interface naming conventions, improve interface name
public interface IGameDao {

	List<Game> findAllGames();

	Game saveGame(Game game);
	
	boolean deleteGameById(long gameId);
	
	Game findGameById(long gameId);
	
	List<Game> findGamesByGenre(String genre);
	
}
