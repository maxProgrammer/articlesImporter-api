# 📰 articlesImporter-api 📰

> Status: Construction 🚧
### REST API responsible to consume an external API and save each article  if it has not the title or the story_title empty

<h1 align="center">
  <img alt="Readme" title="Readme" src="https://user-images.githubusercontent.com/87916631/174701540-d5130a1c-8148-4e09-a826-e35222f613e5.JPG"/>
</h1>

## 🔘 Fields of ArtigoModel are:
+ id
+ author
+ title

## 📔 Features
+ consult an external REST API
+ Add on database only the results that has not the title or the story_title empty

## 🤝🏽 Business Rules

+ API must be capable to call external API "https://jsonmock.hackerrank.com/api/articles"
+ API must add on database on events that has not the title or the story_title empty
+ If an Article has not title filled the story_tile can be used as title

## ⚒️ Technologies
+ Java 11
+ Spring Boot
+ Maven
+ PostgreSQL


## 🌱 Starters
+ Spring WEB
+ Validation
+ PostgreQL Drivr
+ Spring Data JPA
+ Lombok
+ Swagger UI
+ DevTools

## 🪖 Patterns
+ MVC
+ IOC
+ DTO

## 📲 contact
+ linkedin: https://www.linkedin.com/in/maxwneto/

