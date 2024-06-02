<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- article_submission.jsp -->
<html>
<head>
    <title>Submit Article</title>
</head>
<body>
    <form action="submitArticle" method="post" enctype="multipart/form-data">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br>
        <label for="content">Content:</label><br>
        <textarea id="content" name="content" rows="10" cols="30" required></textarea><br>
        <label for="file">Upload Document:</label>
        <input type="file" id="file" name="file" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
    