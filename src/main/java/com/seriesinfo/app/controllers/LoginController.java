package com.seriesinfo.app.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seriesinfo.app.dao.IUsuarioDao;
import com.seriesinfo.app.entity.Authentication;
import com.seriesinfo.app.entity.Usuario;

@Controller
public class LoginController {

	// Dependencies injection
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	/** 
	 * Method that show login view.
	 * @param model: interface that fill the model for representation in the view.
 	 * @param request: for the request header.
 	 * @param flash: to show messages in the view.
	 * @return "login": view name.
	 */
	@RequestMapping(value = {"/login", "/"})
	public String login(Model model, HttpServletRequest request, RedirectAttributes flash) {
		
		HttpSession session = request.getSession(true);
        session.setAttribute("guest", "registrado");
        flash.addFlashAttribute("success", "Sesión iniciada");
		
		return "login";
	}
	
	
	/** 
	 * Method for register an user. POST.
	 * @param userForm: model for the user form.
 	 * @param request: for the request header.
	 * @return "registration" or "error_log": view name.
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") Usuario userForm, HttpServletRequest request) {
		
		userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
		String usuario = userForm.getUsername();
		if(usuarioDao.findByUsername(userForm.getUsername()) != null) {
			return "redirect:registration";
		}
		
		String url = "https://api.themoviedb.org/4/auth/request_token?redirect_to=http://localhost:8080/jojo?usuario=" + usuario;

		RestTemplate restTemplate = new RestTemplate();
		
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        headers.set("Authorization", "Bearer " +  userForm.getRequest_token());
		
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        try {
        	ResponseEntity<Authentication> response = restTemplate.exchange(url, HttpMethod.POST, entity, Authentication.class);        
        	HttpSession session = request.getSession(true);
            userForm.setRequest_token_prov(response.getBody().getRequest_token());
            session.setAttribute("guest", "registrado");

    		String url_redirect = "https://www.themoviedb.org/auth/access?request_token=" + response.getBody().getRequest_token();

    		usuarioDao.save(userForm);

    		return "redirect:" + url_redirect;
        }catch(Exception e) {
        	return "error_log";
        }

	}
	
	
	/** 
	 * Method for register an user. GET.
	 * @param model: interface that fill the model for representation in the view.
	 * @return "registration": view name.
	 */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Usuario());

        return "registration";
    }
    
	
	/** 
	 * Method that login in the platform.
	 * @param usuario: input variable containing the name of the user.
 	 * @param request: for the request header.
	 * @return "detalle_personaje": view name.
	 */
	@RequestMapping(value = "/jojo")
	public String jojo (@RequestParam(value="usuario") String usuario, HttpServletRequest request) {

		HttpSession session = request.getSession(true);

		String request_token = usuarioDao.findByUsername(usuario).getRequest_token();
		String request_token_prov = usuarioDao.findByUsername(usuario).getRequest_token_prov();

		String url = "https://api.themoviedb.org/4/auth/access_token?request_token=" + request_token_prov;

		RestTemplate restTemplate = new RestTemplate();
		
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        headers.set("Authorization", "Bearer " + request_token);
 
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        ResponseEntity<Authentication> response = restTemplate.exchange(url, HttpMethod.POST, entity, Authentication.class);

		Authentication restCall = response.getBody();

        session.setAttribute("account_id", restCall.getAccount_id());
		session.setAttribute("access_token", restCall.getAccess_token());
		
		Usuario user = usuarioDao.findByUsername(usuario);
		user.setRequest_token_valid(restCall.getAccess_token());
		user.setAccount_id(restCall.getAccount_id());
		usuarioDao.save(user);
		
		return "login";
	}
	
	
	/** 
	 * Method that close the session.
	 * @param Flash: for show messages in the view.
 	 * @param request: for the request header.
	 * @return "login": view name.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String cerrar_sesion (HttpServletRequest request, RedirectAttributes Flash) throws ServletException {
	        request.logout();
	        Flash.addFlashAttribute("success", "Sesión cerrada");
	    return "redirect:/login";
	}
}
