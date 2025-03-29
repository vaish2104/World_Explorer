package com.stackroute.favourites.model;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

public class FavoutitesTests {

	private Favourites favourites;

	@Before
	public void setUp() {
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
	public void test() {
		new BeanTester().testBean(Favourites.class);
	}
}
