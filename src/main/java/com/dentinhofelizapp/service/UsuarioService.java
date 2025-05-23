package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.repository.UsuarioRepository;
import com.dentinhofelizapp.security.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletar(String id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void adicionarPontuacao(String id, int pontos) {
        var usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setPontuacao(usuario.getPontuacao() + pontos);
            usuarioRepository.save(usuario);
        }
    }
}
