<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/cart.css">
</head>
<body>

	<%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/guestUserbar.jsp" %>
	<%@ include file="templates/presentationBg.jsp" %>
    
    <main onclick="closeAll()">
        <div id="cartContainer">
            
            <section id="productsContainer">
                <h1>Prodotti nel carrello</h1><br>
                
                <div class="product">
                    <a href="#"><img src="images/prodotto1.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs rdgrd rdgrd rdgrdgd rdgrdg drgrdgdrgrdg rdgrdgrdg rdgrdgrdg</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="images/prodotto4.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="images/prodotto5.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="images/prodotto7.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="images/prodotto9.jpg"></a>
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
                <button id="back" onclick="goBack()">Continua gli acquisti</button>
                
                
            </section>
        </div>

    </main>

    <%@ include file="templates/footer.jsp" %>
    
</body>
</html>