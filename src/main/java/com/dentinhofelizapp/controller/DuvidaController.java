package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Duvida;
import com.dentinhofelizapp.service.DuvidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DuvidaController {

    @Autowired
    private DuvidaService duvidaService;

    // Exibe a página de dúvidas com a lista carregada
    @GetMapping("/duvidas")
    public String listarDuvidas(Model model) {
        List<Duvida> duvidas = duvidaService.listarTodos();
        model.addAttribute("duvidas", duvidas);
        return "duvidas"; // resources/templates/duvidas.html
    }

    // Processa o formulário para adicionar nova dúvida
    @PostMapping("/duvidas")
    public String adicionarDuvida(@RequestParam String pergunta,
                                  @RequestParam String resposta) {
        Duvida novaDuvida = new Duvida();
        novaDuvida.setPergunta(pergunta);
        novaDuvida.setResposta(resposta);
        novaDuvida.setAtiva(true);
        duvidaService.salvar(novaDuvida);
        return "redirect:/duvidas";
    }
}