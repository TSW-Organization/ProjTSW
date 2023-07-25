<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/cart.css">
    <script src="scripts/cart.js"></script>
</head>
<body>

	<%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/guestUserbar.jsp" %>
	<%@ include file="templates/presentationBg.jsp" %>
    
    
    <ul id="cartList">
    
    </ul>
    
    
    
    
    
    
	<!--  
    <main onclick="closeAll()">
        <div id="cartContainer">
            
            <% List<Product> cartItems = (List<Product>) request.getAttribute("cartItems"); %>
            
            <section id="productsContainer">
                <h1>Prodotti nel carrello</h1><br>
                
                <% for(Product product : cartItems) { %>
                	<div class="product">
	                    <a href="#"><img src="<%= product.getImgSrc() %>"></a>
	                    <p class="product-name"><%= product.getName() %></p>
	                    <p class="product-price">$ <%= product.getPrice() %></p>
	                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                	</div>
                <% } %>

            </section>
    
            <section id="paymentContainer">
                <h1>Resoconto</h1>
    
                <div class="list">
                    
                    <div class="product">
                    	<h4 class="product-name">Prodotto</h4>
                    	<h4>Prezzo</h4>
                    </div>
                    
                    <% for(Product product : cartItems) { %>
	                	<div class="product">
		                    <h4 class="product-name"><%= product.getName() %></h4>
                    		<h4>$ <%= product.getPrice() %></h4>
	                	</div>
	                <% } %>

					<br/>
					<div class="product">
						<p class="product-name">Spedizione</p>
						<p>$ 5.00</p>
					</div>

                </div>
                
                <br/>
                
                <div id="total">
                    <strong>Totale:</strong>
                    <strong>$ 34.97</strong>
                </div>
                
                <br>
	            <a id="checkout" href="#">Vai al checkout</a>
                <br><br>
                <button id="back" onclick="goBack()">Continua gli acquisti</button>
                
                
            </section>
        </div>

    </main>
	-->
    
 
    <%@ include file="templates/footer.jsp" %>
    
</body>
</html>