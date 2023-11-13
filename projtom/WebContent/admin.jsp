<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="it.unisa.bean.Product"%>
<%@ page import="it.unisa.bean.Admin"%>

<!DOCTYPE html>
<html lang="it">
<head>
<%@ include file="templates/head.html"%>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<link rel="stylesheet" type="text/css" href="styles/home.css">
<link rel="stylesheet" type="text/css" href="styles/log-reg.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script type="text/javascript" src="scripts/script.js"></script>

</head>
<body>
	<header>
		<%@ include file="templates/header.jsp"%>
		<%@ include file="templates/sidebar.jsp"%>
		<%@ include file="templates/userbar.jsp"%>
	</header>
	<main class="admin-content">
 <h1>Area Amministratore</h1>
 <h1 class="welcome-message">
    <%
        it.unisa.bean.Admin admin = (it.unisa.bean.Admin) session.getAttribute("admin");
        if (admin != null) {
            out.println("<p>Bentornato, " + admin.getFirstName() + "!</p>");
        }
    %>
</h1>
 
   <div class="welcome-message">
   </div>		<section class="admin-section">
			<h2>Ordini</h2>
			<!-- Modifica il pulsante nella tua admin.jsp -->
			<button onclick="location.href='orders'">Visualizza Tutti gli Ordini</button>

		</section>

<section class="admin-section">
    <h2>Gestione Prodotti</h2>
    <button onclick="location.href='editor.jsp'">Visualizza Prodotti</button>
</section>

<section class="admin-section">
    <h2>Statistiche di Vendita Mensili</h2>
    <canvas id="salesChart" width="400" height="200"></canvas>
</section>

	</main>
	<footer>
		<%@ include file="templates/footer.jsp"%>
	</footer>
</body>
</html>
