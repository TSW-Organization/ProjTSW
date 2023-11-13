//script per validazione password
function validateForm() {
	const password = document.getElementById('password').value;
	const confirmPassword = document.getElementById('confirm-password').value;

	if (password !== confirmPassword) {
		document.getElementById('password-error').innerText = 'Le password non corrispondono.';
		return false;
	} else {
		document.getElementById('password-error').innerText = '';
	}

	if (!validatePassword(password)) {
		document.getElementById('password-error').innerText = 'La password non rispetta i criteri di complessità.';
		return false;
	} else {
		document.getElementById('password-error').innerText = '';
	}

	return true;
}

//script per visibilità
function togglePasswordVisibility(inputId) {
	const passwordInput = document.getElementById(inputId);
	const passwordToggle = document.querySelector(`#${inputId} + .password-toggle img`);

	if (passwordInput.type === "password") {
		passwordInput.type = "text";
		passwordToggle.src = "images/show.png";
	} else {
		passwordInput.type = "password";
		passwordToggle.src = "images/hide.png";
	}
}

//script per limitare le password
function validatePassword(password) {
	// La password deve avere almeno 8 caratteri
	if (password.length < 8) {
		return false;
	}

	// La password deve contenere almeno una lettera maiuscola
	if (!/[A-Z]/.test(password)) {
		return false;
	}

	// La password deve contenere almeno un numero
	if (!/\d/.test(password)) {
		return false;
	}

	// Altrimenti, la password è valida
	return true;
}
//finestra di stato dropdown
function updateStatus(purchaseId, newStatus) {
    if (confirm("Sei sicuro di voler cambiare lo stato?")) {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "updateStatus", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Aggiorna solo la cella dello stato senza ricaricare la pagina
                var statusCell = document.getElementById("status-" + purchaseId);
                if (statusCell) {
                    statusCell.innerText = newStatus;
                }

                // Store the selected status in localStorage
                localStorage.setItem("selectedStatus_" + purchaseId, newStatus);

                // Se il nuovo stato è "Spedito", aggiorna la data stimata nel database
                if (newStatus === "SPEDITO") {
                    updateEstimatedDate(purchaseId);
                }
            }
        };
        xhr.send("purchaseId=" + purchaseId + "&newStatus=" + newStatus);
    }
}

// Aggiungi questa funzione per aggiornare la data stimata
function updateEstimatedDate(purchaseId) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "updateEstimatedDate", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Puoi gestire la risposta, se necessario
        }
    };
    xhr.send("purchaseId=" + purchaseId);
}

//script.js
document.addEventListener("DOMContentLoaded", function() {
    // Dati di esempio per il grafico (puoi sostituire con i tuoi dati reali)
    var salesData = {
        labels: ["Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno"],
        datasets: [{
            label: 'Vendite Mensili',
            data: [12, 19, 3, 5, 2, 3], // Sostituisci con i dati reali
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1
        }]
    };

    // Configurazione del grafico
    var salesChartConfig = {
        type: 'bar', // Puoi cambiare il tipo di grafico (bar, line, pie, etc.)
        data: salesData,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    };

    // Ottenere il contesto del canvas e disegnare il grafico
    var salesChartCanvas = document.getElementById('salesChart').getContext('2d');
    new Chart(salesChartCanvas, salesChartConfig);
});
