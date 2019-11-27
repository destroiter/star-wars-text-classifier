package ru.starwarstextclassifier.webclassifiercore.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ru.starwarstextclassifier.classifier.TextClass;
import ru.starwarstextclassifier.webclassifiercore.database.SQLiteDriver;
import ru.starwarstextclassifier.webclassifiercore.database.entities.ArticleFullRecord;
import ru.starwarstextclassifier.webclassifiercore.database.entities.ArticleShortRecord;

@Service
public class ArticlesService {
    private SQLiteDriver databaseDriver;
    
    public ArticlesService() {
        databaseDriver = new SQLiteDriver();
    }
    
    public ArrayList<ArticleShortRecord> getAllArticles(TextClass textClass) {
        return databaseDriver.getAllArticles(textClass);
    }
    
    public ArticleFullRecord getArticle(int articleId) {
        return databaseDriver.getArticle(articleId);
    }
}
