package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Usuario;
import com.dentinhofelizapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Exibe a página de login.
     */
    @GetMapping("/")
    public String mostrarLogin() {
        return "login"; // Certifique-se de que existe um `login.html` na pasta templates
    }

    /**
     * Exibe a página de login corretamente via GET.
     */
    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    /**
     * Processa a autenticação do usuário.
     */
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        Model model,
                        HttpSession session) {

        Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioService.login(email, senha));

        if (usuarioOptional.isEmpty()) {
            model.addAttribute("erro", "E-mail ou senha inválidos");
            return "login"; // Retorna à página de login com mensagem de erro
        }

        Usuario usuario = usuarioOptional.get();
        session.setAttribute("usuarioLogado", usuario); // Salva o usuário na sessão

        return "redirect:/home"; // Redireciona para a página principal
    }

    /**
     * Realiza o logout do usuário e encerra a sessão.
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida a sessão do usuário
        return "redirect:/login"; // Redireciona para a tela de login
    }
}