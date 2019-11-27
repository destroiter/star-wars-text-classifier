package ru.starwarstextclassifier.webclassifiercore.controllers.articlescontroller.responses;

import ru.starwarstextclassifier.webclassifiercore.database.entities.ArticleFullRecord;

public class ArticleResponse {
    private ArticleFullRecord article;
    
    public ArticleResponse(ArticleFullRecord article) {
        this.article = article;
    }
    
    public ArticleFullRecord getArticle() {
        return article;
    }
}
