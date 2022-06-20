package com.maxprogrammer.articles.articleimporter.services;

import com.maxprogrammer.articles.articleimporter.dtos.ArticleDetailDto;
import com.maxprogrammer.articles.articleimporter.dtos.ArticleDto;
import com.maxprogrammer.articles.articleimporter.models.ArticleModel;
import com.maxprogrammer.articles.articleimporter.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public void importerArticles(int page) {
        RestTemplate restTemplate = new RestTemplate();

        String urlResource = "https://jsonmock.hackerrank.com/api/articles/?page=" + page;

        ArticleDto allArticles = restTemplate.getForObject(urlResource, ArticleDto.class);

        for (ArticleDetailDto detalhe : allArticles.data) {
            ArticleModel possibleArticleModel = detalhe.newArticleModelByTitle();
            ArticleModel possibleInDataBase = articleRepository.findArticleModelByTitle(possibleArticleModel.getTitle());
            if (possibleInDataBase == null) {
                controlStatementFlowToAddArticleModel(detalhe);
            }
        }
    }

    public void salveArticlesByTitle(ArticleDetailDto articleDetailDto) {
        ArticleModel novoArtigo = articleDetailDto.newArticleModelByTitle();

        articleRepository.save(novoArtigo);    }

    public void salveArticlesByStoryTitle(ArticleDetailDto articleDetailDto) {
        ArticleModel novoArtigo = articleDetailDto.newArticleModelByStoryTitle();
        articleRepository.save(novoArtigo);
    }

    public void controlStatementFlowToAddArticleModel(ArticleDetailDto detalhe) {
        if (detalhe.getTitle() != null && detalhe.getTitle() != "") {
            salveArticlesByTitle(detalhe);
        } else if (detalhe.getStoryTitle() != null && detalhe.getStoryTitle() != "") {
            salveArticlesByStoryTitle(detalhe);
        }
    }
}
