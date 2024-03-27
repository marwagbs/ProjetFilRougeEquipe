package m2i.srpingboot.fil.rouge.equipe.filrougeequipe.filter;
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
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.entities.Utilisateur;
import m2i.srpingboot.fil.rouge.equipe.filrougeequipe.services.UtilisateurService;
 
@Component
public class ConnexionFilter implements Filter{
	@Autowired private UtilisateurService service;
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;

 
		if ("/connexion".equals(httpReq.getServletPath())
				|| "OPTIONS".equals(httpReq.getMethod())) {
			chain.doFilter(request, response);
			return;
		}
		String auth = httpReq.getHeader("token");
		if (auth == null || auth.isBlank()) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		}
 
		Utilisateur utilisateur = service.getByToken(auth);
		if (utilisateur == null) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		} 

 
        if (!"admin".equals(utilisateur.getRole()) && !"equipe".equals(utilisateur.getRole())) {
            httpResp.sendError(HttpStatus.FORBIDDEN.value());
            return;
        }
 
        if ("client".equals(utilisateur.getRole()) || "equipe".equals(utilisateur.getRole())) {
            if ("/creation-compte".equals(httpReq.getServletPath())) {
                httpResp.sendError(HttpStatus.FORBIDDEN.value());
                return;
            }
        }
        chain.doFilter(request, response);
	}

}

