package com.maxprogrammer.articles.articleimporter.repository;

import com.maxprogrammer.articles.articleimporter.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleModel, Long> {
    ArticleModel findArticleModelByTitle(String title);

}
