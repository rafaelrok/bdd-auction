package br.com.rafaelvieira.auction.repositories;

import br.com.rafaelvieira.auction.model.Lance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {

}
