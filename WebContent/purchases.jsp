<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
    <%@ include file="templates/guestUserbar.jsp" %>
    
    <div id="presentationContainer" onclick="closeAll()">
    	<%@ include file="templates/presentationBg.jsp" %>
    </div>
    
    <main onclick="closeAll()">
	
		<h1>Ordini effettuati</h1>
		
		<div id="ordersContainer">
			<div id="ordersList">
				<!-- Creare tanti cart-list-item quanti sono gli ordini nel database orders con id utente della sessione corrente -->
				<div class="cart-list-item">
                	<img src=""><!--immagine primo prodotto nel database order-->
                	<a>id</a>
                    <p>data</p>
                    <p>€ prezzo</p>
                    <p>quantità prodotti</p>
				</div>
			</div>
		</div>
	
	
        
    </main>
    
    <%@ include file="templates/footer.jsp" %>
    
</body>
</html>