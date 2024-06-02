package com.articles.publication.servlets;

import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import com.articles.publication.article.*;



//import java.io.*;
//import java.nio.file.*;
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.*;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.rendering.PDFRenderer;
//import org.apache.poi.xwpf.usermodel.*;
//
//@WebServlet("/submitArticle")
//@MultipartConfig
//public class SubmitArticleServlet extends HttpServlet {
//    private static final String UPLOAD_DIR = "uploads";
//    private ArticleDAO articleDAO = new ArticleDAO();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        String content = request.getParameter("content");
//        Part filePart = request.getPart("file");
//
//        if (filePart != null) {
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//            String applicationPath = getServletContext().getRealPath("");
//            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
//            File uploadDir = new File(uploadFilePath);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//            String filePath = uploadFilePath + File.separator + fileName;
//            filePart.write(filePath);
//
//            // Generate image preview
//            String previewFileName = fileName + "_preview.png";
//            String previewFilePath = uploadFilePath + File.separator + previewFileName;
//            if (fileName.endsWith(".pdf")) {
//                generatePdfPreview(filePath, previewFilePath);
//            } else if (fileName.endsWith(".docx")) {
//                generateDocxPreview(filePath, previewFilePath);
//            }
//
//            Article article = new Article();
//            article.setTitle(title);
//            article.setAuthor(author);
//            article.setContent(content);
//            article.setFileName(fileName);            // Set the original document filename
//              // Set the preview image filename
//            article.setStatus("Pending");
//
//            articleDAO.save(article);
//        } else {
//            response.getWriter().println("File part is missing.");
//        }
//
//        response.sendRedirect("userDashboard");
//    }
//
//    private void generatePdfPreview(String pdfPath, String imagePath) throws IOException {
//        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
//            PDFRenderer pdfRenderer = new PDFRenderer(document);
//            BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300); // Render the first page (page index 0) at 300 DPI
//            ImageIO.write(bim, "png", new File(imagePath));
//        }
//    }
//
//    private void generateDocxPreview(String docxPath, String imagePath) throws IOException {
//        try (FileInputStream fis = new FileInputStream(new File(docxPath))) {
//            XWPFDocument document = new XWPFDocument(fis);
//            BufferedImage img = new BufferedImage(612, 792, BufferedImage.TYPE_INT_RGB);
//            Graphics2D g = img.createGraphics();
//            g.setColor(Color.WHITE);
//            g.fillRect(0, 0, 612, 792);
//            g.setColor(Color.BLACK);
//            int y = 20;
//            for (XWPFParagraph paragraph : document.getParagraphs()) {
//                g.drawString(paragraph.getText(), 10, y);
//                y += 20;
//                // Stop after the first page's worth of content
//                if (y > 772) {
//                    break;
//                }
//            }
//            g.dispose();
//            ImageIO.write(img, "png", new File(imagePath));
//        }
//    }
//}


@MultipartConfig
public class SubmitArticleServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";
    private ArticleDAO articleDAO = new ArticleDAO();

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        Part filePart = request.getPart("file");

        if (filePart != null) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String applicationPath = getServletContext().getRealPath("");
            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadFilePath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            String filePath = uploadFilePath + File.separator + fileName;
            filePart.write(filePath);

            Article article = new Article();
            article.setTitle(title);
            article.setAuthor(author);
            article.setContent(content);
            article.setFileName(fileName);
            article.setStatus("Pending");

            articleDAO.save(article);
        } else {
            response.getWriter().println("File part is missing.");
        }

        response.sendRedirect("userDashboard");
    }
}





//
//@MultipartConfig
//public class SubmitArticleServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        String content = request.getParameter("content");
//
//        // Debugging statements
//        System.out.println("Title: " + title);
//        System.out.println("Author: " + author);
//        System.out.println("Content: " + content);
//
//        Part filePart = request.getPart("file");
//
//        if (filePart != null) {
//            System.out.println("File Part: " + filePart);
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//            System.out.println("File Name: " + fileName);
//            InputStream fileContent = filePart.getInputStream();
//
//            Article article = new Article();
//            article.setTitle(title);
//            article.setAuthor(author);
//            article.setContent(content);
//            article.setFileName(fileName);
//            article.setStatus("Pending");
//
//            ArticleDAO.save(article);
//            response.sendRedirect("userDashboard");
//        } else {
//            System.out.println("File part is missing.");
//            response.getWriter().println("File part is missing.");
//        }
//
//        
//    }
//}
