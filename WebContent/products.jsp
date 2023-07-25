<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/products.css">
</head>
<body>
	
	<%@ include file="templates/header.jsp"%>
	<%@ include file="templates/sidebar.jsp"%>
	<%@ include file="templates/guestUserbar.jsp" %>
	<%@ include file="templates/presentationBg.jsp" %>


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
                                € <%= String.format("%.2f", product.getPrice()) %>
                            </div>
                            <!--<button class="add-to-cart">Add to cart</button>-->
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

    <%@ include file="templates/footer.jsp"%>
    
</body>
</html>