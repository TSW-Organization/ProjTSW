package it.unisa.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.DAO.UserDAO;
import it.unisa.bean.User;
import it.unisa.utils.DriverManagerConnectionPool;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        if (userDAO.isEmailRegistered(email)) {
            request.setAttribute("emailError", "L'email è già in uso");
            request.setAttribute("redirectCode", 0);  // Codice 0 per errore
            request.setAttribute("redirectURL", "login.jsp");
        } else {
            String hashedPassword = hashPassword(password);
            int userID = userDAO.registerUser(firstName, lastName, email, hashedPassword);
            request.setAttribute("redirectCode", 1);  // Codice 1 per successo
            request.setAttribute("redirectURL", "login.jsp");
        }

        // Esegue il reindirizzamento dalla servlet
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

	private String hashPassword(String password) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashedBytes = md.digest(password.getBytes());

	        StringBuilder result = new StringBuilder();
	        for (byte b : hashedBytes) {
	            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
	        }

	        return result.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        return null;
	    }
	   
	} 
	}
