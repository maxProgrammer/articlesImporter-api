package com.maxprogrammer.articles.articleimporter.controller;

import com.maxprogrammer.articles.articleimporter.models.ArticleModel;
import com.maxprogrammer.articles.articleimporter.services.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    ArticleService artigoService;

    @GetMapping(value = "api/articles/importer")
    @Operation(summary = "Import article from external API Service")
    public void importerArticles(int page) {

        artigoService.importerArticles(page);
    }

    @GetMapping(value="/api/articles")
    @Operation(summary = "List all articles on pageable mode")
    public Page<ArticleModel> listAllArticles(@PageableDefault(page = 0,size = 10, sort = "id",
    direction = Sort.Direction.ASC) Pageable pageable){
        return artigoService.listAllArticlesOnDataBase(pageable);
    }

}
