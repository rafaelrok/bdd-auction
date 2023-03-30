package br.com.rafaelvieira.auction.e2e.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.rafaelvieira.auction.e2e.pages.UpdateAuctionPage;
import br.com.rafaelvieira.auction.e2e.pages.AuctionPage;
import br.com.rafaelvieira.auction.e2e.pages.LoginPage;
import br.com.rafaelvieira.auction.e2e.pages.NewAuctionPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuctionE2ETest extends E2ETestBase{
	
	private AuctionPage auctionPage;

	@BeforeEach
	void setup() {
		LoginPage loginPage = new LoginPage(getDriver());
		auctionPage = loginPage.realizaLoginComoFulano();
	}

	@Test
	public void deveCadastrarUmLeilao() {
		NewAuctionPage novoLeilaoPage = auctionPage.visitaPaginaParaCriarUmNovoLeilao();
		String nome = "Commodore Amiga";
		String valor = "899.90";
		String data = "04/08/2020";
		
		novoLeilaoPage.preencheForm(nome, valor, data);
		
		auctionPage.esperaCarregar();

		assertTrue(auctionPage.existe(nome, valor, data));
	}
	
	
	@Test
	public void deveEditarUmLeilao() {
		UpdateAuctionPage novoLeilaoPage = auctionPage.visitaPaginaParaAltearLeilao();
		String nome = "Commodore Amiga";
		String valor = "899.90";
		String data = "04/08/2020";
		
		novoLeilaoPage.preencheForm(nome, valor, data);
		
		auctionPage.esperaCarregar();

		assertTrue(auctionPage.existe(nome, valor, data));
	}
	
}
