package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Table(name="cartes")
@CrossOrigin
@Data
public class Carte {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
}
