package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

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

@Entity @Table(name="produits")
@CrossOrigin
@Data
public class Produit {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	private float prix;
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	@ManyToMany(fetch =FetchType.EAGER)
	@JoinTable(
			name="Produits_Cartes",
			joinColumns= {@JoinColumn(name="id_produit")},
			inverseJoinColumns = {@JoinColumn(name="id_carte")}
			)
	private List<Carte> cartes;
	
	
}