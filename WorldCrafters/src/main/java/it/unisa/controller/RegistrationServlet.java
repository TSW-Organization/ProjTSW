package it.unisa.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.DAO.AdminDAO;
import it.unisa.DAO.UserDAO;
import it.unisa.bean.User;
import it.unisa.utils.DriverManagerConnectionPool;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		UserDAO userDAO = new UserDAO();
		AdminDAO adminDAO = new AdminDAO();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String error = "";
        
        //Controllare che l'email non sia già presente in user o admin
		boolean userValid = userDAO.verifyEmail(email);
		boolean adminValid = adminDAO.verifyEmail(email);
		
		if(!(userValid && adminValid)) {
			error += "Email non disponibile<br>";
		}
        	
        if (firstName == null || firstName.trim().equals("") || !firstName.matches("^[a-zA-Z\\s]+$")) {
			error += "Inserisci nome valido<br>";
		} else {
			request.setAttribute("firstName", firstName);
		}

		if (lastName == null || lastName.trim().equals("") || !lastName.matches("^[a-zA-Z\\s]+$")) {
			error += "Inserisci cognome valido<br>";
		} else {
			request.setAttribute("lastName", lastName);
		}
        
        if (!isValidEmail(email)) {
			error += "Inserisci email valida<br>";
		} else {
			request.setAttribute("email", email);
		}
        
        if(!isValidPassword(password)) {
        	error += "La password deve contenere almeno 8 caratteri, una lettera maiuscola, una cifra e un simbolo<br>";
        } else {
        	if(!password.equals(confirmPassword)) {
            	error += "Le password non corrispondono<br>";
            }
        }
        
		if (!error.equals("")) {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
			dispatcher.forward(request, response);
		} else {

			//Dopo il controllo viene registrato in database
			userDAO.registerUser(firstName, lastName, email, password);
	        response.sendRedirect("login.jsp");
		
		}
		
    }
        

	//Verifica se l'indirizzo email è valido utilizzando una semplice espressione regolare
	private boolean isValidEmail(String email) {
	    String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    return email.matches(emailRegex);
	}
	
	private boolean isValidPassword(String password) {
	    // Verifica se la password ha almeno 8 caratteri
	    if (password.length() < 8) {
	        return false;
	    }

	    // Verifica se la password contiene almeno una lettera maiuscola
	    if (!password.matches(".*[A-Z].*")) {
	        return false;
	    }

	    // Verifica se la password contiene almeno una cifra
	    if (!password.matches(".*\\d.*")) {
	        return false;
	    }

	    // Verifica se la password contiene almeno un simbolo
	    if (!password.matches(".*[!@#$%^&*].*")) {
	        return false;
	    }

	    return true;
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
