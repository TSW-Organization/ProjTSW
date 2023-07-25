<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/home.css">
</head>
<body>
    
    <%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/guestUserbar.jsp" %>
    
    <div id="presentationContainer" onclick="closeAll()">
    	<%@ include file="templates/presentationBg.jsp" %>
    	<p>Fatti ispirare dalle tradizioni<br>artigianali di tutto<br>il mondo</p>
    </div>
    
    
    <main onclick="closeAll()">

        <div id="showcaseContainer">
            <h1>Prodotti in evidenza</h1><br>
            <div id="showcase">
                
                <% @SuppressWarnings("unchecked")
                   List<Product> products = (List<Product>) request.getAttribute("products"); %>
				<% for (int i = 0; i < 18; i++) { %>
					<% Product product = products.get(i); %>
				        <div class="product">
	                        <div class="product-image">
	                            <a href="product?id=<%= product.getId() %>">
						            <img src="<%= product.getImgSrc()%>">
						        </a>
	                        </div>
	                        <div class="product-details">
	                            <a href="product?id=<%= product.getId() %>" class="product-name">
						            <%= product.getName() %>
						        </a>
	                            <div class="product-price">
	                                € <%= String.format("%.2f", product.getPrice()) %>
	                            </div>
	                            <!--<a href="add-to-cart?id=<%= product.getId() %>" class="add-to-cart" onclick="addToCart(<%= product.getId() %>)">Add to cart</a>-->
	                        </div>  
                    	</div>
				<%} %>
				
            </div>
        </div>
    </main>
    
    <%@ include file="templates/footer.jsp" %>
    
</body>
</html>