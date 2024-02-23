package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Restaurant;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.RestaurantService;

@RestController
@CrossOrigin
@RequestMapping("/restaurants")
public class RestaurantController {
	@Autowired private RestaurantService restaurantservice;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Restaurant>> afficherAllRestaurants() {
		return new ResponseEntity<>(restaurantservice.getAll(), HttpStatus.OK);
	}
	
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Restaurant> afficherUnRestau(@PathVariable("id") int id){
		return new ResponseEntity<>(restaurantservice.getById(id), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Void> ajouterRestau(@RequestBody Restaurant r){
    restaurantservice.save(r);
	return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> modifierRestau(@PathVariable("id") int id, @RequestBody Restaurant r){
		r.setId(id);
		restaurantservice.save(r);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(path= "/{id}")
	public ResponseEntity<Void> supprimerRestau(@PathVariable("id") int id ){
	restaurantservice.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
}
