package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Duvida;
import com.dentinhofelizapp.service.DuvidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DuvidaController {
    @Autowired
    private DuvidaService duvidaService;

    @GetMapping("/duvidas")
    public String listarDuvidas(Model model) {
        List<Duvida> duvidas = duvidaService.listarDuvidas();
        model.addAttribute("duvidas", duvidas);
        return "duvidas";
    }

    @PostMapping("/duvidas")
    public String adicionarDuvida(@RequestParam String pergunta, @RequestParam String resposta) {
        duvidaService.adicionarDuvida(pergunta, resposta);
        return "redirect:/duvidas";
    }
}