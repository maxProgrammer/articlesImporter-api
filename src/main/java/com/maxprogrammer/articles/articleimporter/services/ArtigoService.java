package com.maxprogrammer.articles.articleimporter.services;

import com.maxprogrammer.articles.articleimporter.dtos.ArtigosDto;
import com.maxprogrammer.articles.articleimporter.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtigoService {

    @Autowired
    ArtigoRepository artigoRepository;

    public ArtigosDto listallArticles() {
        RestTemplate restTemplate = new RestTemplate();

        String urlResource = "https://jsonmock.hackerrank.com/api/articles";

        ArtigosDto allArticles = restTemplate.getForObject(urlResource, ArtigosDto.class);

        return allArticles;
    }
}
