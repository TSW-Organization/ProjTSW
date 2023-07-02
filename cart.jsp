<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>WorldCrafters</title>
        <link rel="stylesheet" href="font-awesome/css/all.css">
        <link rel="stylesheet" href="css/flickity.min.css">
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/sidebar.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <link rel="stylesheet" type="text/css" href="css/cart.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/flickity.pkgd.min.js"></script>
    </head>
<body>

    <jsp:include page="templates/header.jsp"/>

    <jsp:include page="templates/sidebar.jsp"/>

    <div id="userbar">
        <ul>
            <li><a href="#">Arte</a></li><br>
            <li><a href="#">Abbigliamento</a></li><br>
            <li><a href="#">Gioielli e accessori</a></li><br>
            <li><a href="#">Intrattenimento</a></li><br>
            <li><a href="#">Casa e arredi</a></li></li><br>
            <li><a href="#">Oggetti da collezione</a></li><br>
        </ul>
    </div>

    <main onclick="closeAll()">
        
        <div id="background"></div>
        
        <div id="productsContainer">
            
            <section id="cart">
                <h1>Prodotti nel carrello</h1><br>
                
                <div class="product">
                    <a href="#"><img src="img/prodotto1.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs rdgrd rdgrd rdgrdgd rdgrdg drgrdgdrgrdg rdgrdgrdg rdgrdgrdg</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="img/prodotto4.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="img/prodotto5.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="img/prodotto7.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
                <div class="product">
                    <a href="#"><img src="img/prodotto9.jpg"></a>
                    <p class="product-title">Lampade fesf esesfrgs  sergrse rsegrs</p>
                    <p class="product-price">$ 9.99</p>
                    <a onclick="" class="remove"><i class="fa fa-close fa-xl"></i></a>
                </div>
    
    
            </section>
    
            <section id="paymentContainer">
                <h1>Resoconto</h1><br>
    
                <div class="list">
                    <div id="productsList">
                        <h4>Prodotti</h4><br>
                        <p>sfesdfsefes</p>
                        <p>sfesdfsefes</p>
                        <p>sfesdfsefes</p>
                        <p>sfesdfsefes</p>
                        <p>sfesdfsefes</p>
                        <br>
                        <p>Spedizione</p>
                    </div>
                    <div id="priceList">
                        <h4>Prezzo</h4><br>
                        <p>$ 9.99</p>
                        <p>$ 9.99</p>
                        <p>$ 9.99</p>
                        <p>$ 9.99</p>
                        <p>$ 9.99</p>
                        <br>
                        <p>$ 5.00</p>
                    </div>
                </div>
                
                <div class="list">
                    <strong>Totale:</strong>
                    <strong>$ 34.97</strong>
                </div>
                
                <br>
                <a id="checkout" href="#"><h2>Vai al checkout</h2></a>
    
            </section>
        </div>

    </main>

    <jsp:include page="templates/footer.jsp"/>

    
    <script src="js/cart.js"></script>
    
</body>
</html>