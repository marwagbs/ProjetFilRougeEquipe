package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Table(name="utilisateurs")
@CrossOrigin
@Data
public class Utilisateur {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private String telephone;
	private String token;
	private LocalDateTime tempsExpiration;
	private String role;
	
}
