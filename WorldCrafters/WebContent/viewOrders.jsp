<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="it.unisa.bean.Purchase"%>
<%@ page import="it.unisa.dao.PurchaseDAO"%>

<!DOCTYPE html>
<html lang="it">
<head>
<%@ include file="templates/head.html"%>
<link rel="stylesheet" type="text/css" href="styles/viewOrders.css">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<link rel="stylesheet" type="text/css" href="styles/viewOrders.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="scripts/script.js"></script>
</head>
<body>
	<header>
		<%@ include file="templates/header.jsp"%>
		<%@ include file="templates/sidebar.jsp"%>
		<%@ include file="templates/userbar.jsp"%>
	</header>

	<main class="admin-content">
		<h1>Visualizza Ordini</h1>

		<section class="admin-section">
			<table class="order-table">
				<thead>
					<tr>
						<th>ID Ordine</th>
						<th>Data</th>
						<th>Nome cliente</th>
						<th>Importo</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<%
					PurchaseDAO purchaseDAO = new PurchaseDAO();
					List<Purchase> purchases = purchaseDAO.getAllPurchases();
					for (Purchase purchase : purchases) {
					%>
					<tr>
						<td><%=purchase.getId()%></td>
						<td><%=purchase.getDate()%></td>
						<td><%=purchase.getFullName()%></td>
						<td><%=purchase.getAmount()%></td>
						<td>
 <%
        String statusName = purchase.getStatus().name();
        %>
<select class="status-dropdown"
        name="selectedStatus_<%=purchase.getId()%>"
        onchange="updateStatus(<%=purchase.getId()%>, this.value)">
    <option value="ATTESA" <%=statusName.equals("ATTESA") ? "selected" : ""%>>Attesa</option>
    <option value="CONSEGNATO" <%=statusName.equals("CONSEGNATO") ? "selected" : ""%>>Consegnato</option>
    <option value="SPEDITO" <%=statusName.equals("SPEDITO") ? "selected" : ""%>>Spedito</option>
    <option value="ANNULLATO" <%=statusName.equals("ANNULLATO") ? "selected" : ""%>>Annullato</option>
</select>

						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
		</section>
	</main>

	<footer>
		<%@ include file="templates/footer.jsp"%>
	</footer>
</body>
</html>
