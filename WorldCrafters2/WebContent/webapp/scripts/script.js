// FUNZIONE PER SIDEBAR CATEGORIE
var sidebarOpen = false;
function toggleSidebar() {
    var sidebar = document.getElementById("sidebar");
    var main = document.getElementsByTagName("main")[0];
    var footer = document.getElementsByTagName("footer")[0];
    var body = document.getElementsByTagName("body")[0];

    if(sidebarOpen==false) {
        sidebar.style.left = "0px";
        sidebar.style.transition = "left 600ms";
        main.style.opacity = "0.8";
        footer.style.opacity = "0.8";
        sidebarOpen = true;
        body.classList.add("sidebar-open");
    }
    else {
        sidebar.style.left = "-400px";
        sidebar.style.transition = "left 600ms";
        main.style.opacity = "1";
        footer.style.opacity = "1";
        sidebarOpen=false;
        body.classList.remove("sidebar-open");
    }  
}

// FUNZIONE PER USERBAR
var userbarOpen = false;
function toggleUserbar() {
    var userbar = document.getElementById("userbar");
    var body = document.getElementsByTagName("body")[0];

    if(userbarOpen==false) {
        userbar.style.display = "block";
        userbar.style.opacity = "1";
        userbarOpen = true;
        body.classList.add("userbar-open");
    }
    else {
        userbar.style.opacity = "0";
        userbar.style.display = "none";
        userbarOpen=false;
        body.classList.remove("userbar-open");
    }  
}


// FUNZIONE CHE CHIUDE TUTTE LE SIDEBAR
function closeAll() {

    if(sidebarOpen==true) {
        toggleSidebar();
    }
    
    if(userbarOpen==true) {
        toggleUserbar();
    }
}


// CREAZIONE CAROUSEL
var elem = document.querySelector('.main-carousel');
var flkty = new Flickity( elem, {
  // options
  cellAlign: 'center',
  contain: true,
  wrapAround: true
});
//FUNZIONE PER FINESTRA DI LOGIN
  // Funzione per aprire la finestra modale e caricare la login.jsp
function openModal(modalId, pageUrl) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block";
  
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            modal.innerHTML = xhr.responseText;
        }
    };
    xhr.open("GET", pageUrl, true);
    xhr.send();
}

// Funzione per chiudere la finestra modale
function closeModal() {
    var modals = document.getElementsByClassName("modal");
    for (var i = 0; i < modals.length; i++) {
        modals[i].style.display = "none";
    }
}
 // Funzione per gestire l'evento di clic sul pulsante "Add to cart"
function addToCartClicked(event) {
  const button = event.target;
  const productId = button.getAttribute('data-product-id');
  const productName = button.getAttribute('data-product-name');
  const productPrice = parseFloat(button.getAttribute('data-product-price'));

  // Ora puoi utilizzare queste informazioni per inviare una richiesta AJAX al server
  // per aggiungere il prodotto al carrello o fare qualsiasi altra operazione desiderata

  // Esempio: Invia il prodotto al carrello tramite una richiesta AJAX
  const data = {
    productId: productId,
    productName: productName,
    productPrice: productPrice
  };

  fetch('/add-to-cart', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(response => response.text())
  .then(message => {
    // La risposta dal server può essere utilizzata per fornire un feedback all'utente
    console.log(message);
  })
  .catch(error => {
    console.error('Errore durante l\'aggiunta al carrello:', error);
  });
}

// Aggiungi un gestore di eventi clic per catturare il clic sul pulsante "Add to cart"
const addToCartButtons = document.querySelectorAll('.add-to-cart');
addToCartButtons.forEach(button => {
  button.addEventListener('click', addToCartClicked);
});
