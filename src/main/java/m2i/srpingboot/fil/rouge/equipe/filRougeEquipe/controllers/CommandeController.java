package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.controllers;

import java.util.List;

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

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Commande;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Restaurant;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.TableRes;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.CommandeService;


@RestController
@CrossOrigin
@RequestMapping("/commandes")
public class CommandeController {
	@Autowired private CommandeService cs;

	/********Recuperer tous les commandes des restaurant******/
	@GetMapping
	public ResponseEntity<Iterable<Commande>> getAll(){
		return new ResponseEntity<> (cs.selectAll(),HttpStatus.OK);
	}
	/********Recuperer une commandes par l'idt******/
	@GetMapping("/{id}")
	public ResponseEntity<Commande> find(@PathVariable("id") int id){
		return new ResponseEntity<>(cs.selectById(id), HttpStatus.OK);
	}
	/*****Effectuer une commande pout une table précis****/
	
	 @PostMapping("/effectuer/{id}")
	    public Commande effectuerCommande(@RequestBody List<Integer> produitIds, @PathVariable("id") int idTable) {
	        return cs.effectuerCommande(produitIds , idTable);
	    }
	
	/*****Afficher la commande par table *****/
	@GetMapping("/table/{idTable}")
    public ResponseEntity<Commande> findCommandesByTable(@PathVariable("idTable") int idTable) {
        TableRes tableRes = new TableRes();
        tableRes.setId(idTable);
       Commande commande = cs.findByTableRes(tableRes);
        // calcul du montnat total des commandes pour cette table 
        float montantTotal = cs.calculerMontantTotalParTable(tableRes);
        commande.setTotal(montantTotal);
        
        return new ResponseEntity<>(commande, HttpStatus.OK);
    }
	
	/*******Affficher la commande par restaurant****/
	 @GetMapping("/restaurant/{idRestaurant}")
	    public ResponseEntity<List<Commande>> findCommandesByRestaurant(@PathVariable("idRestaurant") int idRestaurant) {
	       
	        Restaurant restaurant = new Restaurant();
	        restaurant.setId(idRestaurant);
	        
	        List<Commande> commandes = cs.findByTableResRestaurant(restaurant);
	        return new ResponseEntity<>(commandes, HttpStatus.OK);
	    }
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Commande>update(@PathVariable("id") int id, @RequestBody Commande commande){
		commande.setId(id);
		cs.save(commande);
		return new ResponseEntity<>(commande, HttpStatus.OK);
	}
	
	/*******Modifier le statut  manuellement*******/
	@PutMapping("/modifier/{id}")
	public ResponseEntity<String>updateStatut(@PathVariable("id") int id, @RequestBody String statut){
			cs.modifierStatut(id, statut);

	      return new ResponseEntity<>("Statut de la commande avec l'ID " + id + " modifié avec succès", HttpStatus.OK);
	}
	/*******Modifier le statut  mauto en prete*******/
	@PutMapping("/modifierPrete/{id}")
	public ResponseEntity<String>updateStatutPrete(@PathVariable("id") int id){
			cs.modifierStatutPrete(id);

	      return new ResponseEntity<>("Statut de la commande avec l'ID " + id + " modifié avec succès", HttpStatus.OK);
	}
	/*******Modifier le statut  mauto en servie*******/
	@PutMapping("/modifierServie/{id}")
	public ResponseEntity<String>updateStatutServie(@PathVariable("id") int id){
			cs.modifierStatutServie(id);

	      return new ResponseEntity<>("Statut de la commande avec l'ID " + id + " modifié avec succès", HttpStatus.OK);
	}
	/*******Modifier le statut  mauto en reglee*******/
	@PutMapping("/modifierReglee/{id}")
	public ResponseEntity<String>updateStatutReglee(@PathVariable("id") int id){
			cs.modifierStatutReglee(id);

	      return new ResponseEntity<>("Statut de la commande avec l'ID " + id + " modifié avec succès", HttpStatus.OK);
	}
	
	/*******supprimer la commande *****/
	@DeleteMapping("/{id}")
	public ResponseEntity<Commande> delete (@PathVariable("id") int id){
		Commande commande=cs.selectById(id);
		cs.delete(id);
		return new ResponseEntity<>(commande, HttpStatus.OK);
	}

}