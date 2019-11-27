package ru.starwarstextclassifier.webclassifiercore.controllers.articlescontroller.requests;

import java.util.ArrayList;

import ru.starwarstextclassifier.webclassifiercore.database.entities.ArticleShortRecord;

public class AllArticlesResponse {
    private ArrayList<ArticleShortRecord> articles;
    
    public AllArticlesResponse(ArrayList<ArticleShortRecord> articles) {
        this.articles = articles;
    }
    
    public ArrayList<ArticleShortRecord> getArticles() {
        return articles;
    }
}
