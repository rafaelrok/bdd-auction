package br.com.rafaelvieira.auction.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import br.com.rafaelvieira.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafaelvieira.auction.repositories.UsuarioRepository;


//@Controller
//@RequestMapping("/usuarios")
public class UserController {

	@Autowired
	private UsuarioRepository repository;
	
	
	@GetMapping()
	public List<User> index() {
		return repository.findAll();
	}
	
	@PostMapping()
	public String create(User user, BindingResult result) {
		
		if (user.getNome().isEmpty()) {
		    result.addError(new FieldError("user", "nome", "Nome obrigatorio!"));
		}
		if (user.getEmail().isEmpty()) {
		    result.addError(new FieldError("user", "email", "Email obrigatorio!"));
		}
		
		if(result.hasErrors()) {
			return "/usuarios/new";
		}
		
		repository.save(user);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/new")
	public ModelAndView newUsuario() {
		ModelAndView mv = new ModelAndView("/newUsuarios");
		mv.addObject("usuario", new User());
		return mv;
	}
	
	@PutMapping()
	public String update(User user, BindingResult result) {
		
		if (user.getNome().isEmpty()) {
		    result.addError(new FieldError("user", "nome", "Nome obrigatorio!"));
		}
		if (user.getEmail().isEmpty()) {
		    result.addError(new FieldError("user", "email", "Email obrigatorio!"));
		}
		
		if(result.hasErrors()) {
			return "/usuarios/edit";
		}
		
		repository.save(user);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathParam("id") Long usuarioId) {
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("usuario", repository.getOne(usuarioId));
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView show(@PathParam("id") Long usuarioId) {
		ModelAndView mv = new ModelAndView("show");
		mv.addObject("usuario", repository.getOne(usuarioId));
		return mv;
	}

	@DeleteMapping("/{id}")
	public String destroy(@PathParam("id") Long usuarioId) {
		repository.delete(repository.getOne(usuarioId));
		return "redirect:/leileos";
	}
}