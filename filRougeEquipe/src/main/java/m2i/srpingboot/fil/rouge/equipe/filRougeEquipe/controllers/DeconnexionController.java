package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.UtilisateurService;
@RestController
@CrossOrigin
@RequestMapping("/deconnexion")
public class DeconnexionController {
	@Autowired private UtilisateurService service;
	/*
	 * Endpoint utilisé pour deconnecter un utilisateur grace à son token
	 */
	@GetMapping
	public void deconnexion(@RequestHeader("token") String token) {
		service.logout(token);
		
	}

}
