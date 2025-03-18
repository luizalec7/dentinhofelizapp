package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Duvida;
import com.dentinhofelizapp.repository.DuvidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuvidaService {
    @Autowired
    private DuvidaRepository duvidaRepository;

    public List<Duvida> listarDuvidas() {
        return duvidaRepository.findAll();
    }

    public Optional<Duvida> buscarPorId(Long id) {
        return duvidaRepository.findById(id);
    }

    public Duvida adicionarDuvida(String pergunta, String resposta) {
        Duvida duvida = new Duvida();
        duvida.setPergunta(pergunta);
        duvida.setResposta(resposta);
        return duvidaRepository.save(duvida);
    }

    public void deletarDuvida(Long id) {
        duvidaRepository.deleteById(id);
    }
}