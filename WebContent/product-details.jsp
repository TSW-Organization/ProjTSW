<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="model.Product" %>

<%
request.setAttribute("showHeader", true);
request.setAttribute("showFooter", true);
request.setAttribute("showSidebar", true);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorldCrafters</title>
    <link rel="icon" type="image/x-icon" href="images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/all.css">
    <link rel="stylesheet" type="text/css" href="styles/log-reg.css">
    <link rel="stylesheet" type="text/css" href="styles/product-details.css">
    <script src="vendor/jquery.min.js"></script>
    <script src="vendor/flickity.pkgd.min.js"></script>
    <script src="scripts/script.js"></script>
</head>
<body>


    <%@ include file="header.jsp"%>
    <%@ include file="sidebar.jsp"%>
    
    
    <div id="background"></div>
    
    <div class="product-container">

	    <% Product product = (Product) request.getAttribute("product"); %>
	
	    <div class="product-details">
	      	<div class="product-image">
	        	<img src="<%= product.getImgSrc()%>" alt="<%= product.getName()%>">
	      	</div>
	      	<div class="product-info">
		        <h1><%= product.getName() %></h1>
		        <p class="price">$ <%= product.getPrice() %></p>
		        <p>Venditore: <%= product.getSeller() %></p>
		        <p>Quantità disponibile: <%= product.getQuantity() %></p>
		        <p>Data di inserimento: <%= product.getListingDate() %></p>
		        <div class="description">
		          	<p><%= product.getDescription() %></p>
		        </div>
		        <button class="add-to-cart">Aggiungi al carrello</button>
	      	</div>
		</div>
	</div>
    
    
    
    
    
    <%@ include file="footer.jsp"%>
    
</body>
</html>