package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Quiz;
import com.dentinhofelizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz salvar(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz buscarPorId(String id) {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Quiz> listarTodos() {
        return quizRepository.findAll();
    }

    public void deletar(String id) {
        quizRepository.deleteById(id);
    }
}