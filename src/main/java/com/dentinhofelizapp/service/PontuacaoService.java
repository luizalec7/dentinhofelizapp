package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Pontuacao;
import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.repository.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontuacaoService {

    @Autowired
    private PontuacaoRepository pontuacaoRepository;

    public List<Pontuacao> listarTodas() {
        return pontuacaoRepository.findAll();
    }

    public List<Pontuacao> listarPorUsuario(Usuario usuario) {
        return pontuacaoRepository.findByUsuario(usuario);
    }

    public Pontuacao salvar(Pontuacao pontuacao) {
        return pontuacaoRepository.save(pontuacao);
    }

    public void deletarPorId(String id) {
        pontuacaoRepository.deleteById(id);
    }

    public Optional<Pontuacao> buscarPorId(String id) {
        return pontuacaoRepository.findById(id);
    }
}