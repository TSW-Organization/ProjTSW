<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<% 
	boolean showSidebar = false;
	showSidebar = (Boolean) request.getAttribute("showSidebar");
%>

<% if (showSidebar==true) { %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sidebar</title>
<link rel="stylesheet" type="text/css" href="styles/sidebar.css">
</head>
<body>
	<div id="sidebar">
        
	    <i onclick="toggleSidebar()" class="fa fa-times" aria-hidden="true"></i>
	    <h1>WorldCrafters</h1>

        <ul>
        	<li class="category"><a href="#">Arte </a><i class="fa fa-chevron-down" aria-hidden="true"></i></li>
        		<li class="subcategory"><a href="#">Fotografia</a></li>
        		<li class="subcategory"><a href="#">Pittura</a></li>
        		<li class="subcategory"><a href="#">Scultura</a></li>
        		<li class="subcategory"><a href="#">Vetro<br><br></a></li>
        	<li class="category"><a href="#">Abbigliamento </a><i class="fa fa-chevron-down" aria-hidden="true"></i></li>
        		<li class="subcategory"><a href="#">Uomo</a></li>
        		<li class="subcategory"><a href="#">Donna</a></li>
        		<li class="subcategory"><a href="#">Bambino</a></li>
        		<li class="subcategory"><a href="#">Borse<br><br></a></li>
			<li class="category"><a href="#">Gioielli </a><i class="fa fa-chevron-down" aria-hidden="true"></i></li>
				<li class="subcategory"><a href="#">Anelli</a></li>
				<li class="subcategory"><a href="#">Bracciali</a></li>
				<li class="subcategory"><a href="#">Collane</a></li>
				<li class="subcategory"><a href="#">Orecchini<br><br></a></li>
        	<li class="category"><a href="#">Intrattenimento </a><i class="fa fa-chevron-down" aria-hidden="true"></i></li>
        		<li class="subcategory"><a href="#">Cinema</a></li>
        		<li class="subcategory"><a href="#">Libri</a></li>
        		<li class="subcategory"><a href="#">Musica</a></li>
        		<li class="subcategory"><a href="#">Giochi e giocattoli<br><br></a></li>
        	<li class="category"><a href="#">Accessori<br><br></a></li>
        	<li class="category"><a href="#">Casa e arredi<br><br></a></li>
        	<li class="category"><a href="#">Oggetti da collezione<br><br></a></li>
        	<li class="category"><a href="#">Elettronica e accessori<br><br></a></li>
        	<li class="category"><a href="#">Animali domestici<br><br></a></li>
        	<li class="category"><a href="#">Vintage<br><br></a></li>
        </ul>
    </div>
</body>
</html>
<% } %>