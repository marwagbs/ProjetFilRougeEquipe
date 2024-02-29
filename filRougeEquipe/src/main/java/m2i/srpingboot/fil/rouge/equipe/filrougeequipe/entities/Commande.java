package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity @Table(name="commandes")
@CrossOrigin
@Data
public class Commande {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String statut;
	private LocalDateTime heure;
	@OneToOne(
			cascade= CascadeType.ALL,
			fetch=FetchType.EAGER		
			)
	
	@JoinColumn(name="id_table")
	private TableRes tableRes;
	@ManyToMany(fetch =FetchType.LAZY)
	@JoinTable(
			name="Commandes_Produits",
			joinColumns= {@JoinColumn(name="id_commande")},
			inverseJoinColumns = {@JoinColumn(name="id_produit")}
			)
	private List<Produit> produits;
	@Transient
	private Float total;
}
