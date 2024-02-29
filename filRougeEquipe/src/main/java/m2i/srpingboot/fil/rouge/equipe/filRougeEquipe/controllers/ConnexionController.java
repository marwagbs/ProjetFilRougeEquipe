package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Utilisateur;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.ServiceException;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping("/connexion")
public class ConnexionController {
	@Autowired private UtilisateurService service;
	
	/*
	 * Endpoint utilisé pour authentifier un utilisateur au moment du login.
	 * Renvoie une erreur 401 "Unauthorized" si le couple identifiant / mdp est faux
	 * Renvoie un user avec son token si la connexion réussit
	 */
	
	@PostMapping
	public ResponseEntity<?> verifierUtilisateur(@RequestParam String email, @RequestParam String motDePasse) {
	    try {
	        Utilisateur utilisateur = service.verifierUtilisateur(email, motDePasse);
	        return ResponseEntity.ok(utilisateur);
	    } catch (ServiceException e) {
	        return ResponseEntity.badRequest().body(e.getErreurs());
	    }
	}

}
