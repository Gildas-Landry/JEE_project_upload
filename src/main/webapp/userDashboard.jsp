<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="./css/userDashboard.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
</head>
<body>
	<header>
		<nav class=navbar>
			
			<ul class="nav-links">
	            <li><a href="home.jsp">Home</a></li>
	            <li><a href="#">Submissions</a></li>
	            <li><a href="#">Profile</a></li>
	            <li><a href="#">Logout</a></li>
	        </ul>
		</nav>
		<nav class=navbar2>
			<h2 style="font-weight:bold; color:black;">Dashboard</h2>
			<input class="search-bar" type="search" placeholder="search project">
			<a class="brand" href="submission.jsp">+ UPLOAD</a>
		</nav>
	</header>
	
	<div class="container">
		<aside class="sidebar">
			<div class="profil"><img width="400px" height="400px" alt="" src="./assets/profilP.jpeg"></div>
	        <ul class="sidebar-links">
	            <li><a href="userDashboard"><i class="fas fa-home dashboard-icon"></i> Dashboard</a></li>
	            <li><a href="submission.jsp"><i class="fas fa-plus plus-icon"></i> New Submission</a></li>
	            <li><a href="userDashboard"> <i class="fas fa-book book-icon"></i> My Articles</a></li>
	            <li><a href="#"> <i class="fas fa-cog settings-icon"></i> Settings</a></li>
	        </ul>
    	</aside>
	     <main class="main-content">
			<div class="dashboard">
			
			        <c:forEach var="article" items="${validatedArticles}" >
			        <div class="card">
			        	
			            <div class="card-content">
			            	<div class="content1">
			            		<!-- Display image preview and link to the file for viewing -->
				            	<a href="uploads/${article.fileName}" target="_blank">
		                			<img src="./assets/test.png" alt="Preview" style="width:100px;height:100px;">
		            			</a>
				                <h3>${article.title}</h3>
				                <p>${article.author}</p>
			            	</div>
			            	<div class="content2">
			            		<a class="btn" href="downloadFile?fileName=${article.fileName}">Download</a>
			            			<br>
			            		<!-- If you want to preview the document, ensure it's a readable format in the browser -->
			            		<a class="btn" href="uploads/${article.fileName}" target="_blank">View</a>
			            	
			            	</div>
			            	
			                 
			            </div>
			            <i class="fas fa-ellipsis-vertical ellipsis-icon"></i>
			          </div>
			        </c:forEach>
			 	
		 	</div>
	 	</main>
	 </div>
	 
</body>
<footer class="footer">
    <div class="footer-content">
        <p>&copy; 2024 My Dashboard. All rights reserved.</p>
        <ul class="footer-links">
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Terms of Service</a></li>
            <li><a href="#">Contact Us</a></li>
        </ul>
    </div>
</footer>
</html>

<%--
    <h1>Validated Articles</h1><a href="uploads/${article.fileName}" target="_blank">
	                <img src="uploads/${article.previewFileName}" alt="Preview" style="width:100px;height:100px;">
	            </a> --%>
