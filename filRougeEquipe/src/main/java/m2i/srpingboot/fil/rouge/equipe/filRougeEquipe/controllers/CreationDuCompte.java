package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Utilisateur;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping("/creationDuCompte")
public class CreationDuCompte {
	@Autowired private UtilisateurService service;
	
	@PostMapping
	public ResponseEntity<Utilisateur> insert(@RequestBody Utilisateur utilisateur){
		service.insert(utilisateur);
		return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
	}
	
}