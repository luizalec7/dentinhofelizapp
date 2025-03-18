package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Alarme;
import com.dentinhofelizapp.service.AlarmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AlarmeController {
    @Autowired
    private AlarmeService alarmeService;

    @GetMapping("/alarme")
    public String listarAlarmes(Model model) {
        List<Alarme> alarmes = alarmeService.listarAlarmes();
        model.addAttribute("alarmes", alarmes);
        return "alarme";
    }

    @PostMapping("/alarme")
    public String definirAlarme(@RequestParam String horario) {
        alarmeService.definirAlarme(horario);
        return "redirect:/alarme";
    }
}