package ru.starwarstextclassifier.server.controllers.articlescontroller;

import java.util.ArrayList;

import ru.starwarstextclassifier.server.database.ArticleShortRecord;

public class AllArticlesResponse {
    private ArrayList<ArticleShortRecord> articles;
    
    public AllArticlesResponse(ArrayList<ArticleShortRecord> articles) {
        this.articles = articles;
    }
    
    public ArrayList<ArticleShortRecord> getArticles() {
        return articles;
    }
}
