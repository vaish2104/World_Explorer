package com.stackroute.favourites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favourites.model.Favourites;
import com.stackroute.favourites.repository.FavouritesRepository;

@Service
public class FavouritesService implements FavouritesServiceDeclaration{

	@Autowired
	private FavouritesRepository favouritesRepository;

	//To get the user details by using username
	public List<Favourites> getAllData(String username) {
		return (List<Favourites>) favouritesRepository.findByUsername(username);
	}

	//To add country data to the database and checking whether the data is already exists in database or not
	public boolean addData(Favourites favs) {
		try {
			int cidnew = favs.getCId();
			String usernamenew = favs.getUsername();
			List<Favourites> list = (List<Favourites>) favouritesRepository.findAll();
			for (Favourites temp : list) {
				if((temp.getCId() == cidnew) && (temp.getUsername().equalsIgnoreCase(usernamenew))) {
					return true;
				}
			}
			favouritesRepository.save(favs);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//This method is called when user deletes the account
	public boolean removeData(String username) {
		try {
			List<Favourites> list = favouritesRepository.findByUsername(username);
			for (Favourites temp : list) {
				favouritesRepository.deleteById(temp.getCId());
			}
			return true;
		} catch (Exception e) {
			System.out.println("no");
			return false;
		}
	}

	//This method is called when user clicks on unfavourite button
	public boolean removeUserData(String username, int cid) {
		try {
			List<Favourites> list = favouritesRepository.findByUsername(username);
			for(Favourites temp : list ) {
				if(temp.getCId()== cid) {
					favouritesRepository.deleteById(temp.getCId());
					return true;
				}
			}
			return false;	
		}catch (Exception e) {
			return false;
		}
	}
}
