<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/cart.css">
    <script src="scripts/cart.js"></script>
</head>
<body>

	<%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/guestUserbar.jsp" %>
	<%@ include file="templates/presentationBg.jsp" %>
    
     
    <h1>Carrello</h1>
    
    <div id="cartList">
    
    </div>
    
    
    
    

    <%@ include file="templates/footer.jsp" %>
    
</body>
</html>