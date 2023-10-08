<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="it.unisa.bean.Product" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/home.css">	
	<link rel="stylesheet" type="text/css" href="styles/log-reg.css">
	<script src="scripts/log-reg.js"></script>
	<script src="scripts/script.js"></script>
	
</head>
<body>
    
    <%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/userbar.jsp" %>
	<!-- contenuto in overlay sulla home -->
<!-- Overlay per register.jsp -->
<div id="register-overlay" style="display: none;">
    <div id="register-overlay-content">
    </div>
</div>

<!-- Overlay per login.jsp -->
<div id="login-overlay" style="display: none;">
    <div id="login-overlay-content">
    </div>
</div>

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