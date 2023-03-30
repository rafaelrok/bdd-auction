package br.com.rafaelvieira.auction.integration.service;

import java.math.BigDecimal;

import br.com.rafaelvieira.auction.model.Lance;
import br.com.rafaelvieira.auction.model.Leilao;
import br.com.rafaelvieira.auction.model.Usuario;
import br.com.rafaelvieira.auction.mudi.dto.NovoLanceDto;
import br.com.rafaelvieira.auction.repositories.LanceRepository;
import br.com.rafaelvieira.auction.repositories.LeilaoRepository;
import br.com.rafaelvieira.auction.repositories.UsuarioRepository;
import br.com.rafaelvieira.auction.service.LanceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class LanceServiceTest {

	@Autowired
	private LanceService service;
	
	
	@MockBean
	public LanceRepository lancesRepo;
	
	@MockBean
	public UsuarioRepository usuariosRepo;
	
	@MockBean
	public LeilaoRepository leiloesRepo;


	private NovoLanceDto lanceDto;
	private Leilao leilao;
	private Usuario usuario;
	private Lance lance;
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public LanceService employeeService() {
            return new LanceService();
        }
    }

	@BeforeEach
	public void setUp() {
		long leilaoId = 1l;
		lanceDto = new NovoLanceDto();
		lanceDto.setLeilaoId(leilaoId);
		lanceDto.setValor(BigDecimal.TEN);
		
		leilao = new Leilao("tablet");
		leilao.setId(leilaoId);
		
		usuario = new Usuario("fulano");
		lance = lanceDto.toLance(usuario);
	}

	@Test
	public void deveAceitarUmLance() {
		Mockito.when(leiloesRepo.getOne(leilao.getId())).thenReturn(leilao);
		Mockito.when(lancesRepo.save(lance)).thenReturn(lance);
		Mockito.when(usuariosRepo.getUserByUsername("fulano")).thenReturn(usuario);
		
		boolean propus = service.propoeLance(lanceDto, "fulano");
		
		Assertions.assertTrue(propus);
	}
	
	@Test
	public void naoDeveAceitarUmLanceDuplicado() {
		Mockito.when(leiloesRepo.getOne(leilao.getId())).thenReturn(leilao);
		Mockito.when(lancesRepo.save(lance)).thenReturn(lance);
		Mockito.when(usuariosRepo.getUserByUsername("fulano")).thenReturn(usuario);
		
		service.propoeLance(lanceDto, "fulano");
		
		NovoLanceDto outroLance = new NovoLanceDto();
		outroLance.setLeilaoId(1l);
		outroLance.setValor(BigDecimal.TEN);
		
		boolean propus = service.propoeLance(outroLance, "fulano");

		Assertions.assertFalse(propus);
	}
}
