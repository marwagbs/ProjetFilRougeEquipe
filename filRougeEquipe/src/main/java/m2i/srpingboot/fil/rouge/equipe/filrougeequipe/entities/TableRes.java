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

@Entity @Table(name="tableres")
@CrossOrigin
@Data
public class TableRes {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nombrePlaces;
	private int numeroTable;
	private String statut;
	@ManyToOne
	@JoinColumn(name="id_restaurant")
	private Restaurant restaurant;
	
}
