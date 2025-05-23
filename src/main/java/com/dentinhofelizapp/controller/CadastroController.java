package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/cadastro")
    public String mostrarCadastro() {
        return "cadastro";
    }

    @PostMapping("/salvarCadastro")
    public String salvarCadastro(@RequestParam String nome,
                                 @RequestParam String email,
                                 @RequestParam String senha,
                                 Model model) {
        String senhaCriptografada = passwordEncoder.encode(senha);
        Usuario novoUsuario = new Usuario(nome, email, senhaCriptografada);
        usuarioService.salvar(novoUsuario);
        return "redirect:/";
    }
}