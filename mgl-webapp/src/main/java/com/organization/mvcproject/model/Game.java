package com.organization.mvcproject.model;

import org.springframework.stereotype.Component;

@Component
public class Game {

	/**
	 * TODONE 1.0 java object member variable naming convention declared here are not object oriented,
	 *  rename the variables, and their setter/getter methods to match convention. 
	 */
	private Long id;
	private String name;
	private String genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
