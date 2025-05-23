package com.dentinhofelizapp.service;

import org.springframework.stereotype.Service;

@Service
public class IAService {

    public String gerarExplicacao(String pergunta) {
        // Simula uma explicação "inteligente"
        return "Explicação automática da IA para: " + pergunta;
    }
}