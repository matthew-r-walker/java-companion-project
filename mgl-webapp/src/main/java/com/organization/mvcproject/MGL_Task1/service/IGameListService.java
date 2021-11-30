package com.organization.mvcproject.MGL_Task1.service;

import java.util.List;

import com.organization.mvcproject.model.Game;

//TODONE 1.0  follow java interface naming conventions, improve interface name
public interface IGameListService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
