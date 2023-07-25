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
    <link rel="icon" type="image/x-icon" href="../imgs/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../styles/cart.css">
    <link rel="stylesheet" type="text/css" href="../styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="../vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="../vendor/font-awesome/css/all.css">
    <script src="../vendor/jquery.min.js"></script>
    <script src="../vendor/flickity.pkgd.min.js"></script>
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
        
        <div id="background"></div>
        
        <div id="cartContainer">
            
            <section id="productsContainer">
                <h1>Prodotti nel carrello</h1><br>

                <% 
                    // Ottieni il carrello dalla sessione
                    List<Product> cartItems = (List<Product>) request.getSession().getAttribute("cart");
                    if (cartItems != null && !cartItems.isEmpty()) {
                        for (Product product : cartItems) {
                %>
                <div class="product">
                    <a href="#"><img src="<%= product.getImgSrc() %>"></a>
                    <p class="product-title"><%= product.getTitle() %></p>
                    <p class="product-price">$ <%= product.getPrice() %></p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
                <% 
                        }
                    } else {
                %>
                <p>Nessun prodotto nel carrello al momento.</p>
                <%
                    }
                %>

            </section>
    
            <section id="paymentContainer">
               
                
                <br/>
                
                <div id="total">
                    <strong>Totale:</strong>
                    <strong>$ 34.97</strong>
                </div>
                
                <br>
	            <a id="checkout" href="#">Vai al checkout</a>
                <br><br>
                <a id="back" onclick="goBack()">Continua gli acquisti</a>
                
                
            </section>
        </div>

    </main>

    <%@ include file="footer.jsp" %>
    
    <script src="../scripts/script.js"></script>
    <script src="../scripts/cart.js"></script>
    
</body>
</html>