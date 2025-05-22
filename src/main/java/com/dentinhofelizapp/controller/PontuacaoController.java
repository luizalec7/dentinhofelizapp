package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Pontuacao;
import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.service.PontuacaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pontuacoes")
public class PontuacaoController {

    @Autowired
    private PontuacaoService pontuacaoService;

    /**
     * Exibe todas as pontuações cadastradas.
     */
    @GetMapping
    public String listarTodas(Model model) {
        List<Pontuacao> pontuacoes = pontuacaoService.listarTodas();
        model.addAttribute("pontuacoes", pontuacoes);
        return "pontuacoes"; // View em /templates/pontuacoes.html
    }

    /**
     * Exibe as pontuações do usuário logado (sessão).
     */
    @GetMapping("/minhas")
    public String listarMinhasPontuacoes(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario == null) {
            return "redirect:/login";
        }

        List<Pontuacao> pontuacoes = pontuacaoService.listarPorUsuario(usuario);
        model.addAttribute("pontuacoes", pontuacoes);
        return "minhas-pontuacoes"; // View em /templates/minhas-pontuacoes.html
    }

    /**
     * Salva uma nova pontuação para o usuário logado.
     */
    @PostMapping("/registrar")
    public String registrarPontuacao(@RequestParam int pontos, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario != null) {
            Pontuacao novaPontuacao = new Pontuacao(usuario, pontos);
            pontuacaoService.salvar(novaPontuacao);
        }

        return "redirect:/pontuacoes/minhas";
    }

    /**
     * Remove uma pontuação por ID.
     */
    @PostMapping("/remover/{id}")
    public String remover(@PathVariable String id) {
        pontuacaoService.deletarPorId(id);
        return "redirect:/pontuacoes";
    }
}