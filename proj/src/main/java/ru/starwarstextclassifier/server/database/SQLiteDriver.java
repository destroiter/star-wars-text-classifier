package ru.starwarstextclassifier.server.database;

import java.sql.*;
import java.util.ArrayList;

import ru.starwarstextclassifier.classifier.TextClass;

public class SQLiteDriver {
    
    public static ArrayList<ArticleShortRecord> getAllArticles(TextClass textClass) {
        ArrayList<ArticleShortRecord> articles = new ArrayList<>();
        
        try (Connection conn = connect();
            PreparedStatement pstmt  = conn.prepareStatement(
                    "SELECT Id, Title FROM Article" + (textClass != null ? " WHERE TextClass like ?" : "")
            )){
            
            if (textClass != null) {
                pstmt.setString(1, textClass.getName());
            }
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                articles.add(new ArticleShortRecord(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return articles;
    }
    
    public static ArticleFullRecord getArticle(int articleId) {
        ArticleFullRecord article = null;
        
        try (Connection conn = connect();
            PreparedStatement pstmt  = conn.prepareStatement(
                    "SELECT Id, TextClass, Title, Text FROM Article WHERE Id = ?"
            )){
            
            pstmt.setInt(1, articleId);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                article = new ArticleFullRecord(rs.getInt(1), TextClass.getTextClassByName(rs.getString(2)), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return article;
    }
    
    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:Articles.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}