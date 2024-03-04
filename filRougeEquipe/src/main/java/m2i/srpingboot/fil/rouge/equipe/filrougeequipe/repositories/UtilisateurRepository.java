package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer>{
	
	
	/*
	 * Nous permettra de retrouver un utilisateur d'après son token d'identification,
	 * à condition que le token n'ait pas expiré.
	 * Cette méthode est utilisée pour retrouver un utilisateur qui s'est déjà connecté.
	 */
	
	public Utilisateur findByTokenIsAndTempsExpirationAfter(String token, LocalDateTime tempsExpiration);

	/*
	 * Nous permettra de retrouver un utilisateur d'après son identifiant / mdp
	 * Cette méthode est utilisée pour trouver un utilisateur au moment de la connexion.
	 */
	
	public Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
	
	public Utilisateur findByEmail(String email);
}
