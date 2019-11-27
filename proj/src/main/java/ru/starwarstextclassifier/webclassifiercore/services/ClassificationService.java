package ru.starwarstextclassifier.webclassifiercore.services;

import org.springframework.stereotype.Service;
import ru.starwarstextclassifier.classifier.SWTextClassifier;
import ru.starwarstextclassifier.classifier.TextClass;

@Service
public class ClassificationService {
    private SWTextClassifier classifier;
    
    public ClassificationService() throws Exception {
        classifier = new SWTextClassifier();
    }
    
    public TextClass classify(String text) throws Exception {
        return classifier.classify(text);
    }
}
