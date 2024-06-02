package com.articles.publication.article;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

    public static void save(Article article) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO articles (title, author, content, fileName, status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, article.getTitle());
                stmt.setString(2, article.getAuthor());
                stmt.setString(3, article.getContent());
                stmt.setString(4, article.getFileName());
                stmt.setString(5, article.getStatus());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void validateArticle(int articleId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE articles SET status = 'Validated' WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, articleId);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Article> getAllPendingArticles() {
        List<Article> articles = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM articles WHERE status = 'Pending'";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Article article = new Article();
                    article.setId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setAuthor(rs.getString("author"));
                    article.setContent(rs.getString("content"));
                    article.setFileName(rs.getString("fileName"));
                    article.setStatus(rs.getString("status"));
                    articles.add(article);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
    
    public static List<Article> getAllValidatedArticles() {
        List<Article> articles = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM articles WHERE status = 'Validated'";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Article article = new Article();
                    article.setId(rs.getInt("id"));
                    article.setTitle(rs.getString("title"));
                    article.setAuthor(rs.getString("author"));
                    article.setContent(rs.getString("content"));
                    article.setFileName(rs.getString("fileName"));
                    article.setStatus(rs.getString("status"));
                    articles.add(article);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
}
