package com.maxprogrammer.articles.articleimporter.dtos;

import com.maxprogrammer.articles.articleimporter.ArtigoModel;
import lombok.Data;

@Data
public class ArtigoDto{
    public String title;
    public String url;
    public String author;
    public int num_comments;
    public int story_id;
    public String story_title;
    public String story_url;
    public int parent_id;
    public int created_at;

    public ArtigoModel artigoModel(){
        return new ArtigoModel(title,author);
    }
}
