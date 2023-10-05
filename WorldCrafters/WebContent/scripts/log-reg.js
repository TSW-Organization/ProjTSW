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
/*
function closeModal() {
	var modal = document.getElementsByClassName("modal-overlay")[0];
	modal.style.display = "none";
}

function closeModal() {
  	var modal = document.getElementById("loginModal");
  	modal.style.display = "none";
}
*/