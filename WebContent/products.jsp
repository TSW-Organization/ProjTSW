<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorldCrafters</title>
    <link rel="icon" type="image/x-icon" href="images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles/products-list.css">
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/all.css">
    <script src="vendor/jquery.min.js"></script>
    <script src="vendor/flickity.pkgd.min.js"></script>
    <script src="scripts/script.js"></script>
</head>
<body>
	
	<%@ include file="header.jsp"%>
    <%@ include file="sidebar.jsp"%>
    
	<div id="userbar">
        <ul>
            <li>
                <button onclick="openModal('loginModal', 'log.jsp')">login</button>
                <!-- Finestra modale di login -->
                <div id="loginModal" class="modal"></div>
            </li>
            <li>
                <button onclick="openModal('registerModal', 'register.jsp')">register</button>
                <!-- Finestra modale di registrazione -->
                <div id="registerModal" class="modal"></div>
            </li>
            <li><a href="contact.jsp">Assistenza<br></a></li>
        </ul>
    </div>

    <%-- Definisci il numero di prodotti per pagina --%>
    <% int productsForPage = 24; %>

    <%-- Ottieni la lista completa dei prodotti --%>
    <% @SuppressWarnings("unchecked") 
       List<Product> products = (List<Product>) request.getAttribute("products"); %>

    <%-- Calcola il numero totale di pagine --%>
    <% int pagesNumber = (int) Math.ceil((double) products.size() / productsForPage); %>

    <%-- Ottieni il numero di pagina corrente dalla richiesta --%>
    <% int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1; %>

    <%-- Calcola l'indice di inizio e fine dei prodotti per la pagina corrente --%>
    <% int startIndex = (currentPage - 1) * productsForPage; %>
    <% int endIndex = Math.min(startIndex + productsForPage, products.size()); %>

    <%-- Ottieni la sottolista dei prodotti per la pagina corrente --%>
    <% List<Product> productsPage = products.subList(startIndex, endIndex); %>

    <%-- Mostra i prodotti per la page corrente --%>
    <main onclick="closeAll()">
        
        <div id="presentation"></div>
        
        <div id="productsListContainer">
            
            <div id="productsList">
                
				<% for (Product product : productsPage) { %>
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
                                $ <%= product.getPrice() %>
                            </div>
                            <button class="add-to-cart">Add to cart</button>
                        </div>  
                   	</div>
				<%} %>
				
            </div>
        </div>
        
    </main>

    <%-- Mostra la paginazione solo se c'è più di una pagina --%>
    <% if (pagesNumber > 1) { %>
    <div id="pagination">
        <%-- Mostra il link alla pagina precedente se non si è sulla prima pagina --%>
        <% if (currentPage > 1) { %>
            <a href="?category=<%= request.getParameter("category") %>&page=<%= currentPage - 1 %>">&lt;</a>
        <% } %>

        <%-- Mostra i numeri di pagina --%>
        <% int maxVisiblePages = 6; %>

        <% if (pagesNumber <= maxVisiblePages) { %>
            <% for (int i = 1; i <= pagesNumber; i++) { %>
                <%-- Evidenzia la pagina corrente --%>
                <% if (i == currentPage) { %>
                    <strong><%= i %></strong>
                <% } else { %>
                    <a href="?category=<%= request.getParameter("category") %>&page=<%= i %>"><%= i %></a>
                <% } %>
            <% } %>
        <% } else { %>
            <% int startPage = Math.max(currentPage - (maxVisiblePages / 2), 1); %>
            <% int endPage = Math.min(startPage + maxVisiblePages - 1, pagesNumber); %>

            <% if (startPage > 1) { %>
                <a href="?category=<%= request.getParameter("category") %>&page=1">1</a>
                <span>...</span>
            <% } %>

            <% for (int i = startPage; i <= endPage; i++) { %>
                <%-- Evidenzia la pagina corrente --%>
                <% if (i == currentPage) { %>
                    <strong><%= i %></strong>
                <% } else { %>
                    <a href="?category=<%= request.getParameter("category") %>&page=<%= i %>"><%= i %></a>
                <% } %>
            <% } %>

            <% if (endPage < pagesNumber) { %>
                <span>...</span>
                <a href="?category=<%= request.getParameter("category") %>&page=<%= pagesNumber %>"><%= pagesNumber %></a>
            <% } %>
        <% } %>

        <%-- Mostra il link alla pagina successiva se non si è sull'ultima pagina --%>
        <% if (currentPage < pagesNumber) { %>
            <a href="?category=<%= request.getParameter("category") %>&page=<%= currentPage + 1 %>">&gt;</a>
        <% } %>
    </div>
<% } %>

    
    
    <%@ include file="footer.jsp" %>
    
</body>
</html>