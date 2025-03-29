package com.stackroute.favourites.service;

import java.util.List;

import com.stackroute.favourites.model.Favourites;

public interface FavouritesServiceDeclaration {

	public List<Favourites> getAllData(String username);
	
	public boolean addData(Favourites favs);
	
	public boolean removeData(String username);
	
	public boolean removeUserData(String username, int cid);
}
