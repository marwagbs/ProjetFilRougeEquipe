package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Utilisateur;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.repositories.UtilisateurRepository;
@Service
public class UtilisateurService {
	
	@Autowired private UtilisateurRepository repo;
	
	public void insert(Utilisateur utilisateur) {
		ServiceException serviceException = new ServiceException();
		try {
			verifierLesDonnees(utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getTelephone());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  byte[] saltBytes = utilisateur.getEmail().getBytes();
	        String hashedMotDePasse = hashMotDePasse(utilisateur.getMotDePasse(), saltBytes);
	        utilisateur.setNom(utilisateur.getNom());
	        utilisateur.setPrenom(utilisateur.getPrenom());
	        utilisateur.setEmail(utilisateur.getEmail());
	        utilisateur.setMotDePasse(hashedMotDePasse);
	        utilisateur.setTelephone(utilisateur.getTelephone());
	        utilisateur.setRole("employe");
	        
	        if(repo.findByEmail(utilisateur.getEmail()) != null) {
				serviceException.ajouterErreur("Cette adreese email existe déja");
			}else {
				repo.save(utilisateur);
			}
	        
	       
		
	}
		
	public Utilisateur selectByEmail(String email) throws ServiceException {
			return repo.findByEmail(email);
	}
	
	 public  boolean validatePassword(String motDePasse) {
	        // la regex MDP
	        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	        // Création du pattern
	        Pattern pattern = Pattern.compile(regex);

	        // Création du matcher
	        Matcher matcher = pattern.matcher(motDePasse);

	        // Vérification de la correspondance
	        return matcher.matches();
	    }
	 
	 public  boolean validateEmail(String email) {

	        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	        Pattern pattern = Pattern.compile(regex);

	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }
	 
	 public  String  hashMotDePasse(String motDePasseToHash, byte [] salt) {
	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	            md.update(salt);
	            md.update(motDePasseToHash.getBytes(StandardCharsets.UTF_8));
	            byte[] bytes = md.digest();

	            StringBuilder sb = new StringBuilder();
	            for (byte b : bytes) {
	                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
	            }

	            generatedPassword = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }

	 	
	
	
	 public Utilisateur verifierUtilisateur(String email, String motDePasse) throws ServiceException {
		 ServiceException serviceException = new ServiceException();
		 Utilisateur utilisateur = repo.findByEmail(email);
		if (utilisateur != null) { 
		        String motDePasseSaisie = hashMotDePasse(motDePasse, email.getBytes());
		        String mdpHache=utilisateur.getMotDePasse();
		       
		        if (!motDePasseSaisie.equals(mdpHache)) {
		        	serviceException.ajouterErreur("Mot de passe incorrect");
		        	throw serviceException;
		       
		        } else {
		        	//Generation du token
		        	utilisateur.setToken(generateToken());
		        	utilisateur.setTempsExpiration(LocalDateTime.now().plusMinutes(30));
		        	repo.save(utilisateur);
		        	return utilisateur;
		        }
		} else {
			serviceException.ajouterErreur("L'adresse e-mail fournie ne correspond à aucun compte."); 
			 throw serviceException;
		}

	    }
	 
	 /*
		 * Quand on s'identifie avec le token, on en profite pour mettre à jour
		 * la date d'expiration du token. Ainsi, tant que l'utilisateur est actif
		 * sur l'application, le token n'expire pas.
		 */
		public Utilisateur getByToken(String token) {
			Utilisateur utilisateur = repo.findByTokenIsAndTempsExpirationAfter(token, LocalDateTime.now());
			if (utilisateur != null) {
				utilisateur.setTempsExpiration(LocalDateTime.now().plusMinutes(30));
				repo.save(utilisateur);
			}
			return utilisateur;
		}
	 
	 public void logout(String token) {
			Utilisateur utilisateur = repo.findByTokenIsAndTempsExpirationAfter(token, LocalDateTime.now());
			if (utilisateur != null) {
				utilisateur.setToken(null);
				utilisateur.setTempsExpiration(null);
				repo.save(utilisateur);
			}
		}
		
		/*
		 * Les attributs static suivants et la méthode generateToken
		 * sont des outils nous permettant de générer un token aléatoire
		 * de 64 caractères de long.
		 */
		private static final SecureRandom secureRandom = new SecureRandom();
		private static final Encoder base64encoder = Base64.getUrlEncoder();
		
		private String generateToken() {
			byte[] randomBytes = new byte[48];
			secureRandom.nextBytes(randomBytes);
			return base64encoder.encodeToString(randomBytes);
		}
	 
	 private  void verifierLesDonnees(String nom, String prenom, String email, String motDePasse, String telephone) throws ServiceException {
			
		 ServiceException serviceException = new ServiceException();
			
			
			if (nom.isEmpty() || nom.length() < 2 || nom.length() > 50) {
				serviceException.ajouterErreur("Le nom doit avoir entre 2 et 50 caractères");
			}

			if (prenom.isEmpty() || prenom.length() < 2 || prenom.length() > 50) {
				serviceException.ajouterErreur("Le prénom doit avoir entre 2 et 50 caractères");
			}
			if (motDePasse.isEmpty() || !validatePassword(motDePasse)) {
				serviceException.ajouterErreur("Le mot de passe doit contenir entre 8 et 20 caractères, "
			            + "incluant au moins une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial");
			}

			if (email.isEmpty() || !validateEmail(email)) {
				serviceException.ajouterErreur("L'e-mail n'est pas valide");
			}
			
			if (telephone.isEmpty() || telephone.length() < 8 || telephone.length() > 50) {
				serviceException.ajouterErreur("Le numéro de téléphone doit avoir entre 8 et 50 caractères");
			}
			
			if (serviceException.getErreurs().size() > 0) {
				throw serviceException;
			}
}
	 
}
