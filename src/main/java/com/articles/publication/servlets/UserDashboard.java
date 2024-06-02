package com.articles.publication.servlets;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.articles.publication.article.*;

public class UserDashboard extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Article> validatedArticles = ArticleDAO.getAllValidatedArticles();
	        request.setAttribute("validatedArticles", validatedArticles);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("userDashboard.jsp");
	        dispatcher.forward(request, response);
	    }
}
