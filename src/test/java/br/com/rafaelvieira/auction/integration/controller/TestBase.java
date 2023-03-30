package br.com.rafaelvieira.auction.integration.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.User;

public class TestBase {

	public List<User> getUsuariosFulanoEBeltrano() {
		User fulano = getUsuarioFulano();
		
		User beltrano = new User("beltrano", "beltrano@gmail.com", "pass");
		beltrano.setRole("ROLE_USER");
		beltrano.activa();
		
		return Arrays.asList(fulano, beltrano);
	}

	public User getUsuarioFulano() {
		User fulano = new User("Fulano", "fulano@gmail.com", "pass");
		fulano.setRole("ROLE_USER");
		fulano.activa();
		return fulano;
	}
	
	
	public User getUsuarioCigano() {
		User fulano = new User("Cigano", "cigano@gmail.com", "pass");
		fulano.setRole("ROLE_USER");
		fulano.activa();
		return fulano;
	}
	
	public Auction geraLeilao(String nome, BigDecimal valor, LocalDate data, User user) {
		return new Auction(nome, valor, user);
	}
	
	public Auction getLeilaoTablet() {
		Auction auction = new Auction("Tablet",new BigDecimal("5.0"), getUsuarioFulano());
		return auction;
	}
	
	public Auction getLeilaoComputador() {
		Auction auction = new Auction("Computador",new BigDecimal("530.0"), getUsuarioFulano());
		return auction;
	}
	
	public List<Auction> getLeiloesComputadorETablet() {
		return Arrays.asList(getLeilaoTablet(), getLeilaoComputador());
	}
}
