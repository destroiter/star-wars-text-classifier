package ru.starwarstextclassifier.webclassifiercore.controllers.classificationcontroller;

import ru.starwarstextclassifier.webclassifiercore.controllers.classificationcontroller.responses.ClassifyResponse;
import ru.starwarstextclassifier.webclassifiercore.controllers.classificationcontroller.requests.ClassifyRequest;
import ru.starwarstextclassifier.webclassifiercore.services.ClassificationService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/classification")
public class ClassificationController {
    private ClassificationService classificationService;
    
    public ClassificationController() throws Exception {
        classificationService = new ClassificationService();
    }
    
    @PostMapping(value = "/classify")
    public ClassifyResponse classify(@RequestBody ClassifyRequest request) throws Exception {
        if (request.getText().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empty string cannot be classified");
        }
        return new ClassifyResponse(classificationService.classify(request.getText()));
    }
}
