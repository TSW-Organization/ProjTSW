package it.unisa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.DAO.UserDAO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        int userId;
        
        // Effettua la logica di autenticazione nel database e restituisce true se le credenziali sono corrette
        UserDAO userDAO = new UserDAO();
           
		userId = userDAO.authenticate(email, password);
		
        
        if (userId != -1) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            response.sendRedirect("home");
        } else {
        	HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
        	response.sendRedirect("login.jsp"); // Reindirizza alla pagina di login con un messaggio di errore
        }
    }
    
}