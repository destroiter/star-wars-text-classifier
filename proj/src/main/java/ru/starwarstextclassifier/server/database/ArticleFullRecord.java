package ru.starwarstextclassifier.server.database;

import ru.starwarstextclassifier.classifier.TextClass;

public class ArticleFullRecord {
    private int id;
    private TextClass textClass;
    private String title;
    private String text;
    
    public ArticleFullRecord(int id, TextClass textClass, String title, String text) {
        this.id = id;
        this.textClass = textClass;
        this.title = title;
        this.text = text;
    }
    
    public int getId() {
        return id;
    }
    
    public TextClass getTextClass() {
        return textClass;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getText() {
        return text;
    }
}
