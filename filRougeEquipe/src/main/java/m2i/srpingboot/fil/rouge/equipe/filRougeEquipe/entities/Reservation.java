package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Table(name="reservations")
@CrossOrigin
@Data
public class Reservation {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  LocalDate dateRes; 
	private LocalTime heure;
	private int nbPersonne;
	private String statut;
	private String commentaire;	
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="id_restaurant")
	private Restaurant restaurant;
	@ManyToOne
	@JoinColumn(name="id_table")
	private TableRes tableRes;
		      
}
