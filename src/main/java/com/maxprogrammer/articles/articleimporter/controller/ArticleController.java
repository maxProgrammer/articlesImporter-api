package com.maxprogrammer.articles.articleimporter.controller;

import com.maxprogrammer.articles.articleimporter.services.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    ArticleService artigoService;

    @GetMapping(value = "/")
    @Operation(summary = "Add articles by page accessed")
    public void importerArticles(int page) {

        artigoService.importerArticles(page);
    }

}
