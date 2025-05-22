package com.dentinhofelizapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pontuacoes")
public class Pontuacao {

    @Id
    private String id;

    @DBRef
    private Usuario usuario;

    private int pontos;

    public Pontuacao() {}

    public Pontuacao(Usuario usuario, int pontos) {
        this.usuario = usuario;
        this.pontos = pontos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}