package com.articles.publication.article;

public class Article {
    private int id;
    private String title;
    private String author;
    private String content;
    private String fileName;
    private String status;

    // Default constructor
    public Article() {}

    // Parameterized constructor
    public Article(String title, String author, String content, String fileName, String status) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.fileName = fileName;
        this.status = status;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
