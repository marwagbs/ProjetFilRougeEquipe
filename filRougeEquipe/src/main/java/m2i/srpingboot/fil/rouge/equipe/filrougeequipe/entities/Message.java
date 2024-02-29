package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Table(name="messages")
@CrossOrigin
@Data
public class Message {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String contenu;
	private String sujet;
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="id_restaurant")
	private Restaurant restaurants;
}
