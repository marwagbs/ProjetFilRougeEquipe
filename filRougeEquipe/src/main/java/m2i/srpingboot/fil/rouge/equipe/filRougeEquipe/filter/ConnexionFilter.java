package m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.entities.Utilisateur;
import m2i.srpingboot.fil.rouge.equipe.filRougeEquipe.services.UtilisateurService;

@Component
public class ConnexionFilter implements Filter{
	@Autowired private UtilisateurService service;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		
		/*
		 * Si on essaie d'accéder au endpoint de login, on autorise l'accès
		 * sans vérifier d'autre condition
		 */
		if ("/connexion".equals(httpReq.getServletPath())
				|| "OPTIONS".equals(httpReq.getMethod())) {
			chain.doFilter(request, response);
			return;
		}
		
		/*
		 * Si le token n'est pas renseigné, on interdit l'accès
		 */
		String auth = httpReq.getHeader("token");
		if (auth == null || auth.isBlank()) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		}
		
		/*
		 * Si le token est renseigné mais ne correspond à aucun user
		 * on interdit l'accès
		 * Sinon, on autorise l'accès
		 */
		Utilisateur utilisateur = service.getByToken(auth);
		if (utilisateur == null) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		} 
		

        /*
         * Si le rôle de l'utilisateur n'est ni "admin" ni "equipe", interdire l'accès
         */
        if (!"admin".equals(utilisateur.getRole()) && !"equipe".equals(utilisateur.getRole())) {
            httpResp.sendError(HttpStatus.FORBIDDEN.value());
            return;
        }

        /*
         * Si le rôle de l'utilisateur est "client" ou "equipe", interdire l'accès à la
         * page de création de compte
         */
        if ("client".equals(utilisateur.getRole()) || "equipe".equals(utilisateur.getRole())) {
            if ("/creation-compte".equals(httpReq.getServletPath())) {
                httpResp.sendError(HttpStatus.FORBIDDEN.value());
                return;
            }
        }

        // Autoriser l'accès pour les autres cas
        chain.doFilter(request, response);
	}
}
