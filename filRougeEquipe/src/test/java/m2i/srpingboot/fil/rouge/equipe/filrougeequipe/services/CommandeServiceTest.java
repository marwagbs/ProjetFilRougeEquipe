package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Commande;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Produit;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.TableRes;
@SpringBootTest
class CommandeServiceTest {

	private final CommandeService commandeService;
	private final TableResService tableService;

	 @Autowired
	public CommandeServiceTest(CommandeService commandeService , TableResService tableService) {
		this.commandeService=commandeService;
		this.tableService=tableService;
	}
	  
	 @Test
	 @Sql("classpath:commande_insertion.sql")
	 public void testTableByID() {
		 TableRes tableRes = tableService.getById(1);
		 assertEquals(1, tableRes.getId());
	 }
	 
	 
	 @Test
	 @Sql("classpath:commande_insertion.sql")
	 public void trouverLesCommandeServie() {
		List <Commande> commandeStatutServie=commandeService.trouverCommandesParStatut("Servie");
		assertEquals(2, commandeStatutServie.size());
	 }
	 @Test
	 @Sql("classpath:commande_insertion.sql")
	 public void trouverLePrixDelaCommande() {
		 TableRes tableRes = tableService.getById(12);
		Float commandeTarif=commandeService.calculerMontantTotalParTable(tableRes);
		assertEquals(35.98, commandeTarif, 0.01);
	 }
	 
	
	 
	
}
