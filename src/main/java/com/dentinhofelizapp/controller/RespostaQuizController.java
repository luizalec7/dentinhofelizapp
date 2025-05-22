package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.RespostaQuiz;
import com.dentinhofelizapp.service.RespostaQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respostas")
public class RespostaQuizController {

    @Autowired
    private RespostaQuizService respostaQuizService;

    @GetMapping
    public List<RespostaQuiz> listarTodos() {
        return respostaQuizService.listarTodos();
    }

    @GetMapping("/{id}")
    public RespostaQuiz buscarPorId(@PathVariable String id) {
        return respostaQuizService.buscarPorId(id);
    }

    @PostMapping
    public RespostaQuiz salvar(@RequestBody RespostaQuiz resposta) {
        return respostaQuizService.salvar(resposta);
    }

    @PutMapping("/{id}")
    public RespostaQuiz atualizar(@PathVariable String id, @RequestBody RespostaQuiz resposta) {
        resposta.setId(id);
        return respostaQuizService.salvar(resposta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        respostaQuizService.deletar(id);
    }
}