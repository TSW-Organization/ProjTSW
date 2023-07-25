// CART
function goBack() {
    var previousPage = document.referrer;
    window.location.href = previousPage; // Imposta l'URL della pagina precedente come destinazione
}



//AGGIUNTA DEI PRODOTTI AL CARRELLO
function addToCart() {
    
    var urlParams = new URLSearchParams(window.location.search);
	var productId = urlParams.get('id');
    
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

function updateCart() {
    $.ajax({
        type: "GET",
        url: "get-cart",
        dataType: "json",
        success: function(response) {
            
            var cartItems = response;

            // Ora puoi utilizzare cartItems per aggiornare il contenuto del carrello nel DOM
            var cartList = $("#cartList");
            
            cartList.empty();
            if (cartItems.length > 0) {
                $.each(cartItems, function(index, item) {
                    cartList.append("<img style=\"width: 100px;\" src=\" " + item.imgSrc + " \" </img>");
                    cartList.append("<p>" + item.name + "</p>");
                    cartList.append("<p>" + item.price + "</p>");
                });
            } else {
                cartList.append("<p>Il carrello è vuoto</p>");
            }
        },
        error: function(xhr, status, error) {
            console.log("Errore durante il recupero dei prodotti dal carrello: " + error);
        }
    });
}

$(document).ready(function() {
    // Chiama la funzione updateCart quando il documento è pronto
    updateCart();
});