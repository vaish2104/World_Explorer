package com.stackroute.favourites.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.favourites.model.Favourites;
import com.stackroute.favourites.repository.FavouritesRepository;

public class FavouritesServiceTest {

	@Mock
    FavouritesRepository favouritesRepository;
	
	Favourites favourites;
	
	@InjectMocks
   FavouritesService favouritesService;
	
	@Before
	public void setUp() {
       MockitoAnnotations.initMocks(this);
       favourites = new Favourites();
       favourites.setCId(122);
		favourites.setCommon_name("India");
		favourites.setCapital("New Delhi");
		favourites.setFlag("https://flagcdn.com/w320/in.png");
		favourites.setOfficialname("Republic of India");
		favourites.setArea(3287590.0);
		favourites.setCoatOfArms("https://mainfacts.com/media/images/coats_of_arms/in.png");
		favourites.setPopulation(1380004385);
		favourites.setUsername("shiv@gmail.com");
		favourites.setStatus(true);
	}
	@Test
   public void addFavSuccess(){
       when(favouritesRepository.save((Favourites) any())).thenReturn(favourites);
       Favourites favSaved = favouritesRepository.save(favourites);
       assertEquals(favourites, favSaved);
   }
}
