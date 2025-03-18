package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Quiz;
import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.service.QuizService;
import com.dentinhofelizapp.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Inicia o quiz e armazena a lista de perguntas na sessão.
     */
    @GetMapping("/quizzes")
    public String iniciarQuiz(HttpSession session) {
        List<Quiz> quizzes = quizService.listarQuizzes();
        if (quizzes.isEmpty()) {
            return "redirect:/home"; // Caso não haja perguntas, redireciona para home
        }

        session.setAttribute("quizzes", quizzes);
        session.setAttribute("indicePergunta", 0);
        session.setAttribute("pontuacao", 0);

        return "redirect:/quiz/pergunta";
    }

    /**
     * Exibe a próxima pergunta do quiz.
     */
    @GetMapping("/quiz/pergunta")
    public String mostrarPergunta(HttpSession session, Model model) {
        List<Quiz> quizzes = (List<Quiz>) session.getAttribute("quizzes");
        Integer indicePergunta = (Integer) session.getAttribute("indicePergunta");

        if (quizzes == null || indicePergunta == null || indicePergunta >= quizzes.size()) {
            return "redirect:/quiz/resultado"; // Se todas as perguntas foram respondidas, exibe o resultado
        }

        model.addAttribute("quiz", quizzes.get(indicePergunta));
        return "quiz-pergunta"; // Certifique-se de que esse arquivo HTML existe na pasta templates/
    }

    /**
     * Processa a resposta do usuário e avança para a próxima pergunta.
     */
    @PostMapping("/quiz/responder")
    public String responderPergunta(@RequestParam Long idQuiz,
                                    @RequestParam String resposta,
                                    HttpSession session) {

        List<Quiz> quizzes = (List<Quiz>) session.getAttribute("quizzes");
        Integer indicePergunta = (Integer) session.getAttribute("indicePergunta");
        Integer pontuacao = (Integer) session.getAttribute("pontuacao");

        if (quizzes == null || indicePergunta == null || indicePergunta >= quizzes.size()) {
            return "redirect:/quiz/resultado"; // Se todas foram respondidas, vai para a pontuação final
        }

        boolean correto = quizService.verificarResposta(idQuiz, resposta);
        if (correto) {
            session.setAttribute("pontuacao", pontuacao + 10);
        }

        // Avança para a próxima pergunta
        session.setAttribute("indicePergunta", indicePergunta + 1);
        return "redirect:/quiz/pergunta";
    }

    /**
     * Exibe o resultado final do quiz com a pontuação acumulada.
     */
    @GetMapping("/quiz/resultado")
    public String mostrarResultado(HttpSession session, Model model) {
        Integer pontuacao = (Integer) session.getAttribute("pontuacao");

        model.addAttribute("pontuacao", pontuacao);
        return "quiz-resultado"; // Criar esse HTML para exibir a pontuação final
    }
}