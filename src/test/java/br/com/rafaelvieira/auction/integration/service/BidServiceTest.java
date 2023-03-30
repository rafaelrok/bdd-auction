package br.com.rafaelvieira.auction.integration.service;

import java.math.BigDecimal;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.Bid;
import br.com.rafaelvieira.auction.model.User;
import br.com.rafaelvieira.auction.mudi.dto.NewBidDto;
import br.com.rafaelvieira.auction.repositories.LanceRepository;
import br.com.rafaelvieira.auction.repositories.LeilaoRepository;
import br.com.rafaelvieira.auction.repositories.UsuarioRepository;
import br.com.rafaelvieira.auction.service.BidService;
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
public class BidServiceTest {

	@Autowired
	private BidService service;
	
	
	@MockBean
	public LanceRepository lancesRepo;
	
	@MockBean
	public UsuarioRepository usuariosRepo;
	
	@MockBean
	public LeilaoRepository leiloesRepo;


	private NewBidDto lanceDto;
	private Auction auction;
	private User user;
	private Bid lance;
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public BidService employeeService() {
            return new BidService();
        }
    }

	@BeforeEach
	public void setUp() {
		long leilaoId = 1l;
		lanceDto = new NewBidDto();
		lanceDto.setLeilaoId(leilaoId);
		lanceDto.setValor(BigDecimal.TEN);
		
		auction = new Auction("tablet");
		auction.setId(leilaoId);
		
		user = new User("fulano");
		lance = lanceDto.toLance(user);
	}

	@Test
	public void deveAceitarUmLance() {
		Mockito.when(leiloesRepo.getOne(auction.getId())).thenReturn(auction);
		Mockito.when(lancesRepo.save(lance)).thenReturn(lance);
		Mockito.when(usuariosRepo.getUserByUsername("fulano")).thenReturn(user);
		
		boolean propus = service.propoeLance(lanceDto, "fulano");
		
		Assertions.assertTrue(propus);
	}
	
	@Test
	public void naoDeveAceitarUmLanceDuplicado() {
		Mockito.when(leiloesRepo.getOne(auction.getId())).thenReturn(auction);
		Mockito.when(lancesRepo.save(lance)).thenReturn(lance);
		Mockito.when(usuariosRepo.getUserByUsername("fulano")).thenReturn(user);
		
		service.propoeLance(lanceDto, "fulano");
		
		NewBidDto outroLance = new NewBidDto();
		outroLance.setLeilaoId(1l);
		outroLance.setValor(BigDecimal.TEN);
		
		boolean propus = service.propoeLance(outroLance, "fulano");

		Assertions.assertFalse(propus);
	}
}
