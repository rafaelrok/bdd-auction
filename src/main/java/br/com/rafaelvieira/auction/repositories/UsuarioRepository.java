package br.com.rafaelvieira.auction.repositories;

import br.com.rafaelvieira.auction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository   extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.nome = :username")
    public User getUserByUsername(@Param("username") String username);
}
