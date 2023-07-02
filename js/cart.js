// FUNZIONE PER SIDEBAR CATEGORIE
var sidebarOpen = false;
function toggleSidebar() {
    var sidebar = document.getElementById("sidebar");
    var main = document.getElementsByTagName("main")[0];
    var footer = document.getElementsByTagName("footer")[0];

    if(sidebarOpen==false) {
        sidebar.style.left = "0px";
        sidebar.style.transition = "left 600ms";
        main.style.opacity = "0.8";
        footer.style.opacity = "0.8";
        sidebarOpen = true;
    }
    else {
        sidebar.style.left = "-400px";
        sidebar.style.transition = "left 600ms";
        main.style.opacity = "1";
        footer.style.opacity = "1";
        sidebarOpen=false;
    }  
}

// FUNZIONE PER USERBAR
var userbarOpen = false;
function toggleUserbar() {
    var userbar = document.getElementById("userbar");

    if(userbarOpen==false) {
        userbar.style.right = "0px";
        userbar.style.transition = "right 600ms";
        userbarOpen = true;
    }
    else {
        userbar.style.right = "-300px";
        userbar.style.transition = "right 600ms";
        userbarOpen=false;
    }  
}


// FUNZIONE CHE CHIUDE TUTTE LE SIDEBAR
function closeAll() {
    var sidebar = document.getElementById("sidebar");
    var userbar = document.getElementById("userbar");
    var main = document.getElementsByTagName("main")[0];
    var footer = document.getElementsByTagName("footer")[0];
    
    if(sidebarOpen==true) {
        sidebar.style.left = "-400px";
        sidebar.style.transition = "left 600ms";
        sidebarOpen=false;
        main.style.opacity = "1";
        footer.style.opacity = "1";
    }
    
    if(userbarOpen==true) {
        userbar.style.right = "-300px";
        userbar.style.transition = "right 600ms";
        userbarOpen=false;
    }
}


// CREAZIONE CAROUSEL
var elem = document.querySelector('.main-carousel');
var flkty = new Flickity( elem, {
  // options
  cellAlign: 'left',
  contain: true
});