<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="it.unisa.bean.Purchase" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/orders.css">
    <script src="scripts/orders.js"></script>
</head>
<body>
    
    <%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/userbar.jsp" %>
    
    <div id="presentationContainer" onclick="closeAll()">
    	<%@ include file="templates/presentationBg.jsp" %>
    </div>
    
    <main onclick="closeAll()">
	
		<h1>Ordini effettuati</h1>
		
		<div id="purchasesContainer">
			<div id="purchasesList">
				<!-- Creare tanti cart-list-item quanti sono gli ordini nel database orders con id utente della sessione corrente -->
				<div class="purchase-list-item">
                	
                	<% @SuppressWarnings("unchecked")
                   	List<Purchase> purchases = (List<Purchase>) request.getAttribute("purchases"); %>
                   	<% if(purchases.size()!=0) { %>
					<% for (int i = 0; i < purchases.size(); i++) { %>
						<% Purchase purchase = purchases.get(i); %>
				        	<div class="purchase">
	                        
	                        	<p>Id = <%= purchase.getId() %></p>
	                        	<p>Date = <%= purchase.getDate() %></p>
	                        	<p>Amount = € <%= String.format("%.2f", purchase.getAmount()) %></p>
	                        
	                        </div>

						<%} %>
					<% } else {%>
							<div class="purchase">
	                        	<p>Non hai effettuato nessun ordine</p>
	                        </div>
					<% } %>

				</div>
			</div>
		</div>
    
    </main>
    
    <%@ include file="templates/footer.jsp" %>
    
</body>
</html>