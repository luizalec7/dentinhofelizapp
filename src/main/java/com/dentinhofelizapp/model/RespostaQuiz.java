package com.dentinhofelizapp.model;

import jakarta.persistence.*;

@Entity
public class RespostaQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Quiz quiz;

    private String respostaDada;
    private int pontuacao;

    public RespostaQuiz() {}

    public RespostaQuiz(Usuario usuario, Quiz quiz, String respostaDada, int pontuacao) {
        this.usuario = usuario;
        this.quiz = quiz;
        this.respostaDada = respostaDada;
        this.pontuacao = pontuacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getRespostaDada() {
        return respostaDada;
    }

    public void setRespostaDada(String respostaDada) {
        this.respostaDada = respostaDada;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
