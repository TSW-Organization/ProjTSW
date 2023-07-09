<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
   	request.setAttribute("showHeader", true);
	request.setAttribute("showFooter", true);
	request.setAttribute("showSidebar", true);
%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorldCrafters</title>
    <link rel="stylesheet" type="text/css" href="styles/home.css">
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/all.css">
    <script src="vendor/jquery.min.js"></script>
    <script src="vendor/flickity.pkgd.min.js"></script>
</head>
<body>
    
    <%@ include file="header.jsp" %>
    <%@ include file="sidebar.jsp" %>
    
    <div id="userbar">
        <ul>
            <li><a href="#">Accedi<br></a></li>
            <li><a href="#">Registrati<br></a></li>
            <li><a href="contact.jsp">Assistenza<br></a></li>
        </ul>
    </div>
    
    <main onclick="closeAll()">
        
        
        <div id="presentationContainer">
            <p>Fatti ispirare dalle tradizioni<br>artigianali di tutto<br>il mondo</p>
        </div>
    	
        <div id="showcaseContainer">
            <h1>Prodotti in evidenza</h1><br>
            <div id="showcase"> 
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto1.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto2.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto3.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto4.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto5.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto6.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto7.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto8.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto9.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto10.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto1.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto2.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto3.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto4.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto5.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto6.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto7.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
	            <div class="product">
	                <a href="#"><img src="imgs/prodotto8.jpg"></a>
	                <a href="#" class="product-title">Lampade luminose srgs  sergrse rsegrs</a>
	                <p class="product-price">$ 9.99</p>
	                <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
	            </div>
       
            </div>
        </div>
        
    </main>
    
	<%@ include file="footer.jsp" %>

    <script src="scripts/script.js"></script>
    
</body>
</html>