package br.com.rafaelvieira.auction.controller;

import java.security.Principal;

import javax.validation.Valid;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.mudi.dto.NewBidDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rafaelvieira.auction.service.BidService;

@Controller
@RequestMapping(value = "/lances")
public class BidController {

	
	@Autowired
	private BidService service;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView novoLance(@Valid @ModelAttribute("lance") NewBidDto lanceDto, Errors erros, Principal principal, RedirectAttributes redirectAttributes) {

		Auction auction = service.getLeilao(lanceDto.getLeilaoId());

		if(erros.hasErrors()) {
			ModelAndView mv = new ModelAndView("/leilao/show");
			mv.addObject("lance", lanceDto);
			mv.addObject("leilao", auction);
			return mv;
		}
		
		if(service.propoeLance(lanceDto, principal.getName())) {
			redirectAttributes.addFlashAttribute("message", "Bid adicionado com sucesso!");
		} else {
			redirectAttributes.addFlashAttribute("error", "Bid invalido!");
		}
		
		String redirectURL = "redirect:/leiloes/" + lanceDto.getLeilaoId();
		return new ModelAndView(redirectURL);
	}

	
}
