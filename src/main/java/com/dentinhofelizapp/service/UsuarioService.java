package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void adicionarPontuacao(String usuarioId, int pontos) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario != null) {
            int novaPontuacao = usuario.getPontuacao() + pontos;
            usuario.setPontuacao(novaPontuacao);
            usuarioRepository.save(usuario);
        }
    }

    public Optional<Usuario> buscarPorEmailESenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }


    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletar(String id) {
        usuarioRepository.deleteById(id);
    }
}