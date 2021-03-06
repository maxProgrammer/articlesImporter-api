package com.maxprogrammer.articles.articleimporter.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxprogrammer.articles.articleimporter.models.ArticleModel;
import lombok.Data;

@Data
public class ArticleDetailDto {

    public String title;
    public String url;
    public String author;

    @JsonProperty("num_comments")
    public int numComments;

    @JsonProperty("story_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int storyId;

    @JsonProperty("story_title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String storyTitle;

    @JsonProperty("story_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String storyUrl;

    @JsonProperty("parent_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int parentId;

    @JsonProperty("created_at")
    public int createdAt;

    @Deprecated
    public ArticleDetailDto() {
    }

    public ArticleDetailDto(String title, String url, String author, int numComments, int storyId, String storyTitle, String storyUrl, int parentId, int createdAt) {
        this.title = title;
        this.url = url;
        this.author = author;
        this.numComments = numComments;
        this.storyId = storyId;
        this.storyTitle = storyTitle;
        this.storyUrl = storyUrl;
        this.parentId = parentId;
        this.createdAt = createdAt;
    }

    public ArticleModel newArticleModelByTitle() {

        return new ArticleModel(title, author);
    }

    public ArticleModel newArticleModelByStoryTitle(){
        return new ArticleModel(storyTitle,author);
    }
}
