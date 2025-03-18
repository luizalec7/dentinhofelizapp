package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Alarme;
import com.dentinhofelizapp.repository.AlarmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlarmeService {
    @Autowired
    private AlarmeRepository alarmeRepository;

    public List<Alarme> listarAlarmes() {
        return alarmeRepository.findAll();
    }

    public Optional<Alarme> buscarPorId(Long id) {
        return alarmeRepository.findById(id);
    }

    public Alarme definirAlarme(String horario) {
        Alarme alarme = new Alarme();
        alarme.setHorario(horario);
        return alarmeRepository.save(alarme);
    }

    public void deletarAlarme(Long id) {
        alarmeRepository.deleteById(id);
    }
}
