package br.com.rafaelvieira.auction.service;

import br.com.rafaelvieira.auction.model.Lance;
import br.com.rafaelvieira.auction.model.Leilao;
import br.com.rafaelvieira.auction.model.Usuario;
import br.com.rafaelvieira.auction.mudi.dto.NovoLanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelvieira.auction.repositories.LanceRepository;
import br.com.rafaelvieira.auction.repositories.LeilaoRepository;
import br.com.rafaelvieira.auction.repositories.UsuarioRepository;

@Service
public class LanceService {

	@Autowired
	public LanceRepository lancesRepo;
	
	@Autowired
	public UsuarioRepository usuariosRepo;
	
	@Autowired
	public LeilaoRepository leiloesRepo;

	public boolean propoeLance(NovoLanceDto lanceDto, String nomeUsuario) {

		Usuario usuario = usuariosRepo.getUserByUsername(nomeUsuario);
		Lance lance = lanceDto.toLance(usuario);

		Leilao leilao =  this.getLeilao(lanceDto.getLeilaoId());

		if (leilao.propoe(lance)) {
			lancesRepo.save(lance);
			return true;
		}
		
		return false;
	}

	public Leilao getLeilao(Long leilaoId) {
		return leiloesRepo.getOne(leilaoId);
	}
}