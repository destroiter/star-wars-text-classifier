package ru.starwarstextclassifier.server.controllers.articlescontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.starwarstextclassifier.classifier.TextClass;
import ru.starwarstextclassifier.server.database.SQLiteDriver;

@RestController
@RequestMapping(value = "/api/articles")
public class ArticlesController {
    
    @GetMapping(value = "/all")
    public AllArticlesResponse getAllArticles(@RequestParam(value="class", required=false, defaultValue = "") String textClass){
        return new AllArticlesResponse(SQLiteDriver.getAllArticles(TextClass.getTextClassByName(textClass)));
    }
    
    @GetMapping(value = "/id/{articleId}")
    public ArticleResponse getArticle(@PathVariable("articleId") Integer articleId){
        return new ArticleResponse(SQLiteDriver.getArticle(articleId));
    }
}
