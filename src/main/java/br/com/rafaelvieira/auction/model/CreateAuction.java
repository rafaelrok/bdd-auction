package br.com.rafaelvieira.auction.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateAuction {

	private String nome;
	private List<Bid> lances = new ArrayList<>();
	public CreateAuction para(String nome) {
		this.nome = nome;
		return this;
	}

	public CreateAuction lance(User user, BigDecimal valor) {
		Bid lance = new Bid(user, valor);
		this.lances.add(lance);
		return this;
	}
	
	public Auction constroi() {
		Auction auction = new Auction(nome);
		this.lances.forEach( lance -> auction.propoe(lance));
		return auction;
	}

}
