package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Produit;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services.ProduitService;

@RestController
@CrossOrigin
@RequestMapping("/produits")
public class ProduitController {
	
	@Autowired private ProduitService ps;
	

	
	@GetMapping
	public ResponseEntity<Iterable<Produit>> getAllProduit(){
		return new ResponseEntity<> (ps.selectAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Iterable<Produit>> findProduitByRestaurant(@PathVariable("id") int id){
		return new ResponseEntity<>(ps.selectAllByRestaurant(id), HttpStatus.OK);
	}
	

}
