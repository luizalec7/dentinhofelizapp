package com.dentinhofelizapp.security;

import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.orElseThrow(() ->
                new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));
    }
}