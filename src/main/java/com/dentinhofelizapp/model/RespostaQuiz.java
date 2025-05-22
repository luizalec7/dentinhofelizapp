package com.dentinhofelizapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "respostas_quiz")
public class RespostaQuiz {

    @Id
    private String id;

    @DBRef
    private Usuario usuario;

    private String quizId;
    private String respostaUsuario;
    private boolean correta;

    public RespostaQuiz() {}

    public RespostaQuiz(Usuario usuario, String quizId, String respostaUsuario, boolean correta) {
        this.usuario = usuario;
        this.quizId = quizId;
        this.respostaUsuario = respostaUsuario;
        this.correta = correta;
    }
}