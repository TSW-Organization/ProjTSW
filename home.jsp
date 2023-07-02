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
        <link rel="stylesheet" type="text/css" href="css/home.css">
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
        <div id="presentationContainer">
            <p>Fatti ispirare dalle tradizioni <br>artigianali di tutto <br>il mondo</p>
        </div>

        <div id="showcaseContainer">
            <h1>Prodotti in evidenza</h1><br>
            <div id="showcase">
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto1.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto2.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto3.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto4.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto5.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto6.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto7.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto8.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto9.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto10.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto1.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto2.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto3.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto4.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto5.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto6.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto7.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
                <div class="product" href="#">
                    <a href="#">
                        <img src="img/prodotto8.jpg">
                        <p class="product-title">Lampade luminose srgs  sergrse rsegrs</p>
                        <p class="product-price">$ 9.99</p>
                    </a>
                    <p onclick="" class="add-to-cart">Aggiungi al carrello</p>
                </div>
            </div>
        </div>
 
    </main>

    <jsp:include page="templates/footer.jsp"/>


    <script src="js/home.js"></script>
    
</body>
</html>