package ru.starwarstextclassifier.server.controllers.articlescontroller;

import ru.starwarstextclassifier.server.database.ArticleFullRecord;

class ArticleResponse {
    private ArticleFullRecord article;
    
    public ArticleResponse(ArticleFullRecord article) {
        this.article = article;
    }
    
    public ArticleFullRecord getArticle() {
        return article;
    }
}
