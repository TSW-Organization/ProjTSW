<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="it.unisa.bean.Product" %>
<%@ page import="it.unisa.dao.ProductDAO" %>
<%@ page import="it.unisa.bean.Category" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html"%>
    <link rel="stylesheet" type="text/css" href="styles/editProduct.css">
    <script type="text/javascript" src="scripts/editProductScript.js"></script>
</head>
<body>
    <header>
        <%@ include file="templates/header.jsp"%>
        <%@ include file="templates/sidebar.jsp"%>
        <%@ include file="templates/userbar.jsp"%>
    </header>

    <main class="admin-content">
        <section class="admin-section">
            <% String productIdParam = request.getParameter("id");
               int productId = (productIdParam != null) ? Integer.parseInt(productIdParam) : -1;
               
               if (productId != -1) {
                   ProductDAO productDAO = new ProductDAO();
                   Product product = productDAO.getProductById(productId);
                   
                   if (product != null) { %>
                       <h1>Modifica Prodotto</h1>
                       <form id="editProductForm">
                           <label for="productName">Nome:</label>
                           <input type="text" id="productName" name="productName" value="<%= product.getName() %>" required><br>
                           
                           <label for="productPrice">Prezzo:</label>
                           <input type="number" id="productPrice" name="productPrice" step="0.01" value="<%= product.getPrice() %>" required><br>
                           
                           <label for="productSeller">Venditore:</label>
                           <input type="text" id="productSeller" name="productSeller" value="<%= product.getSeller() %>" required><br>
                           
                           <label for="productCategory">Categoria:</label>
                           <select id="productCategory" name="productCategory" required>
                               <% for (Category category : Category.values()) { %>
                                   <option value="<%= category.name() %>" <%= (category == product.getCategory()) ? "selected" : "" %>><%= category.name() %></option>
                               <% } %>
                           </select><br>
                           
                           <label for="productQuantity">Quantità:</label>
                           <input type="number" id="productQuantity" name="productQuantity" value="<%= product.getQuantity() %>" required><br>
                           
                           <label for="productDescription">Descrizione:</label>
                           <textarea id="productDescription" name="productDescription" required><%= product.getDescription() %></textarea><br>

                           <button type="button" onclick="updateProduct(<%= product.getId() %>)">Salva Modifiche</button>
                       </form>
                   <% } else { %>
                       <p>Prodotto non trovato.</p>
                   <% }
               } else { %>
                   <p>Parametro ID del prodotto non specificato.</p>
               <% } %>
        </section>
    </main>
</body>
</html>
