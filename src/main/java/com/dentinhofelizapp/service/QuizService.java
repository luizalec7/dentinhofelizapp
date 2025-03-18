package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.Quiz;
import com.dentinhofelizapp.model.RespostaQuiz;
import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.repository.QuizRepository;
import com.dentinhofelizapp.repository.RespostaQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private RespostaQuizRepository respostaQuizRepository;

    public List<Quiz> listarQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        quizzes.forEach(quiz -> quiz.getOpcoes().size()); // Força inicialização
        return quizzes;
    }

    public Quiz buscarPorId(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz salvarQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public boolean verificarResposta(Long idQuiz, String resposta) {
        Quiz quiz = buscarPorId(idQuiz);
        return quiz != null && quiz.getRespostaCorreta().equalsIgnoreCase(resposta);
    }

    public void deletarQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public RespostaQuiz salvarResposta(Usuario usuario, Quiz quiz, String resposta) {
        boolean correto = verificarResposta(quiz.getId(), resposta);
        int pontuacao = correto ? 10 : 0;

        RespostaQuiz respostaQuiz = new RespostaQuiz(usuario, quiz, resposta, pontuacao);
        return respostaQuizRepository.save(respostaQuiz);
    }

    public List<RespostaQuiz> listarRespostasDoUsuario(Usuario usuario) {
        return respostaQuizRepository.findByUsuario(usuario);
    }

    public Quiz buscarProximaPergunta(Long idQuizAtual) {
        List<Quiz> quizzes = listarQuizzes();
        for (int i = 0; i < quizzes.size(); i++) {
            if (quizzes.get(i).getId().equals(idQuizAtual) && i + 1 < quizzes.size()) {
                return quizzes.get(i + 1);
            }
        }
        return null; // Retorna null quando não há mais perguntas
    }

}