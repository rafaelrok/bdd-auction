package br.com.rafaelvieira.auction.service;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.Bid;
import br.com.rafaelvieira.auction.model.User;
import br.com.rafaelvieira.auction.mudi.dto.NewBidDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelvieira.auction.repositories.LanceRepository;
import br.com.rafaelvieira.auction.repositories.LeilaoRepository;
import br.com.rafaelvieira.auction.repositories.UsuarioRepository;

@Service
public class BidService {

	@Autowired
	public LanceRepository lancesRepo;
	
	@Autowired
	public UsuarioRepository usuariosRepo;
	
	@Autowired
	public LeilaoRepository leiloesRepo;

	public boolean propoeLance(NewBidDto lanceDto, String nomeUsuario) {

		User user = usuariosRepo.getUserByUsername(nomeUsuario);
		Bid lance = lanceDto.toLance(user);

		Auction auction =  this.getLeilao(lanceDto.getLeilaoId());

		if (auction.propoe(lance)) {
			lancesRepo.save(lance);
			return true;
		}
		
		return false;
	}

	public Auction getLeilao(Long leilaoId) {
		return leiloesRepo.getOne(leilaoId);
	}
}