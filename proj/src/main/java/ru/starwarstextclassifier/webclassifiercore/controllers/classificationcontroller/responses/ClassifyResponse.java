package ru.starwarstextclassifier.webclassifiercore.controllers.classificationcontroller.responses;

import ru.starwarstextclassifier.classifier.TextClass;

public class ClassifyResponse {
    private TextClass textClass;
    
    public ClassifyResponse(TextClass textClass) {
        this.textClass = textClass;
    }
    
    public TextClass getTextClass() {
        return textClass;
    }
}
