package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories;

import java.util.ArrayList;
import java.util.List;

public class RepositoryException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<String> erreurs = new ArrayList<>();
	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RepositoryException() {}

	public void ajouterErreur(String erreur) {
		erreurs.add(erreur);
	}
	
	public List<String> getErreurs() {
		return erreurs;
	}
}

