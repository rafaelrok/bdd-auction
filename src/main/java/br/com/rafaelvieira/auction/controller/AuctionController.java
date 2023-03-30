	package br.com.rafaelvieira.auction.controller;

import java.security.Principal;

import javax.validation.Valid;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.User;
import br.com.rafaelvieira.auction.mudi.dto.NewBidDto;
import br.com.rafaelvieira.auction.mudi.dto.NewAuctionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rafaelvieira.auction.repositories.LeilaoRepository;
import br.com.rafaelvieira.auction.repositories.UsuarioRepository;

@Controller
@RequestMapping("/leiloes")
public class AuctionController {


	@Autowired
	private LeilaoRepository leiloes;
	
	@Autowired
	private UsuarioRepository usuarios;

	
	@GetMapping
	public ModelAndView index(Principal principal) {
		ModelAndView mv = new ModelAndView("leilao/index");
		mv.addObject("leiloes", leiloes.findAll());
		mv.addObject("usuarioLogado", principal);
		return mv;
	}
	
	@GetMapping("/{id}/form")
	public ModelAndView form(@PathVariable("id") Long id, Principal principal) {
		
		Auction auction = leiloes.getOne(id);
		NewAuctionDto form = new NewAuctionDto(auction);
		
		ModelAndView mv = new ModelAndView("leilao/form");
		mv.addObject("usuario", principal.getName());
		mv.addObject("leilao", form);
		return mv;
	}
	
	@PostMapping
	public ModelAndView saveOrUpdate(@Valid @ModelAttribute("leilao") NewAuctionDto leilaoForm, Errors errors, RedirectAttributes attr, Principal principal) {

		if(errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("/leilao/form");
			mv.addObject("leilao", leilaoForm);
			mv.addObject("usuario", principal.getName());
			return mv;
		}
		
		User user = usuarios.getUserByUsername(principal.getName());
		Auction auction = leilaoForm.toLeilao();
		auction.setUsuario(user);
		
		leiloes.save(auction);
		
		attr.addFlashAttribute("message", "Leilão salvo com sucesso");
		
		return new ModelAndView("redirect:/leiloes");
	}
	
	@GetMapping("/new")
	public ModelAndView newLeilao(Principal principal) {
		ModelAndView mv = new ModelAndView("leilao/form");
		mv.addObject("usuario", principal.getName());
		mv.addObject("leilao", new NewAuctionDto());
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Long id, Principal principal) {
		ModelAndView mv = new ModelAndView("leilao/show");
		mv.addObject("usuario", principal.getName());
		mv.addObject("leilao", leiloes.getOne(id));
		mv.addObject("lance", new NewBidDto());
		return mv;
	}
	
}