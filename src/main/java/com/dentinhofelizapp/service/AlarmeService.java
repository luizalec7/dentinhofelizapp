package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Alarme;
import com.dentinhofelizapp.repository.AlarmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmeService {

    @Autowired
    private AlarmeRepository alarmeRepository;

    public Alarme salvar(Alarme alarme) {
        return alarmeRepository.save(alarme);
    }

    public Alarme buscarPorId(String id) {
        return alarmeRepository.findById(id).orElse(null);
    }

    public List<Alarme> listarTodos() {
        return alarmeRepository.findAll();
    }

    public void deletar(String id) {
        alarmeRepository.deleteById(id);
    }
}