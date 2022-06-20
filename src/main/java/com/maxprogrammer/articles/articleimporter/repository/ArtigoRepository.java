package com.maxprogrammer.articles.articleimporter.repository;

import com.maxprogrammer.articles.articleimporter.models.ArtigoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<ArtigoModel,Long> {
}
