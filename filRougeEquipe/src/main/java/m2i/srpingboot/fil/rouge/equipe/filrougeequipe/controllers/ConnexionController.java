package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Utilisateur;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services.ServiceException;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping("/connexion")
public class ConnexionController {
	
	private final UtilisateurService service;
	@Autowired
	public ConnexionController(UtilisateurService service) {
		this.service = service;
		
	}
	/*
	 * Endpoint utilisé pour authentifier un utilisateur au moment du login.
	 * Renvoie une erreur 401 "Unauthorized" si le couple identifiant / mdp est faux
	 * Renvoie un user avec son token si la connexion réussit
	 */
	
	@PostMapping
	public ResponseEntity<Object> verifierUtilisateur(@RequestParam String email, @RequestParam String motDePasse) {
	    try {
	        Utilisateur utilisateur = service.verifierUtilisateur(email, motDePasse);
	        return ResponseEntity.ok(utilisateur);
	    } catch (ServiceException e) {
	        return ResponseEntity.badRequest().body(e.getErreurs());
	    }
	}

}
