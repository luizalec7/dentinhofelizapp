package com.dentinhofelizapp.service;

import com.dentinhofelizapp.model.RespostaQuiz;
import com.dentinhofelizapp.repository.RespostaQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RespostaQuizService {

    @Autowired
    private RespostaQuizRepository respostaQuizRepository;

    public RespostaQuiz salvar(RespostaQuiz resposta) {
        return respostaQuizRepository.save(resposta);
    }

    public RespostaQuiz buscarPorId(String id) {
        return respostaQuizRepository.findById(id).orElse(null);
    }

    public List<RespostaQuiz> listarTodos() {
        return respostaQuizRepository.findAll();  // já retorna List<RespostaQuiz>
    }

    public void deletar(String id) {
        respostaQuizRepository.deleteById(id);
    }
}