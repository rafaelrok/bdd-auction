package br.com.rafaelvieira.auction.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class BidTest {

//    @Test(expected=IllegalArgumentException.class) //JUnit4
	@Test
	public void deveRecusarLancesComValorDeZero() {

		assertThrows(IllegalArgumentException.class, () -> new Bid(new User("John Doe"), BigDecimal.ZERO));
	}

	@Test
	public void deveRecusarLancesComValorNegativo() {

		assertThrows(IllegalArgumentException.class, () -> new Bid(new User("John Doe"), new BigDecimal("-10")));
	}
}
