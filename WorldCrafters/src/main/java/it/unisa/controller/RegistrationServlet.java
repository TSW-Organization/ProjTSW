package it.unisa.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        boolean isRegistered = false;
		try {
			isRegistered = registerUser(username, email, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (isRegistered) {
            response.sendRedirect("log.jsp?registration=1");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }
    
    private boolean registerUser(String username, String email, String password) throws ClassNotFoundException {
        
    	Connection connection = null;
        PreparedStatement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            // Configura le informazioni di connessione al tuo database
        	
            String url = "jdbc:mysql://localhost:3306/e_shop";
            String dbUsername = "root";
            String dbPassword = "Sutianyu02.";
            
            // Crea la connessione al database
            
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            
            // Prepara la query di inserimento dei dati
            String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            
            // Esegui la query di inserimento dei dati
            int rowsInserted = statement.executeUpdate();
            
            // Chiudi le risorse
            statement.close();
            connection.close();
            
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
