// CART
function goBack() {
    var previousPage = document.referrer;
    window.location.href = previousPage; // Imposta l'URL della pagina precedente come destinazione
}


//AGGIUNTA E RIMOZIONE DEI PRODOTTI DEL CARRELLO
function addToCart(productId) {
    
    $.ajax({
        type: "POST",
        url: "add-to-cart",
        data: { productId: productId },
        success: function(response) {
            updateCart();
        },
        error: function(xhr, status, error) {
            console.log("Errore durante l'aggiunta al carrello: " + error);
        }
    });
}

function removeFromCart(productId) {
	
    $.ajax({
        type: "POST",
        url: "remove-from-cart",
        data: { productId: productId },
        success: function(response) {
            updateCart();
        },
        error: function(xhr, status, error) {
            console.log("Errore durante la rimozione dal carrello: " + error);
        }
    });
}

function updateCart() {
    $.ajax({
        type: "GET",
        url: "get-cart",
        dataType: "json",
        success: function(response) {
            
            var cartItems = response;

            // Ora puoi utilizzare cartItems per aggiornare il contenuto del carrello nel DOM
            var cartList = $("#cartList");
            var cartPayment = $("#cartPayment");
            var totalPrice = 0;

            cartList.empty();
            cartPayment.empty();

            if (cartItems.length > 0) {
                var listHtml = "";
                var paymentHtml = "<h2>Riepilogo</h2>";
                
                paymentHtml += `
                    <div class="cart-payment-item">
                    	<strong class="product-name">Prodotto</strong>
                    	<strong class="product-price">Prezzo</strong>
                    </div>   
                `;

                $.each(cartItems, function (index, item) {
                    // Utilizza template string per creare l'HTML dinamico per cartList
                    listHtml += `
                        <div class="cart-list-item">
                            <img src="${item.imgSrc}" />
                            <p class="product-name">${item.name}</p>
                            <p class="product-price">€ ${item.price.toFixed(2)}</p>
                            <button onclick="removeFromCart('${item.id}')"><i class="fa fa-close fa-xl"></i></button><br>
                        </div>
                    `;

                    // Utilizza template string per creare l'HTML dinamico per cartPayment
                    paymentHtml += `
                        <div class="cart-payment-item">
                        	<p class="product-name">${item.name}</p>
                        	<p class="product-price">€ ${item.price.toFixed(2)}</p>
                        </div>   
                    `;
                    
                    //Aggiorna il totale del prezzo a ogni ciclo
                    totalPrice += item.price;
                    
                });
                
                /*
                paymentHtml += `
                    <div class="cart-payment-item">
                    	<strong class="product-name">Spedizione</strong>
                    	<p class="product-price">€ 5.00</p>
                    </div>
                `;
                */
                
                paymentHtml += `
                    <br/>
                    <div class="cart-payment-item" id="total">
                    	<strong class="product-name">Totale</strong>
                    	<strong class="product-price">€ ${totalPrice.toFixed(2)}</strong>
                    </div>
                `;
                
                paymentHtml += `
                    <br>
		            <a id="checkout" href="#">Vai al checkout</a>
	                <br><br>
	                <button id="back" onclick="goBack()">Continua gli acquisti</button> 
                `;


                cartList.append(listHtml);
                cartPayment.append(paymentHtml);
            } else {
                cartList.append("<p>Il carrello è vuoto</p>");
            }
        },
        error: function (xhr, status, error) {
            console.log("Errore durante il recupero dei prodotti dal carrello: " + error);
        }
    });
}

$(document).ready(function() {
    // Chiama la funzione updateCart quando il documento è pronto
    updateCart();
});