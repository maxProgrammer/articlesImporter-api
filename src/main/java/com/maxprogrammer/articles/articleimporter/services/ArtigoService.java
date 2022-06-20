package com.maxprogrammer.articles.articleimporter.services;

import com.maxprogrammer.articles.articleimporter.dtos.ArtigosDto;
import com.maxprogrammer.articles.articleimporter.dtos.DetalheArtigoDto;
import com.maxprogrammer.articles.articleimporter.models.ArtigoModel;
import com.maxprogrammer.articles.articleimporter.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArtigoService {

    @Autowired
    ArtigoRepository artigoRepository;

    public void importerArticles() {
        RestTemplate restTemplate = new RestTemplate();

        String urlResource = "https://jsonmock.hackerrank.com/api/articles";

        ArtigosDto allArticles = restTemplate.getForObject(urlResource, ArtigosDto.class);

        List<ArtigoModel> allList = new ArrayList<>();

        for (DetalheArtigoDto detalhe : allArticles.data) {
            salveArticles(detalhe);
        }
    }

    public void salveArticles(@RequestBody @Valid DetalheArtigoDto detalheArtigoDto) {
        ArtigoModel novoArtigo = detalheArtigoDto.novoArtigo();
        artigoRepository.save(novoArtigo);

    }
}
