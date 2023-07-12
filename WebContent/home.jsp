<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<%
   	request.setAttribute("showHeader", true);
	request.setAttribute("showFooter", true);
	request.setAttribute("showSidebar", true);
%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorldCrafters</title>
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles/home.css">
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/all.css">
    <script src="vendor/jquery.min.js"></script>
    <script src="vendor/flickity.pkgd.min.js"></script>
</head>
<body>
    
    <%@ include file="header.jsp" %>
    <%@ include file="sidebar.jsp" %>
    
    <div id="userbar">
        <ul>
            <li><a href="#">Accedi<br></a></li>
            <li><a href="#">Registrati<br></a></li>
            <li><a href="contact.jsp">Assistenza<br></a></li>
        </ul>
    </div>
    
    <main onclick="closeAll()">
        
        
        <div id="presentationContainer">
            <p>Fatti ispirare dalle tradizioni<br>artigianali di tutto<br>il mondo</p>
        </div>
    	
        <div id="showcaseContainer">
            <h1>Prodotti in evidenza</h1><br>
            <div id="showcase"> 
	            
				<% List<Product> products = (List<Product>) request.getAttribute("products"); %>
				<% int counter = 0; %>
				<% for (int i = 0; i < 18; i++) { %>
					<% Product product = products.get(i); %>
				        <div class="product">
				            <a href="#"><img src="<%= product.getImgSrc()%>"></a>
				            <a href="#" class="product-title"><%= product.getTitle() %></a>
				            <p class="product-price">$ <%= product.getPrice() %></p>
				            <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
				        </div>
				<%} %>
			    
			</div>
        </div>
        
    </main>
    
	<%@ include file="footer.jsp" %>

    <script src="scripts/script.js"></script>
    
</body>
</html>