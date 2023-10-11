function openOverlay(overlayId, pageName) {
  var overlay = document.getElementById(overlayId);
  overlay.style.display = "block";

  // Carica il contenuto della pagina specificata nell'elemento overlay-content dell'overlay corrispondente tramite AJAX
  var overlayContent = document.getElementById(overlayId + "-content"); // Usiamo overlayId per ottenere il corretto elemento overlay-content
  var xhr = new XMLHttpRequest();
  xhr.open("GET", pageName, true);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      overlayContent.innerHTML = xhr.responseText;
    }
  };
  xhr.send();
}

// Chiudere l'overlay specifico
function closeOverlay(overlayId) {
  var overlay = document.getElementById(overlayId);
  overlay.style.display = "none";
}

