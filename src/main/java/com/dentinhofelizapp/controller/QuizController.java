package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Quiz;
import com.dentinhofelizapp.model.RespostaQuiz;
import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.service.QuizService;
import com.dentinhofelizapp.service.RespostaQuizService;
import com.dentinhofelizapp.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RespostaQuizService respostaQuizService;

    @GetMapping("/quizzes")
    public String iniciarQuiz(HttpSession session, Model model) {
        List<Quiz> quizzes = quizService.listarTodos();
        if (quizzes.isEmpty()) {
            model.addAttribute("erro", "Nenhum quiz disponível.");
            return "quiz-pergunta";
        }

        session.setAttribute("quizzes", quizzes);
        session.setAttribute("indexAtual", 0);
        session.setAttribute("pontuacao", 0);

        Quiz primeiraPergunta = quizzes.get(0);
        model.addAttribute("quiz", primeiraPergunta);
        return "quiz-pergunta";
    }

    @PostMapping("/quiz/responder")
    public String responder(@RequestParam String resposta, HttpSession session, Model model) {
        List<Quiz> quizzes = (List<Quiz>) session.getAttribute("quizzes");
        Integer indexAtual = (Integer) session.getAttribute("indexAtual");
        Integer pontuacao = (Integer) session.getAttribute("pontuacao");
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (indexAtual == null || quizzes == null || indexAtual >= quizzes.size()) {
            return "redirect:/quizzes"; // reinicia caso erro
        }

        Quiz quizAtual = quizzes.get(indexAtual);
        boolean correta = quizAtual.getRespostaCorreta().equalsIgnoreCase(resposta);
        if (correta) {
            pontuacao += 10;
            session.setAttribute("pontuacao", pontuacao);
        }

        // Salva a resposta
        if (usuario != null) {
            usuarioService.adicionarPontuacao(usuario.getId(), correta ? 10 : 0);
            RespostaQuiz respostaQuiz = new RespostaQuiz();
            respostaQuiz.setUsuario(usuario);
            respostaQuiz.setQuizId(quizAtual.getId());
            respostaQuiz.setRespostaUsuario(resposta);
            respostaQuiz.setCorreta(correta);
            respostaQuizService.salvar(respostaQuiz);
        }

        // Avança para próxima pergunta
        indexAtual++;
        session.setAttribute("indexAtual", indexAtual);

        if (indexAtual >= quizzes.size()) {
            model.addAttribute("pontuacao", pontuacao);
            return "quiz-resultado";
        } else {
            model.addAttribute("quiz", quizzes.get(indexAtual));
            return "quiz-pergunta";
        }
    }
}