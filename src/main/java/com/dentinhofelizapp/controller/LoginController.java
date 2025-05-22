package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        Model model,
                        HttpSession session) {

        Optional<Usuario> usuarioOptional = usuarioService.buscarPorEmailESenha(email, senha);

        if (usuarioOptional.isEmpty()) {
            model.addAttribute("erro", "E-mail ou senha inválidos");
            return "login";
        }

        session.setAttribute("usuarioLogado", usuarioOptional.get());
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
