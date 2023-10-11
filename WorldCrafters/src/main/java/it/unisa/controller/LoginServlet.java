package it.unisa.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

        // Esegui l'hashing della password
        String hashedPassword = hashPassword(password);

        // Effettua la logica di autenticazione nel database e restituisce true se le credenziali sono corrette
        UserDAO userDAO = new UserDAO();

        boolean isValidUser = false;
        isValidUser = userDAO.authenticate(email, hashedPassword);

        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);
            response.sendRedirect("home");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", false);
            response.sendRedirect("login.jsp"); // Reindirizza alla pagina di login con un messaggio di errore
        }
    }

    private String hashPassword(String password) {
        // Implementa l'hashing della password qui (come fatto nella RegistrationServlet)
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
