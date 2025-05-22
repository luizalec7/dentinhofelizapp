package com.dentinhofelizapp.config;

import com.dentinhofelizapp.model.Quiz;
import com.dentinhofelizapp.repository.QuizRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    private QuizRepository quizRepository;

    @PostConstruct
    public void inserirPerguntas() {
        if (quizRepository.count() == 0) {
            List<Quiz> quizzes = Arrays.asList(
                    new Quiz("Qual o tempo mínimo recomendado para escovar os dentes?",
                            Arrays.asList("10 segundos", "30 segundos", "2 minutos", "5 minutos"),
                            "2 minutos"),
                    new Quiz("Com que frequência devemos trocar a escova de dentes?",
                            Arrays.asList("A cada 6 meses", "A cada 3 meses", "Somente quando as cerdas estiverem desgastadas", "Nunca"),
                            "A cada 3 meses"),
                    new Quiz("Qual dessas opções é um benefício do uso do fio dental?",
                            Arrays.asList("Deixa os dentes mais brancos", "Elimina bactérias entre os dentes", "Evita mau hálito instantaneamente", "Funciona melhor que a escova de dentes"),
                            "Elimina bactérias entre os dentes"),
                    new Quiz("O que acontece se você não escovar a língua?",
                            Arrays.asList("Nada, só os dentes precisam de limpeza", "Pode causar mau hálito", "A língua não acumula bactérias", "A saliva limpa a língua naturalmente"),
                            "Pode causar mau hálito")
            );

            quizRepository.saveAll(quizzes);
            System.out.println("Perguntas do quiz inseridas no banco de dados.");
        }
    }
}