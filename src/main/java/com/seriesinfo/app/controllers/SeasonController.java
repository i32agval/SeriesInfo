package com.seriesinfo.app.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seriesinfo.app.dao.IUsuarioDao;
import com.seriesinfo.app.entity.Cast;
import com.seriesinfo.app.entity.Credit;
import com.seriesinfo.app.entity.Episode;
import com.seriesinfo.app.entity.ListDetail;
import com.seriesinfo.app.entity.Lista;
import com.seriesinfo.app.entity.Movie;
import com.seriesinfo.app.entity.MovieDetail;
import com.seriesinfo.app.entity.Person;
import com.seriesinfo.app.entity.Result;
import com.seriesinfo.app.entity.ResultList;
import com.seriesinfo.app.entity.ResultMovie;
import com.seriesinfo.app.entity.Season;
import com.seriesinfo.app.entity.SeasonDetail;
import com.seriesinfo.app.entity.SeasonEpisode;
import com.seriesinfo.app.entity.SeasonInfo;

/**
 * Controller that handles application logic
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Controller
public class SeasonController {
	
	// Dependency injection
	@Autowired
	private IUsuarioDao usuarioDao;

	/** 
	 * Method that show the main view according to whether you are a guest or a registered user.
	 * @param model: interface that fill the model for representation in the view.
	 * @return "principal": view name.
	 */
	@GetMapping(value="/principal")
	public String principal(Model model) {

        model.addAttribute("guest", "invitado");
        return "principal";
	}

	
	/** 
	 * Method that show the main view according to whether you are a guest or a registered user.
	 * @param model: interface that fill the model for representation in the view.
	 * @param request: for the request header.
	 * @return "principal": view name.
	 */
	@GetMapping(value="/invitado")
	public String invitado(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
        session.setAttribute("guest", "invitado");
		
		return "principal";
	}
	

	/** 
	 * Method that show series list.
	 * @param pagina: page of the series list.
	 * @param consulta: series search string.
	 * @param model: interface that fill the model for representation in the view.
	 * @return "listar_series": view name.
	 */
	@GetMapping(value="/listar_series")
	public String series(
			@RequestParam(value="pagina", defaultValue="1") String pagina, 
			@RequestParam(name="consulta") String consulta,
			Model model) {
		
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String api_key = usuarioDao.findByUsername(currentUserName).getApi_key();

		String url = "https://api.themoviedb.org/3/discover/tv?api_key=" + api_key + "&language=es-ES&sort_by=popularity.desc&page=" + pagina + "&timezone=America%2FNew_York&include_null_first_air_dates=false";
	    if (!consulta.isEmpty()) {
	    	url = "https://api.themoviedb.org/3/search/tv?api_key=" + api_key + "&query=" + consulta + "&page=" + pagina;
	    }

		RestTemplate restTemplate = new RestTemplate();
	    Season season = restTemplate.getForObject(url, Season.class);
	    List<Result> resultado = season.getResults();

	    model.addAttribute("season", season);
	    model.addAttribute("result", resultado);
	    model.addAttribute("pagina", Integer.parseInt(pagina));
	    model.addAttribute("consulta2", consulta);
		
	    return "listar_series";
	}
	
	
	/** 
	 * Method that show movies list.
	 * @param pagina: page of the movies list.
	 * @param consulta: movies search string.
	 * @param model: interface that fill the model for representation in the view.
	 * @return "listar_peliculas": view name.
	 */
	@GetMapping(value="/listar_peliculas")
	public String peliculas(
			@RequestParam(value="pagina", defaultValue="1") String pagina, 
			@RequestParam(name="consulta") String consulta,
			Model model) {

		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String api_key = usuarioDao.findByUsername(currentUserName).getApi_key();
		
		String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + api_key + "&language=es-ES&sort_by=popularity.desc&include_adult=false&include_video=false&page=" + pagina + "&timezone=America%2FNew_York&include_null_first_air_dates=false";
	    if (!consulta.isEmpty()) {
	    	url = "https://api.themoviedb.org/3/search/movie?api_key=" + api_key + "&query=" + consulta + "&page=" + pagina;
	    }

		RestTemplate restTemplate = new RestTemplate();
	    Movie movie = restTemplate.getForObject(url, Movie.class);
	    List<ResultMovie> resultado = movie.getResults();

	    model.addAttribute("season", movie);
	    model.addAttribute("result", resultado);
	    model.addAttribute("pagina", Integer.parseInt(pagina));
	    model.addAttribute("consulta2", consulta);

	    return "listar_peliculas";
	}
	
	
	/** 
	 * Method that show series details.
	 * @param id: input variable containing the serie's id
	 * @param model: interface that fill the model for representation in the view.
 	 * @param request: for the request header.
	 * @return "detalle_serie": view name.
	 */
	@GetMapping(value="/detalle_serie/{id}")
	public String detalle_serie(@PathVariable (value="id") int id, Model model, HttpServletRequest request) {
		
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String api_key = usuarioDao.findByUsername(currentUserName).getApi_key();
		String request_token_valid = usuarioDao.findByUsername(currentUserName).getRequest_token_valid();
		
		String url = "https://api.themoviedb.org/3/tv/" + id + "?api_key=" + api_key + "&language=es-ES";
		
		RestTemplate restTemplate = new RestTemplate();
		SeasonDetail seasonDetail = restTemplate.getForObject(url, SeasonDetail.class);
		List <SeasonInfo> seasonInfo = seasonDetail.getSeasons();

		model.addAttribute("seasonDetail", seasonDetail);
		model.addAttribute("seasonInfo", seasonInfo);
		
		List<ResultList> resultList = mostrarListas(request).getBody().getResults();
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("request_token_valid", request_token_valid);
		
		return "detalle_serie";
	}
	
	
	/** 
	 * Method that show movies details.
	 * @param id: input variable containing the movie's id
	 * @param model: interface that fill the model for representation in the view.
 	 * @param request: for the request header.
	 * @return "detalle_pelicula": view name.
	 */
	@GetMapping(value="/detalle_pelicula/{id}")
	public String detalle_pelicula(@PathVariable (value="id") int id, Model model, HttpServletRequest request) {
		
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String api_key = usuarioDao.findByUsername(currentUserName).getApi_key();
		String request_token_valid = usuarioDao.findByUsername(currentUserName).getRequest_token_valid();
		
		String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=" + api_key + "&language=es-ES";
		String urlCredit = "https://api.themoviedb.org/3/movie/" + id + "/credits?api_key=" + api_key + "&language=es-ES";
		
		RestTemplate restTemplate = new RestTemplate();
		MovieDetail movieDetail = restTemplate.getForObject(url, MovieDetail.class);
		Credit credit = restTemplate.getForObject(urlCredit, Credit.class);
		List <Cast> cast = credit.getCast();

		model.addAttribute("movieDetail", movieDetail);
		model.addAttribute("credit", credit);
		model.addAttribute("cast", cast);
		model.addAttribute("request_token_valid", request_token_valid);
		
		List<ResultList> resultList = mostrarListas(request).getBody().getResults();
		
		model.addAttribute("resultList", resultList);
		
		return "detalle_pelicula";
	}
	
	
	/** 
	 * Method that show episode details.
	 * @param id: input variable containing the id of the serie.
	 * @param id_season: input variable containing the id of the episode.
	 * @param model: interface that fill the model for representation in the view.
	 * @return "listar_capitulos": view name.
	 */
	@GetMapping(value="/detalle_episodio/{id}/{id_season}")
	public String detalle_episodio(
			@PathVariable ("id") int id,
			@PathVariable ("id_season") int id_season,
			Model model) {

		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String api_key = usuarioDao.findByUsername(currentUserName).getApi_key();
		
		String url = "https://api.themoviedb.org/3/tv/" + id + "/season/" + id_season + "?api_key=" + api_key + "&language=es-ES";
		
		RestTemplate restTemplate = new RestTemplate();
		SeasonEpisode seasonEpisode = restTemplate.getForObject(url, SeasonEpisode.class);
		List<Episode> episodes = seasonEpisode.getEpisodes();

		model.addAttribute("seasonEpisode", seasonEpisode);
		model.addAttribute("episodes", episodes);

		return "listar_capitulos";
	}
	
	
	/** 
	 * Method that show person details.
	 * @param id: input variable containing the id of the character.
	 * @param model: interface that fill the model for representation in the view.
 	 * @param request: for the request header.
	 * @return "detalle_personaje": view name.
	 */
	@GetMapping(value="/detalle_personaje/{id}")
	public String detalle_personaje(@PathVariable (value="id") int id, Model model, HttpServletRequest request) {
		
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String api_key = usuarioDao.findByUsername(currentUserName).getApi_key();
		
		String url = "https://api.themoviedb.org/3/person/" + id + "?api_key=" + api_key + "&language=es-ES";
		String urlCredits = "https://api.themoviedb.org/3/person/" + id + "/movie_credits?api_key=" + api_key + "&language=es-ES";
		
		RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject(url, Person.class);
		
		Person person_cast = restTemplate.getForObject(urlCredits,  Person.class);
		List<ResultMovie> cast = person_cast.getCast();
		
		model.addAttribute("person", person);
		model.addAttribute("cast", cast);
		
		return "detalle_personaje";
	}

	

	/** 
	 * Method that show lists.
	 * @param model: interface that fill the model for representation in the view.
 	 * @param request: for the request header.
	 * @return "listas": view name.
	 */
	@GetMapping(value="/listas")
	public String listas (Model model, HttpServletRequest request) {
		
		ResponseEntity<Lista> resultList = mostrarListas(request);
		
		model.addAttribute("resultList", resultList.getBody().getResults());
		model.addAttribute("listas", resultList.getBody().getTotal_results());
		
		return "listas";
	}

	
	/** 
	 * Method that show lists.
 	 * @param request: for the request header.
	 * @return response: HTTP response with headers modified.
	 */
	public ResponseEntity<Lista> mostrarListas(HttpServletRequest request) {
		
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String request_token = usuarioDao.findByUsername(currentUserName).getRequest_token();
		String account_id = usuarioDao.findByUsername(currentUserName).getAccount_id();
		
		String url = "https://api.themoviedb.org/4/account/" + account_id + "/lists";
		
		RestTemplate restTemplate = new RestTemplate();
		
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        headers.set("Authorization", "Bearer " + request_token);

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Lista> response = restTemplate.exchange(url, HttpMethod.GET, entity, Lista.class);        

		return response;
	}
	
	
	/** 
	 * Method that show list detail.
	 * @param id: input variable containing the id of the list.
	 * @param model: interface that fill the model for representation in the view.
 	 * @param request: for the request header.
	 * @return "detalle_lista": view name.
	 */
	@GetMapping(value="/detalle_lista/{id}")
	public String detalle_lista (@PathVariable(value="id") Integer id, Model model, HttpServletRequest request) {
		
		ListDetail detalleLista = detalle_lista(id, request);
        model.addAttribute("detalles", detalleLista.getResults());
        model.addAttribute("list_id", id);
 
		return "detalle_lista";
	}
	
	
	/** 
	 * Method that obtain list detail.
	 * @param id: input variable containing the id of the list.
 	 * @param request: for the request header.
	 * @return response.getBody(): response body.
	 */
	public ListDetail detalle_lista(int id, HttpServletRequest request) {
        
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String request_token = usuarioDao.findByUsername(currentUserName).getRequest_token();

		RestTemplate restTemplate = new RestTemplate();
		
        //Set the headers you need send
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        headers.set("Authorization", "Bearer " + request_token);

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        //Execute the method writing your HttpEntity to the request
        ResponseEntity<ListDetail> response = restTemplate.exchange("https://api.themoviedb.org/4/list/" + id + "?language=es-ES", HttpMethod.GET, entity, ListDetail.class);        

        return response.getBody();
		
	}
	
	
	/** 
	 * Method for create a list. GET.
	 * @param model: interface that fill the model for representation in the view.
	 * @return "crear_list": view name.
	 */
	@RequestMapping(value="/create_list", method = RequestMethod.GET)
	public String create_list(Model model) {
		model.addAttribute("listaForm", new ResultList());
		return "crear_lista";
	}
	
	
	/** 
	 * Method for create a list. POST.
	 * @param lista: model of the list form.
	 * @param model: interface that fill the model for representation in the view.
  	 * @param request: for the request header.
  	 * @param redirectAttrs: to show messages in the view.
	 * @return "listas": view name.
	 */
	@RequestMapping(value="/create_list", method = RequestMethod.POST)
	public String create_list(
			@ModelAttribute("listaForm") ResultList lista, Model model, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		String request_token_valid = usuarioDao.findByUsername(currentUserName).getRequest_token_valid();

		String nombre = lista.getName();
		String descripcion = lista.getDescription();

		RestTemplate restTemplate = new RestTemplate();
		
        //Set the headers you need send
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        headers.set("Authorization", "Bearer " + request_token_valid);

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        restTemplate.exchange("https://api.themoviedb.org/4/list?access_token=" + request_token_valid + "&name=" + nombre + "&iso_639_1=en&public=false&description=" + descripcion, HttpMethod.POST, entity, Lista.class);

        redirectAttrs.addFlashAttribute("mensaje", "Lista creada");

		return "redirect:/listas";
	}

	
	/** 
	 * Method for edit a list. GET.
	 * @param id: input variable containing the id of the list.
	 * @param model: interface that fill the model for representation in the view.
  	 * @param request: for the request header.
	 * @return "editar_lista": view name.
	 */
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit_list(@PathVariable(value="id") int id, Model model, HttpServletRequest request) {
		
		model.addAttribute("editForm", detalle_lista(id, request));
		return "editar_lista";
		
	}

	
	/** 
	 * Method for edit a list. POST.
	 * @param id: input variable containing the id of the list.
	 * @param lista: model of the list form.
	 * @param model: interface that fill the model for representation in the view.
  	 * @param request: for the request header.
	 * @return "detalle_lista": name of the particular list view.
	 */
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public String edit_list(@PathVariable(value="id") int id, @ModelAttribute("editForm") ListDetail lista, Model model, HttpServletRequest request) {
		
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

		String request_token_valid = usuarioDao.findByUsername(currentUserName).getRequest_token_valid();

		String nombre = lista.getName();
		String descripcion = lista.getDescription();

		RestTemplate restTemplate = new RestTemplate();
		
        //Set the headers you need send
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        headers.set("Authorization", "Bearer " + request_token_valid);

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        restTemplate.exchange("https://api.themoviedb.org/4/list/" + id + "?name=" + nombre + "&description=" + descripcion + "&iso_639_1=en&public=false", HttpMethod.PUT, entity, Lista.class);

		
		model.addAttribute("editForm", new ListDetail());
		return "redirect:/detalle_lista/" + id;
		
	}
	
	
	/** 
	 * Method for delete a list.
	 * @param id: input variable containing the id of the list.
	 * @param model: interface that fill the model for representation in the view.
	 * @return "borrar_lista": view name.
	 */
	@GetMapping(value="/borrar/{id}")
	public String borrar (@PathVariable(value="id") int id, Model model) {
		
		model.addAttribute("list_id", id);
		
		return "borrar_lista";
	}
	
	
	/** 
	 * Method for confirm deletion of a list.
	 * @param id: input variable containing the id of the list.
	 * @param model: interface that fill the model for representation in the view.
  	 * @param request: for the request header.
  	 * @param redirectAttrs: to show messages in the view.
	 * @return "listas": view name.
	 */
	@RequestMapping(value="/borrar_confirm/{id}")
	public String borrar_confirm(@PathVariable(value="id") int id, Model model, HttpServletRequest request, RedirectAttributes redirectAttrs) {

		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

		String request_token_valid = usuarioDao.findByUsername(currentUserName).getRequest_token_valid();
		
		RestTemplate restTemplate = new RestTemplate();
		
        //Set the headers you need send
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json;charset=utf-8");
        headers.set("Authorization", "Bearer " + request_token_valid);

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        restTemplate.exchange("https://api.themoviedb.org/4/list/" + id, HttpMethod.DELETE, entity, Lista.class);
        
        redirectAttrs.addFlashAttribute("mensaje_borrar", "Lista borrada");

        return "redirect:/listas";
	}
	
	
	/** 
	 * Method to select an image.
 	 * @param id: input variable containing the id of the list.
	 * @param model: interface that fill the model for representation in the view.
  	 * @param request: for the request header.
	 * @return "seleccionar_imagen": view name.
	 */
	@RequestMapping(value="/seleccionar_imagen/{id}")
	public String seleccionar_imagen(@PathVariable(value="id") int id, Model model, HttpServletRequest request) {
        
		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String request_token_valid = usuarioDao.findByUsername(currentUserName).getRequest_token_valid();
		
		ListDetail detalle_lista = detalle_lista(id, request);
		model.addAttribute("detalle_lista", detalle_lista.getResults());
		model.addAttribute("lista", detalle_lista);
		model.addAttribute("request_token_valid", request_token_valid);
		
		return "seleccionar_imagen";
	}
	
	
	/** 
	 * Method for add a new element.
 	 * @param id: input variable containing the id of the list.
	 * @param model: interface that fill the model for representation in the view.
  	 * @param request: for the request header.
	 * @return "nuevo_elemento": view name.
	 */
	@RequestMapping(value="/buscar_media/{id}")
	public String buscar_media(@PathVariable(value="id") int id, Model model, HttpServletRequest request) {

		final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String request_token_valid = usuarioDao.findByUsername(currentUserName).getRequest_token_valid();
		String api_key = usuarioDao.findByUsername(currentUserName).getApi_key();
		
		model.addAttribute("list_id", id);
		
		ListDetail detalleLista = detalle_lista(id, request);
		
		model.addAttribute("detalle_lista", detalleLista.getResults());
		model.addAttribute("request_token_valid", request_token_valid);
		model.addAttribute("api_key", api_key);
		
		return "nuevo_elemento";
	}
}
