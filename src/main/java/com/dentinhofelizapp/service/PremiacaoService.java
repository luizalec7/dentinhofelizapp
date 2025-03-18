package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Premiacao;
import com.dentinhofelizapp.repository.PremiacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PremiacaoService {
    @Autowired
    private PremiacaoRepository premiacaoRepository;

    public List<Premiacao> listarPremiacoes() {
        return premiacaoRepository.findAll();
    }

    public Optional<Premiacao> buscarPorId(Long id) {
        return premiacaoRepository.findById(id);
    }

    public Premiacao salvarPremiacao(Premiacao premiacao) {
        return premiacaoRepository.save(premiacao);
    }

    public void deletarPremiacao(Long id) {
        premiacaoRepository.deleteById(id);
    }
}

