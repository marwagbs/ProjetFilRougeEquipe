package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Commande;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;
@SpringBootTest
class CommandeServiceTest {

	private final CommandeService commandeService;
	private final TableResService tableService;
	
	public CommandeServiceTest(CommandeService commandeService , TableResService tableService) {
		this.commandeService=commandeService;
		this.tableService=tableService;
	}
	 @Test
	    public void testCreationCommande() {
	        Commande commande = new Commande();
	        commande.setStatut("En cours");
	        LocalDateTime heureActuelle = LocalDateTime.now();
	        commande.setHeure(heureActuelle);
	        TableRes tableRes= tableService.getById(1);
        	commande.setTableRes(tableRes);
	        commande = commandeService.save(commande);

	        assertNotNull(commande.getId());
	        assertTrue(commande.getId() > 0);
	    }

}
