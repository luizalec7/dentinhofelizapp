package com.dentinhofelizapp.repository;

import com.dentinhofelizapp.model.RespostaQuiz;
import com.dentinhofelizapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaQuizRepository extends JpaRepository<RespostaQuiz, Long> {
    List<RespostaQuiz> findByUsuario(Usuario usuario);
}