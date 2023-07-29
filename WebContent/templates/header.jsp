<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/header.css">
    <script src="scripts/cart.js"></script>
</head>
<body>
	<header>
        
        <a id="logoContainer" href="home">
        	<img src="images/logo2.png">
        	<span>WorldCrafters</span>
        </a>
        
        <a class="link" id="categoriesButton" onclick="toggleSidebar()"><i class="fa fa-bars" aria-hidden="true"></i></a>
        
        <form id="searchbar-form">
		    <input type="text" id="searchInput" placeholder="Cerca...">
		    <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
		</form>
    	
        <a class="link" id="homeButton" href="home">Home</a>
        <!-- <a class="topnav" href="#"><i class="fa fa-heart fa-xl" aria-hidden="true"></i></a>-->
        <div>
        	<a class="link" id="cartButton" href="cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
        	<span id="cartQuantity"></span>
        </div>
        <a class="link" id="userButton" onclick="toggleUserbar()"><i class="fa fa-user" aria-hidden="true"></i></a>
         
    </header>
    <div id="headerSpace"></div>
    
</body>
</html>