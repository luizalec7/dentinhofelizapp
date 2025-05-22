package com.dentinhofelizapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "quizzes")
public class Quiz {
    @Id
    private String id;

    private String pergunta;
    private String respostaCorreta;
    private List<String> opcoes;
    private String dificuldade;
    private String categoria;
    private String explicacao;
    private int tempoResposta;
    private int pontos;
    private List<String> tags;
    private boolean ativo;

    public Quiz() {}

    public Quiz(String pergunta, List<String> opcoes, String respostaCorreta) {
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

}