package ru.starwarstextclassifier.webclassifiercore.controllers.articlescontroller;

import ru.starwarstextclassifier.webclassifiercore.controllers.articlescontroller.requests.AllArticlesResponse;
import ru.starwarstextclassifier.webclassifiercore.controllers.articlescontroller.responses.ArticleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.starwarstextclassifier.classifier.TextClass;
import ru.starwarstextclassifier.webclassifiercore.services.ArticlesService;

@RestController
@RequestMapping(value = "/api/articles")
public class ArticlesController {
    private ArticlesService articlesService;
    
    public ArticlesController() {
        articlesService = new ArticlesService();
    }
    
    @GetMapping(value = "/all")
    public AllArticlesResponse getAllArticles(@RequestParam(value="class", required=false, defaultValue = "") String textClass){
        return new AllArticlesResponse(articlesService.getAllArticles(TextClass.getTextClassByName(textClass)));
    }
    
    @GetMapping(value = "/id/{articleId}")
    public ArticleResponse getArticle(@PathVariable("articleId") Integer articleId){
        return new ArticleResponse(articlesService.getArticle(articleId));
    }
}
