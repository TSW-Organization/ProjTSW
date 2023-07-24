package servlet;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Effettua la logica di autenticazione nel database e restituisce true se le credenziali sono corrette
        boolean isValidUser = false;
		try {
			isValidUser = authenticate(username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (isValidUser) {
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
            response.sendRedirect("home.jsp"); // Reindirizza l'utente a index.jsp
        } else {
            response.sendRedirect("log.jsp?error=1"); // Reindirizza alla pagina di login con un messaggio di errore
        }
    }
    
    private boolean authenticate(String username, String password) throws ClassNotFoundException {
        

    	// Esegui la logica di autenticazione nel tuo database
        // Query il database per verificare se l'username e la password forniti corrispondono a un utente registrato
        
        // Esempio (utilizzando JDBC):
       Class.forName("com.mysql.cj.jdbc.Driver");
       try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_shop", "root", "Sutianyu02.");
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // L'utente è autenticato correttamente
                resultSet.close();
                statement.close();
                connection.close();
                return true;
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // L'utente non è autenticato
        return false;
    }
}
