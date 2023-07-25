<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<%
    List<Product> allProducts = (List<Product>) request.getAttribute("products");
    int maxProductsToShow = 18; // Numero massimo di prodotti da visualizzare
    int productsCounter = 0; // Contatore di prodotti visualizzati
%>


<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorldCrafters</title>
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/all.css">
    <link rel="stylesheet" type="text/css" href="styles/home.css">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <script src="vendor/jquery.min.js"></script>
    <script src="vendor/flickity.pkgd.min.js"></script>
    <script src="scripts/script.js"></script>
</head>
<body>
    <%@ include file="src/header.jsp"%>
    <%@ include file="src/sidebar.jsp"%>
    <div id="userbar">
        <ul>
            <li>
                <button onclick="openModal('loginModal', 'src/log.jsp')">login</button>
                <!-- Finestra modale di login -->
                <div id="loginModal" class="modal"></div>
            </li>
            <li>
                <button onclick="openModal('registerModal', 'src/register.jsp')">register</button>
                <!-- Finestra modale di registrazione -->
                <div id="registerModal" class="modal"></div>
            </li>
            <li><a href="contact.jsp">Assistenza<br></a></li>
        </ul>
    </div>
        <div id="presentationContainer">
            <p>Fatti ispirare dalle tradizioni<br>artigianali di tutto<br>il mondo</p>
        </div>
    <main onclick="closeAll()">
        <!-- Il resto del contenuto -->
        <div id="showcaseContainer">
            <h1>Prodotti in evidenza</h1><br>
            <div id="showcase">
                <% if (allProducts != null && !allProducts.isEmpty()) { %>
                    <% for (Product product : allProducts) { %>
                        <% if (productsCounter >= maxProductsToShow) {
                                break;
                            } %>
                        <div class="product">
                            <div class="product-image">
                                <a href="#"><img src="<%= product.getImgSrc()%>"></a>
                            </div>
                            <div class="product-details">
                                <a href="#" class="product-title"><%= product.getTitle() %></a>
                                <div class="product-price">
                                    $ <%= product.getPrice() %>
                                </div>
									<button class="add-to-cart" data-product-id="<%= product.getProductId() %>" data-product-name="<%= product.getTitle() %>" data-product-price="<%= product.getPrice() %>">Add to cart</button>
                            </div>
                        </div>
                        <% productsCounter++; %>
                    <% } %>
                <% } else { %>
                    <p>Nessun prodotto disponibile al momento.</p>
                <% } %>
            </div>
        </div>
    </main>
    <%@ include file="src/footer.jsp" %>
</body>
</html>
