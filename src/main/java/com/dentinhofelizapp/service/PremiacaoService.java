package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Premiacao;
import com.dentinhofelizapp.repository.PremiacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiacaoService {

    @Autowired
    private PremiacaoRepository premiacaoRepository;

    public Premiacao salvar(Premiacao premiacao) {
        return premiacaoRepository.save(premiacao);
    }

    public Premiacao buscarPorId(String id) {
        return premiacaoRepository.findById(id).orElse(null);
    }

    public List<Premiacao> listarTodos() {
        return premiacaoRepository.findAll();
    }

    public void deletar(String id) {
        premiacaoRepository.deleteById(id);
    }
}