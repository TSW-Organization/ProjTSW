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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException se) {
			se.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    String surname = request.getParameter("surname");
	    String email = request.getParameter("email");
	    String subject = request.getParameter("subject");
	    String message = request.getParameter("message");
	    String error = "";

	    error += validateField(name, "name", "Inserisci nome", "^[a-zA-Z\\s]+$", request);
	    error += validateField(surname, "surname", "Inserisci cognome", "^[a-zA-Z\\s]+$", request);
	    error += validateEmail(email, request);
	    error += validateField(subject, "subject", "Seleziona un motivo dall'elenco", null, request);
	    error += validateField(message, "message", "Inserisci messaggio", null, request);

	    if (!error.isEmpty()) {
	        request.setAttribute("error", error);
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
	        try {
	        	dispatcher.forward(request, response);
	        } catch (ServletException se) {
	        	se.printStackTrace();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } 
	    } else {
	        try {
	            response.sendRedirect("contact-success.jsp");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private String validateField(String value, String attributeName, String errorMessage, String regex, HttpServletRequest request) {
	    
		String error = "";
		if (value == null || value.trim().isEmpty() || (regex != null && !value.matches(regex))) {
	        error = errorMessage + "<br>";
	    } else {
	        request.setAttribute(attributeName, value);
	    }
		return error;
	}

	private String validateEmail(String email, HttpServletRequest request) {
	    	
		String error = "";
		if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
	        error += "Inserisci email valida<br>";
	    } else {
	        request.setAttribute("email", email);
	    }
		return error;
	}

}
