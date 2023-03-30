package br.com.rafaelvieira.auction.repositories;

import br.com.rafaelvieira.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends JpaRepository<Auction, Long>  {


}
