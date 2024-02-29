package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private List<String> erreurs = new ArrayList<>();

	public ServiceException() {
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public void ajouterErreur(String erreur) {
		erreurs.add(erreur);
	}
	
	public List<String> getErreurs() {
		return erreurs;
	}
}
