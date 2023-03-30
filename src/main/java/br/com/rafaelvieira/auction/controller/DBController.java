package br.com.rafaelvieira.auction.controller;

import java.math.BigDecimal;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.Bid;
import br.com.rafaelvieira.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelvieira.auction.repositories.LanceRepository;
import br.com.rafaelvieira.auction.repositories.LeilaoRepository;
import br.com.rafaelvieira.auction.repositories.UsuarioRepository;

@RestController
@RequestMapping("/db")
@Profile("test")
public class DBController {
	
	@Autowired
	private LanceRepository lances;

	@Autowired
	private UsuarioRepository usuarios;
	
	@Autowired
	private LeilaoRepository leiloes;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/db")
	public ResponseEntity<String> deleta() {
		lances.deleteAll();
		leiloes.deleteAll();
		usuarios.deleteAll();
		return ResponseEntity.ok("{'message':'dados removidos'}");
	}
	
	@GetMapping("/seed")
	public ResponseEntity<String> popula() {
		
		lances.deleteAll();
		leiloes.deleteAll();
		usuarios.deleteAll();
		
		User fulano = new User("fulano", "fulano@gmail.com", encoder.encode("pass"));
		fulano.setRole("ROLE_USER");
		fulano.activa();
		
		User beltrano = new User("beltrano", "beltrano@gmail.com", encoder.encode("pass"));
		beltrano.setRole("ROLE_USER");
		beltrano.activa();
		
		User cigano = new User("cigano", "cigano@gmail.com", encoder.encode("pass"));
		cigano.setRole("ROLE_ADMIN");
		cigano.activa();
		
		Auction auctionTablet = new Auction("Tablet Xpto 3",new BigDecimal("5.0"), fulano);
		
		Bid lance10 = new Bid(beltrano, BigDecimal.TEN);
		Bid lance15 = new Bid(cigano, new BigDecimal("15.0"));
		
		auctionTablet.propoe(lance10);
		auctionTablet.propoe(lance15);
		
		usuarios.save(fulano);
		usuarios.save(beltrano);
		usuarios.save(cigano);

		leiloes.save(auctionTablet);

		lances.save(lance10);
		lances.save(lance15);
		
		Auction auctionSemLance = new Auction("Computador Z3", new BigDecimal("500.0"), beltrano);
		leiloes.save(auctionSemLance);


		return ResponseEntity.ok("{'message':'dados populadas'}");
	}
	
	
}






