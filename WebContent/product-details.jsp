<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="model.Product" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/product-details.css">
    <script src="scripts/cart.js"></script>
</head>
<body>


    <%@ include file="templates/header.jsp"%>
	<%@ include file="templates/sidebar.jsp"%>
	<%@ include file="templates/guestUserbar.jsp" %>
	<%@ include file="templates/presentationBg.jsp" %>
	

    <main>
   
	    <div class="product-container" onclick="closeAll()">
	
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
			        <button class="add-to-cart" onclick="addToCart(<%= product.getId() %>)">Aggiungi al carrello</button>
		      	</div>
			</div>
		</div>
	</main>
    
    <%@ include file="templates/footer.jsp"%>
    
</body>
</html>