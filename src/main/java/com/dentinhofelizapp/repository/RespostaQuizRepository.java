package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.RespostaQuiz;
import com.dentinhofelizapp.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RespostaQuizRepository extends MongoRepository<RespostaQuiz, String> {
    List<RespostaQuiz> findByUsuario(Usuario usuario);
}