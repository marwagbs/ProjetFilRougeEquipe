package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities;


import java.time.LocalTime;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Table(name="horaires")
@CrossOrigin
@Data
public class Horaire {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jour;
	private LocalTime heureOuverture;
	private LocalTime heureFermeture;

}
