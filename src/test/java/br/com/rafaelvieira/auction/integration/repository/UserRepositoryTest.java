package br.com.rafaelvieira.auction.integration.repository;

import br.com.rafaelvieira.auction.integration.controller.TestBase;
import br.com.rafaelvieira.auction.model.User;
import br.com.rafaelvieira.auction.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test") 
public class UserRepositoryTest extends TestBase {

	@Autowired
	UsuarioRepository usuarios;
	
	@BeforeEach
	public void setup() {
		usuarios.saveAndFlush(this.getUsuarioFulano());
	}
	
	@Test
	public void deveCarregarUmUsuarioPeloNome() {
		User userCarregado = usuarios.getUserByUsername("Fulano");
		Assertions.assertEquals(this.getUsuarioFulano(), userCarregado);
	}
}
