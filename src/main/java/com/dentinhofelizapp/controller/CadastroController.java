package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String mostrarCadastro() {
        return "cadastro"; // Retorna a página de cadastro (cadastro.html)
    }

    @PostMapping("/salvarCadastro")
    public String salvarCadastro(@RequestParam String nome,
                                 @RequestParam String email,
                                 @RequestParam String senha,
                                 Model model) {
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarioService.salvarUsuario(novoUsuario);
        return "redirect:/"; // Redireciona para a página de login após o cadastro
    }
}

