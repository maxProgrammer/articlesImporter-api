package com.maxprogrammer.articles.articleimporter.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ArtigoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String title;
    public String author;

    public ArtigoModel(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "ArtigoModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
