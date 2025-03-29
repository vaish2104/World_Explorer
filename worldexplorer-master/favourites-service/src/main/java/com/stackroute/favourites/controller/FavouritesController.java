package com.stackroute.favourites.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favourites.model.Favourites;
import com.stackroute.favourites.service.FavouritesService;

@RestController                 //Takes care of mapping request data to the defined request handler method.
@RequestMapping("/api/fav")     //maps HTTP requests to handler methods of MVC and REST controllers.
@CrossOrigin(value = "*")       //helps to request additional resources into browser from other domains
public class FavouritesController {

	@Autowired          //injecting the object dependency implicitly
	private FavouritesService favouritesService;
	
	/*
	 * http://localhost:8005/api/fav (Get)
	 * End point for getting list of all favorite countries of a user from the DB
	 * If retrieved data successfully returning status as OK
	 * Otherwise returning status as Conflict
	 */
	@GetMapping  //GET requests onto specific handler methods.
	public ResponseEntity<?> getAllPlayers(@RequestParam("username") String username) {
		try {
			return new ResponseEntity<List<Favourites>>(favouritesService.getAllData(username),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("no",HttpStatus.CONFLICT);
		}
	}
	
	/*
	 * http://localhost:8005/api/fav (Post)
	 * End point for adding a favorite countries in the DB
	 * If added data successfully returning status as Created
	 * Otherwise returning status as Conflict
	 */
	@PostMapping        //POST requests matched with given URL expression
	public ResponseEntity<?> addData(@RequestBody Favourites favs) {
		if(favouritesService.addData(favs)) {
			return new ResponseEntity<String>("ok", HttpStatus.CREATED);
		}
		else return new ResponseEntity<String>("no", HttpStatus.CONFLICT);
	}
	
	
	/*
	 * http://localhost:8005/api/fav (Delete)
	 * End point for deleting all favorite countries of a particular user in the DB
	 * If deleted data successfully returning status as OK
	 */
	@DeleteMapping             // maps  HTTP DELETE requests onto specific handler methods
	public ResponseEntity<String> deleteallData(@RequestParam("username") String username){
		favouritesService.removeData(username);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	/*
	 * http://localhost:8006/api/recom (Post)
	 * End point for deleting a particular favorite country from the DB
	 * If deleted successfully returning status as OK
	 */
	@PostMapping("id")      // maps  HTTP DELETE requests onto specific handler methods 
	public ResponseEntity<String> deleteData(@RequestBody Map<String, String> json){
		favouritesService.removeUserData(json.get("username"), Integer.parseInt(json.get("cid")));
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
