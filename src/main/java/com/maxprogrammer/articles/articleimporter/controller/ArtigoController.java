package com.maxprogrammer.articles.articleimporter.controller;

import com.maxprogrammer.articles.articleimporter.dtos.ArtigosDto;
import com.maxprogrammer.articles.articleimporter.services.ArtigoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtigoController {

    @Autowired
    ArtigoService artigoService;

    @GetMapping(value = "/")
    @Operation(summary = "Return all articles")
    public ArtigosDto retornaTodosArtigos() {

        return artigoService.listallArticles();
    }

}
