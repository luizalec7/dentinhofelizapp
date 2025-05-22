package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Duvida;
import com.dentinhofelizapp.repository.DuvidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuvidaService {

    @Autowired
    private DuvidaRepository duvidaRepository;

    public Duvida salvar(Duvida duvida) {
        return duvidaRepository.save(duvida);
    }

    public Duvida buscarPorId(String id) {
        return duvidaRepository.findById(id).orElse(null);
    }

    public List<Duvida> listarTodos() {
        return duvidaRepository.findAll();
    }

    public void deletar(String id) {
        duvidaRepository.deleteById(id);
    }
}