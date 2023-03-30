package br.com.rafaelvieira.auction.e2e.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.rafaelvieira.auction.e2e.pages.DetailsAuctionPage;
import br.com.rafaelvieira.auction.e2e.pages.AuctionPage;
import br.com.rafaelvieira.auction.e2e.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BidE2ETest extends E2ETestBase{
	
	private AuctionPage auctionPage;

	@BeforeEach
	void setup() {
		LoginPage loginPage = new LoginPage(getDriver());
		this.auctionPage = loginPage.realizaLoginComoFulano();
	}
	
    @Test
    public void deveAceitarUmLance() {
		LoginPage loginPage = new LoginPage(getDriver());
		this.auctionPage = loginPage.realizaLoginComoFulano();
		DetailsAuctionPage detalhesLeilaoPage = auctionPage.visitaLeilaoPaginaParaDarLance();
		
		detalhesLeilaoPage.darLance("150");
		
        assertTrue(detalhesLeilaoPage.existeLance("150"));
    }
    
    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		DetailsAuctionPage detalhesLeilaoPage = auctionPage.visitaLeilaoPaginaParaDarLance();
		detalhesLeilaoPage.darLance("150");
		detalhesLeilaoPage.darLance("160");

        assertTrue(detalhesLeilaoPage.temApenasUmLance());
    }
    
    @Test
    public void naoDeveAceitarDoisLancesComOMesmoValor() {
		DetailsAuctionPage detalhesLeilaoPage = auctionPage.visitaLeilaoPaginaParaDarLance();
		detalhesLeilaoPage.darLance("150");
		detalhesLeilaoPage.darLance("150");

        assertTrue(detalhesLeilaoPage.temApenasUmLance());
    }
}
