package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Alarme;
import com.dentinhofelizapp.service.AlarmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlarmeController {

    @Autowired
    private AlarmeService alarmeService;

    @GetMapping("/alarme")
    public String mostrarAlarme(Model model) {
        List<Alarme> alarmes = alarmeService.listarTodos();
        model.addAttribute("alarmes", alarmes);
        return "alarme"; // templates/alarme.html
    }

    @PostMapping("/alarme")
    public String salvarAlarme(@RequestParam String horario) {
        Alarme novoAlarme = new Alarme();
        novoAlarme.setHorario(horario);
        novoAlarme.setAtivo(true);
        alarmeService.salvar(novoAlarme);
        return "redirect:/alarme";
    }
}