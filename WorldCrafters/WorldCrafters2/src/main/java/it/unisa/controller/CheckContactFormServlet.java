package it.unisa.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckContactForm")
public class CheckContactFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Ottenere i valori dei campi del modulo
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        String error = ""; 
        
        if (name == null || name.trim().equals("") || !name.matches("^[a-zA-Z\\s]+$")) {
			error += "Inserisci nome<br>";
		} else {
			request.setAttribute("name", name);
		}

		if (surname == null || surname.trim().equals("") || !surname.matches("^[a-zA-Z\\s]+$")) {
			error += "Inserisci cognome<br>";
		} else {
			request.setAttribute("surname", surname);
		}
		
		if (!isValidEmail(email)) {
			error += "Inserisci email valida<br>";
		} else {
			request.setAttribute("email", email);
		}
		
		if (subject==null || subject.isEmpty()) {
            error += "Seleziona un motivo dall'elenco<br>";
        } else {
			request.setAttribute("subject", subject);
		}
		
		if (message == null || message.trim().equals("")) {
			error += "Inserisci messaggio<br>";
		} else {
			request.setAttribute("message", message);
		}

		if (!error.equals("")) {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
			dispatcher.forward(request, response);
		} else {
			// I campi sono validi, puoi inviare i dati al server
            // Aggiungi qui la logica per elaborare i dati inviati dal modulo

            response.sendRedirect("contact-success.jsp");
		}
	}

    // Verifica se l'indirizzo email è valido utilizzando una semplice espressione regolare
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
}
