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
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles/cart.css">
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
        
        <div id="background"></div>
        
        <div id="cartContainer">
            
            <section id="productsContainer">
                <h1>Prodotti nel carrello</h1><br>
                
                <div class="product">
                    <a href="#"><img src="imgs/prodotto1.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs rdgrd rdgrd rdgrdgd rdgrdg drgrdgdrgrdg rdgrdgrdg rdgrdgrdg</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="imgs/prodotto4.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="imgs/prodotto5.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="imgs/prodotto7.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="imgs/prodotto9.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
    
            </section>
    
            <section id="paymentContainer">
                <h1>Resoconto</h1>
    
                <div class="list">
                    
                    <div class="product">
                    	<h4 class="product-title">Prodotto</h4>
                    	<h4>Prezzo</h4>
                    </div>
                    	
					<div class="product">
						<p class="product-title">Lampade fesf esesfrgs  rdgrdg rdgdrgrd sergrse rsegrs</p>
						<p>$ 9.99</p>
					</div>
					<div class="product">
						<p class="product-title">Lampade fesf esesfrgs  rdgrdg rdgdrgrd sergrse rsegrs</p>
						<p>$ 9.99</p>
					</div>
					<div class="product">
						<p class="product-title">Lampade fesf esesfrgs  rdgrdg rdgdrgrd sergrse rsegrs</p>
						<p>$ 9.99</p>
					</div>
					<div class="product">
						<p class="product-title">Lampade fesf esesfrgs  rdgrdg rdgdrgrd sergrse rsegrs</p>
						<p>$ 9.99</p>
					</div>
					<div class="product">
						<p class="product-title">Lampade fesf esesfrgs  rdgrdg rdgdrgrd sergrse rsegrs</p>
						<p>$ 9.99</p>
					</div>
					<br/>
					<div class="product">
						<p class="product-title">Spedizione</p>
						<p>$ 5.00</p>
					</div>

                </div>
                
                <br/>
                
                <div id="total">
                    <strong>Totale:</strong>
                    <strong>$ 34.97</strong>
                </div>
                
                <br>
	            <a id="checkout" href="#">Vai al checkout</a>
                <br><br>
                <a id="back" onclick="goBack()">Continua gli acquisti</a>
                
                
            </section>
        </div>

    </main>

    <%@ include file="footer.jsp" %>
    
    <script src="scripts/script.js"></script>
    <script src="scripts/cart.js"></script>
    
</body>
</html>