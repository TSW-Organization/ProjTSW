package it.unisa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.DAO.AdminDAO;
import it.unisa.DAO.UserDAO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        int userId;
        String error = "";
        UserDAO userDAO = new UserDAO();
        AdminDAO adminDAO = new AdminDAO();
        	
		//Se è admin
        if(adminDAO.authenticateEmail(email)==true) {
			
        	request.setAttribute("email", email);
        	if(adminDAO.authenticate(email, password)==true) {
        		HttpSession oldSession = request.getSession(false);
	            if(oldSession != null) {
	            	oldSession.invalidate();
	            }
	            
	            HttpSession session = request.getSession();
	            session.setAttribute("isAdmin", true);
	            //session.setMaxInactiveInterval(5*60);  //imposta tempo inattività a 60 minuti

	            response.sendRedirect("home");
        	} else {
        		error += "Password errata<br>";
        		request.setAttribute("error", error);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
        	}

		
		//Se è user
		} else {
			
			if (!isValidEmail(email)) {
				error += "Inserisci email valida<br>";
			} else if(userDAO.authenticateEmail(email)==false){	
				error += "Email inesistente<br>";
			} else {
				request.setAttribute("email", email);
			}
			
			if (!error.equals("")) {
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			} else {
				// I campi sono validi, puoi inviare i dati al server
	            // Aggiungi qui la logica per elaborare i dati inviati dal modulo

				// Effettua la logica di autenticazione nel database e restituisce true se le credenziali sono corrette
		           
				userId = userDAO.authenticate(email,password);
				
		        
		        if (userId != -1) {
		            HttpSession oldSession = request.getSession(false);
		            if(oldSession != null) {
		            	oldSession.invalidate();
		            }
		            
		            HttpSession session = request.getSession();
		            session.setAttribute("userId", userId);
		            //session.setMaxInactiveInterval(5*60);  //imposta tempo inattività a 60 minuti

		            response.sendRedirect("home");
		        } else {
		        	
		        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response); // Reindirizza alla pagina di login con un messaggio di errore
		        }
			}
		}

    }
	
	// Verifica se l'indirizzo email è valido utilizzando una semplice espressione regolare
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
    
}