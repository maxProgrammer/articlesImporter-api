package com.maxprogrammer.articles.articleimporter.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxprogrammer.articles.articleimporter.dtos.ArtigoDto;
import com.maxprogrammer.articles.articleimporter.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ArtigoService {

    @Autowired
    ArtigoRepository artigoRepository;

    public List<ArtigoDto> listallArticles() {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        String urlResource = "https://jsonmock.hackerrank.com/api/articles";

        List<ArtigoDto> allArticles= restTemplate.getForObject(urlResource, List.class);
        return  allArticles;
    }
}
