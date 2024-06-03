package com.example.api_livre.controller;

import com.example.api_livre.dao.LivreRepository;
import com.example.api_livre.entity.Livre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class LivreController {
    private final LivreRepository repo;
    public LivreController(LivreRepository rp){
        repo = rp;
    }
    @GetMapping("/emapi/livre")
    public List<Livre> getLivrees(){
        return repo.findAll();
    }
}
