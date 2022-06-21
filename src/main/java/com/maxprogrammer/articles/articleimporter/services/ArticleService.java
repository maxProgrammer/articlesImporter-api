package com.maxprogrammer.articles.articleimporter.services;

import com.maxprogrammer.articles.articleimporter.dtos.ArticleDetailDto;
import com.maxprogrammer.articles.articleimporter.dtos.ArticleDto;
import com.maxprogrammer.articles.articleimporter.models.ArticleModel;
import com.maxprogrammer.articles.articleimporter.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
            ArticleModel possibleArticleModelByStoryTitle = detalhe.newArticleModelByStoryTitle();

            ArticleModel possibleInDataBase = articleRepository.findArticleModelByTitle(possibleArticleModel.getTitle());
            ArticleModel possibleInDataBaseBYStoryTitle = articleRepository.findArticleModelByTitle(possibleArticleModelByStoryTitle.getTitle());

            if (possibleInDataBase == null && possibleInDataBaseBYStoryTitle == null) {
                save(detalhe);
            }
        }
    }

    public void save(ArticleDetailDto detalhe) {
        if (detalhe.getTitle() != null && detalhe.getTitle() != "") {
            ArticleModel novoArtigo = detalhe.newArticleModelByTitle();
            articleRepository.save(novoArtigo);
        } else if (detalhe.getStoryTitle() != null && detalhe.getStoryTitle() != "") {
            ArticleModel novoArtigo = detalhe.newArticleModelByStoryTitle();
            articleRepository.save(novoArtigo);
        }
    }

    public Page<ArticleModel> listAllArticlesOnDataBase(Pageable pageable){
        return articleRepository.findAll(pageable);
    }
}
