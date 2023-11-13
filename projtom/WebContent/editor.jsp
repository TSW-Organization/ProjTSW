<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="it.unisa.bean.Product" %>
<%@ page import="it.unisa.dao.ProductDAO" %>
<%@ page import="it.unisa.bean.Category" %>


<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html"%>
    <link rel="stylesheet" type="text/css" href="styles/editor.css">
    <script type="text/javascript" src="scripts/productScript.js"></script>
</head>
<body>
    <header>
        <%@ include file="templates/header.jsp"%>
        <%@ include file="templates/sidebar.jsp"%>
        <%@ include file="templates/userbar.jsp"%>
    </header>


    <main class="admin-content">
        <h1>Gestione Prodotti</h1>

        <section class="admin-section">
    <h2>Aggiungi Prodotto</h2>
    <form id="addProductForm">
        Nome: <input type="text" id="productName" name="productName" required><br>
        Prezzo: <input type="number" id="productPrice" name="productPrice" step="0.01" required><br>
        Venditore: <input type="text" id="productSeller" name="productSeller" required><br>
        Categoria:
        <select id="productCategory" name="productCategory" required>
            <% for (Category category : Category.values()) { %>
            <% } %>
        </select><br>
        Quantità: <input type="number" id="productQuantity" name="productQuantity" required><br>
        Descrizione: <textarea id="productDescription" name="productDescription" required></textarea><br>

        <button type="button" onclick="addProduct()">Aggiungi Prodotto</button>
    </form>
</section>

  
<section class="admin-section">
    <h2>Elenco Prodotti per l'Editor</h2>
    
    <table class="product-table">
        <!-- Intestazione tabella -->
        <thead>
            <tr>
                <th>ID Prodotto</th>
                <th>Nome</th>
                <th>Prezzo</th>
                <th>Venditore</th>
                <th>Modifica</th> <!-- Nuova colonna per il pulsante di modifica -->
                
                <!-- Altre colonne secondo necessità -->
            </tr>
        </thead>
        
        <!-- Corpo tabella -->
        <tbody id="editorProductTableBody">
            <!-- Questo spazio verrà popolato dinamicamente con Ajax -->
        </tbody>
    </table>
    
    <!-- Controlli di navigazione pagine -->
    <div class="pagination">
        <button onclick="loadEditorProducts(1)"><<</button>
        <button onclick="loadEditorProducts(currentPage - 1)"><</button>
        <span id="editorCurrentPage">1</span>
        <button onclick="loadEditorProducts(currentPage + 1)">></button>
        <button onclick="loadEditorProducts(totalPages)">>></button>
    </div>
</section>

    </main>

    <footer>
        <%@ include file="templates/footer.jsp"%>
    </footer>
</body>
</html>
