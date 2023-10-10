<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="it.unisa.bean.Purchase" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/purchases.css">
    <script src="scripts/purchases.js"></script>
</head>
<body>
    
    <%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/userbar.jsp" %>
    
    <div id="presentationContainer" onclick="closeAll()">
    	<%@ include file="templates/presentationBg.jsp" %>
    </div>
    
    <main onclick="closeAll()">
	
		<div id="purchasesContainer">
			
			<h1>Ordini effettuati</h1>
			
			<div id="purchasesList">
				<!-- Creare tanti cart-list-item quanti sono gli ordini nel database orders con id utente della sessione corrente -->
                	
				<% @SuppressWarnings("unchecked")
				List<Purchase> purchases = (List<Purchase>) request.getAttribute("purchases"); %>
				<% if(purchases.size()!=0) { %>
					<% for (int i = 0; i < purchases.size(); i++) { %>
						<% Purchase purchase = purchases.get(i); %>
						<div class="purchase">
					    
					    	<% SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy"); %>
					    	<% String date = sdfDate.format(purchase.getDate()); %>
					    	<% SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm"); %>
					    	<% String time = sdfTime.format(purchase.getTime()); %>
					    	<% SimpleDateFormat sdfEstimatedDate = new SimpleDateFormat("dd/MM/yyyy"); %>
					    	<% String estimatedDate = null; %>
					    	
					    	<% Object estimatedDateObj = purchase.getEstimatedDate(); %>
					    	<% if(estimatedDateObj!=null) { %>
					    		<% estimatedDate = sdfEstimatedDate.format(purchase.getEstimatedDate()); %>
					    	<% } %>
					
					
					    	<p>Ordine con id <%= purchase.getId() %> effettuato in data <%= date %> alle ore <%= time %></p>
					    	<p>Spesa: € <%= String.format("%.2f", purchase.getAmount()) %></p>
					    	<p>Stato:  <%= purchase.getStatus() %></p>
					    	<a href="contact.jsp">Richiedi assistenza</a>
					    	
					    	<% if(estimatedDateObj!=null) { %>
					    		<p>Data di consegna stimata: <%= estimatedDate %></p>
					    	<% } %>
					    	
					    	<% String status = purchase.getStatus().toString(); %>
					    	<% if(status!="consegnato" && status!="annullato") { %>
					    		<p>Annulla ordine</p>
					    	<% } %>
					    	
					    </div>
					    <br>
					<% } %>
				<% } else { %>
			    	<div id="noPurchase">
                    	<p>Nessun ordine effettuato</p>
                    </div>
				<% } %>

			</div>
		</div>
    
    </main>
    
    <%@ include file="templates/footer.jsp" %>
    
</body>
</html>