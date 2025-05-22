package com.dentinhofelizapp.controller;

import com.dentinhofelizapp.model.Premiacao;
import com.dentinhofelizapp.service.PremiacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premiacoes")
public class PremiacaoController {

    @Autowired
    private PremiacaoService premiacaoService;

    @GetMapping
    public List<Premiacao> listarTodos() {
        return premiacaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Premiacao buscarPorId(@PathVariable String id) {
        return premiacaoService.buscarPorId(id);
    }

    @PostMapping
    public Premiacao salvar(@RequestBody Premiacao premiacao) {
        return premiacaoService.salvar(premiacao);
    }

    @PutMapping("/{id}")
    public Premiacao atualizar(@PathVariable String id, @RequestBody Premiacao premiacao) {
        premiacao.setId(id);
        return premiacaoService.salvar(premiacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        premiacaoService.deletar(id);
    }
}