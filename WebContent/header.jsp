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
	
	<header class="flex-between">
        
        <a id="logo" class="simple-link bold flex-between"  href="home">
        	<img src="imgs/logo2.png">
        	<span class="color-white">WorldCrafters</span>
        </a>
        
        <a class="simple-link bold" onclick="toggleSidebar()"><i class="icon fa fa-bars" aria-hidden="true"></i></a>
        
        <form id="searchbar" class="flex-between" onclick="closeAll()">
            <input type="text" placeholder="Cerca...">
            <button type="submit"><i class="icon fa fa-search" aria-hidden="true"></i></button>
        </form>
    
        <a id="homeButton" class="simple-link bold" href="home">Home</a>
        <!-- <a class="topnav" href="#"><i class="icon fa fa-heart fa-xl" aria-hidden="true"></i></a>-->
        <a class="simple-link bold" href="cart.jsp"><i class="icon pointer fa fa-shopping-cart" aria-hidden="true"></i></a>
        <a class="simple-link bold" onclick="toggleUserbar()"><i class="icon fa fa-user" aria-hidden="true"></i></a>
         
    </header>
    
    <div id="headerSpace"></div>
    
</body>
</html>
<% } %>