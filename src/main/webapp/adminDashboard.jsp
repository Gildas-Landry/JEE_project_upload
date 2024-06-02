<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Pending Articles</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Action</th>
        </tr>
        <c:forEach var="article" items="${pendingArticles}">
            <tr>
                <td>${article.id}</td>
                <td>${article.title}</td>
                <td>${article.author}</td>
                <td>
                    <form action="validateArticle" method="post">
                        <input type="hidden" name="articleId" value="${article.id}">
                        <input type="submit" value="Validate">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
