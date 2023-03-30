package br.com.rafaelvieira.auction.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuctionTest {
	
	
	@DisplayName("um usuario pode dar lance em um auction de outro usuario")
	@Test
    public void deveReceberUmLance() {
        Auction auction = new Auction("Macbook Pro 15");
        assertEquals(0, auction.getLances().size());

        BigDecimal doisMil = new BigDecimal("2000.0");
		auction.propoe(new Bid(new User("Steve Jobs"), doisMil));

        assertEquals(1, auction.getLances().size());
        assertEquals(doisMil, auction.getLances().get(0).getValor());
    }
	
	
	@Test
    public void naoDeveAceitarUmLanceIgualAoAnterior() {
        Auction auction = new Auction("Macbook Pro 15");
        assertEquals(0, auction.getLances().size());

        BigDecimal doisMil = new BigDecimal("2000.0");
		auction.propoe(new Bid(new User("Steve Jobs"), doisMil));
		auction.propoe(new Bid(new User("Bill Gates"), doisMil));

        assertEquals(1, auction.getLances().size());
        assertEquals(doisMil, auction.getLances().get(0).getValor());
    }
	
	
	@Test
    public void naoDeveAceitarUmLanceMenorAoAnterior() {
        Auction auction = new Auction("Macbook Pro 15");
        assertEquals(0, auction.getLances().size());

        BigDecimal doisMil = new BigDecimal("2000.0");
        BigDecimal quaseDoisMil = new BigDecimal("1999.9");

		auction.propoe(new Bid(new User("Steve Jobs"), doisMil));
		auction.propoe(new Bid(new User("Bill Gates"), quaseDoisMil));

        assertEquals(1, auction.getLances().size());
        assertEquals(doisMil, auction.getLances().get(0).getValor());
    }
	

	@DisplayName("um auction pode receber lances de usuários diferentes")
    @Test
    public void deveReceberVariosLances() {
    	
    	BigDecimal doisMil = new BigDecimal("2000.0");
    	BigDecimal tresMil = new BigDecimal("3000.0");
    	
        Auction auction = new Auction("Macbook Pro 15");
        auction.propoe(new Bid(new User("Steve Jobs"), doisMil));
        auction.propoe(new Bid(new User("Steve Wozniak"), tresMil));

        assertEquals(2, auction.getLances().size());
        assertEquals(doisMil, auction.getLances().get(0).getValor());
        assertEquals(tresMil, auction.getLances().get(1).getValor());
    }
    
    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
    	BigDecimal doisMil = new BigDecimal("2000.0");
    	BigDecimal tresMil = new BigDecimal("3000.0");
    	
        Auction auction = new Auction("Macbook Pro 15");
        User steveJobs = new User("Steve Jobs");

        auction.propoe(new Bid(steveJobs, doisMil));
        auction.propoe(new Bid(steveJobs, tresMil));

        assertEquals(1, auction.getLances().size());
        assertEquals(doisMil, auction.getLances().get(0).getValor());
    }
    
    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Auction auction = new Auction("Macbook Pro 15");
        User steveJobs = new User("Steve Jobs");
        User billGates = new User("Bill Gates");

        auction.propoe(new Bid(steveJobs, new BigDecimal("2000.0")));
        auction.propoe(new Bid(billGates, new BigDecimal("3000.0")));
        auction.propoe(new Bid(steveJobs, new BigDecimal("4000.0")));
        auction.propoe(new Bid(billGates, new BigDecimal("5000.0")));
        auction.propoe(new Bid(steveJobs, new BigDecimal("6000.0")));
        auction.propoe(new Bid(billGates, new BigDecimal("7000.0")));
        auction.propoe(new Bid(steveJobs, new BigDecimal("8000.0")));
        auction.propoe(new Bid(billGates, new BigDecimal("9000.0")));
        auction.propoe(new Bid(steveJobs, new BigDecimal("10000.0")));
        auction.propoe(new Bid(billGates, new BigDecimal("11000.0")));

        // deve ser ignorado
        auction.propoe(new Bid(steveJobs, new BigDecimal("12000.0")));

        assertEquals(10, auction.getLances().size());
        assertEquals(new BigDecimal("11000.0"), auction.getLances().get(auction.getLances().size()-1).getValor());
    }

}
