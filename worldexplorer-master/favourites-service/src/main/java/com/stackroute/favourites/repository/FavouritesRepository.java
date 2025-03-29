package com.stackroute.favourites.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.favourites.model.Favourites;

@Repository
public interface FavouritesRepository extends CrudRepository<Favourites, Integer> {

	@Query("select f from Favourites f where f.username= ?1")
	List<Favourites> findByUsername(String username);
}
