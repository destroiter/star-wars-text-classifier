package ru.starwarstextclassifier.server.database;

import ru.starwarstextclassifier.classifier.TextClass;

public class ArticleShortRecord {
    private int id;
    private String title;
    
    public ArticleShortRecord(int id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
}
