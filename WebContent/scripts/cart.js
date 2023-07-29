// CART
function goBack() {
    var previousPage = document.referrer;
    window.location.href = previousPage; // Imposta l'URL della pagina precedente come destinazione
}


//AGGIUNTA E RIMOZIONE DEI PRODOTTI DEL CARRELLO
function addToCart(productId) {
    
    var quantityElement = document.getElementById("quantity");
    var selectedQuantity = quantityElement.value;
    
    $.ajax({
        type: "POST",
        url: "add-to-cart",
        data: { productId: productId, selectedQuantity: selectedQuantity },
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
        url: "update-cart",
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
                    	<strong class="product-quantity">Quantità</strong>
                    	<strong class="product-price">Prezzo</strong>
                    </div>   
                `;

                $.each(cartItems, function (index, item) {
                    
                    var priceForQuantity = item.price * item.selectedQuantity;
                    var maxOptions = Math.min(8, item.quantity);
                    
                    // Utilizza template string per creare l'HTML dinamico per cartList
                    listHtml += `
                        <div class="cart-list-item">
                            <img src="${item.imgSrc}" />
                            <p class="product-name">${item.name}</p>
                            <p class="product-price">€ ${item.price.toFixed(2)}</p>   
                            <select class="quantity" data-product-id="${item.id}">
                    `;
                    
                    for (var i = 1; i <= maxOptions; i++) {
				        if(i==item.selectedQuantity) {
							listHtml += `
                        		<option value=${i} selected>${i}</option>
                    		`;
						} else {
							listHtml += `
                        		<option value=${i}>${i}</option>
                    		`;
						}        
				    } 
                                    
                    listHtml += `   
                            </select>
                            <button onclick="removeFromCart('${item.id}')"><i class="fa fa-close fa-xl"></i></button><br>
                        </div>
                    `;


					
                    // Utilizza template string per creare l'HTML dinamico per cartPayment
                    paymentHtml += `
                        <div class="cart-payment-item">
                        	<p class="product-name">${item.name}</p>
                        	<p class="product-quantity">${item.selectedQuantity}</p>
                        	<p class="product-price">€ ${priceForQuantity.toFixed(2)}</p>
                        </div>   
                    `;
                    
                    //Aggiorna il totale del prezzo a ogni ciclo
                    totalPrice += priceForQuantity;
                    
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
    
     $(document).on("change", ".quantity", function () {
        var productId = $(this).data("product-id");
        var selectedQuantity = parseInt($(this).val()); // Converte il valore selezionato in un numero intero

        // Effettua una richiesta AJAX per aggiornare la quantità del prodotto nel carrello
        $.ajax({
            type: "POST",
            url: "add-to-cart", // Sostituisci "update-cart-item" con l'URL per aggiornare la quantità nel carrello lato server
            data: { productId: productId, selectedQuantity: selectedQuantity },
            success: function (response) {
                // Il carrello è stato aggiornato con successo, quindi aggiorna la visualizzazione del carrello
                updateCart();
            },
            error: function (xhr, status, error) {
                console.log("Errore durante l'aggiornamento del carrello: " + error);
            }
        });
    });
});