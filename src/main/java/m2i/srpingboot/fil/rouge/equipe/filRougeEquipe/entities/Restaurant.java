package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity @Table(name="restaurants")
@CrossOrigin
@Data
public class Restaurant {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private String cpo;
	private String ville;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id_carte")
	private Carte carte;
	@ManyToMany(fetch =FetchType.EAGER)
	@JoinTable(
			name="horaires_restaurants",
			joinColumns= {@JoinColumn(name="id_restaurant")},
			inverseJoinColumns = {@JoinColumn(name="id_horaire")}
			)
	private List<Horaire> horaire;
	
	
}