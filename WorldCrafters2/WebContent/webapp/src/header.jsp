<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	boolean showHeader = false;
	showHeader = (Boolean) request.getAttribute("showHeader"); 
%>

<% if (showHeader==true) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header</title>
<link rel="stylesheet" type="text/css" href="styles/header.css">
</head>
<body>
	<header>
        
        <a id="logoContainer" href="home">
        	<img src="imgs/logo2.png">
        	<span>WorldCrafters</span>
        </a>
        
        <a class="link" id="categoriesButton" onclick="toggleSidebar()"><i class="fa fa-bars" aria-hidden="true"></i></a>
        
        <form id="searchbarContainer" onclick="closeAll()">
            <input type="text" placeholder="Cerca...">
            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
        </form>
    
        <a class="link" id="homeButton" href="home">Home</a>
        <!-- <a class="topnav" href="#"><i class="fa fa-heart fa-xl" aria-hidden="true"></i></a>-->
        <a class="link" id="cartButton" href="cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
        <a class="link" id="userButton" onclick="toggleUserbar()"><i class="fa fa-user" aria-hidden="true"></i></a>
         
    </header>
    <div id="headerSpace"></div>
</body>
</html>
<% } %>