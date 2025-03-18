package com.dentinhofelizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String pergunta;

    @ElementCollection(fetch = FetchType.EAGER)  // Força carregamento imediato
    @CollectionTable(name = "quiz_opcoes", joinColumns = @JoinColumn(name = "quiz_id"))
    private List<String> opcoes;

    @Column(nullable = false)
    private String respostaCorreta;

    // Construtor padrão
    public Quiz() {}

    // Construtor correto para o DatabaseSeeder
    public Quiz(String pergunta, List<String> opcoes, String respostaCorreta) {
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
}
