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
  cellAlign: 'left',
  contain: true
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
