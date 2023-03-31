package com.example.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;


    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagems() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem langSalva = repositorio.save(linguagem);
        return langSalva;
    }
}
