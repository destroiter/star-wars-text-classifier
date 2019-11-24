package ru.starwarstextclassifier.server.controllers.classificationcontroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.starwarstextclassifier.classifier.SWTextClassifier;

@RestController
@RequestMapping(value = "/api/classification")
public class ClassificationController {
    private SWTextClassifier classifier;
    
    public ClassificationController() throws Exception {
        classifier = new SWTextClassifier();
    }
    
    @PostMapping(value = "/classify")
    public ClassifyResponse classify(@RequestBody ClassifyRequest request) throws Exception {
        return new ClassifyResponse(classifier.classify(request.getText()));
    }
}
