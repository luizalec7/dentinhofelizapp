package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Pontuacao;
import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.repository.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontuacaoService {
    @Autowired
    private PontuacaoRepository pontuacaoRepository;

    public List<Pontuacao> listarPontuacoes() {
        return pontuacaoRepository.findAll();
    }

    public List<Pontuacao> listarPontuacoesPorUsuario(Usuario usuario) {
        return pontuacaoRepository.findByUsuario(usuario);
    }

    public Pontuacao adicionarPontuacao(Usuario usuario, int pontos) {
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setUsuario(usuario);
        pontuacao.setPontos(pontos);
        return pontuacaoRepository.save(pontuacao);
    }
}

