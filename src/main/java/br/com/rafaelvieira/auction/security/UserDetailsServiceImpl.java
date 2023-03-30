package br.com.rafaelvieira.auction.security;

import br.com.rafaelvieira.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.rafaelvieira.auction.repositories.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	 
    @Autowired
    private UsuarioRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("User nao encontrado");
        }
         
        return new AuctionUserDetails(user);
    }
 
}
