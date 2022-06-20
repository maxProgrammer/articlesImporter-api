package com.maxprogrammer.articles.articleimporter.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class ArticleDto {

    public int page;

    @JsonProperty("per_page")
    public int perPage;

    public int total;

    @JsonProperty("total_pages")
    public int totalPages;

    public ArrayList<ArticleDetailDto> data;

    @Deprecated
    public ArticleDto() {
    }

    public ArticleDto(int page, int perPage, int total, int totlalPages, ArrayList<ArticleDetailDto> data) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
    }

}
