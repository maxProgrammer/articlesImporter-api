package com.maxprogrammer.articles.articleimporter.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class ArtigosDto {

    public int page;

    @JsonProperty("per_page")
    public int perPage;

    public int total;

    @JsonProperty("total_pages")
    public int totalPages;

    public ArrayList<DetalheArtigoDto> data;

    @Deprecated
    public ArtigosDto() {
    }

    public ArtigosDto(int page, int perPage, int total, int totalPages, ArrayList<DetalheArtigoDto> data) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
    }

}
