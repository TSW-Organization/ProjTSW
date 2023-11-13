package it.unisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import it.unisa.utils.DriverManagerConnectionPool;


public class UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());
    
	public boolean authenticateEmail(String email) {
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    boolean emailFound = false; // Inizializziamo con un valore di errore

        try {
        	connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id FROM user WHERE ( email=? );";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            emailFound = true;
	        }
	        
	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
	    } finally {
	        
	    	try {
	    		if (statement != null) {
	                statement.close();
	            }
	    		if (resultSet != null) {
	                resultSet.close();
	            }
	            if (connection != null) {
	                connection.close();
	            } 
	        } catch (SQLException e) {
	            logger.log(Level.WARNING, e.getMessage());
	        }
	    }

	    return emailFound;
    }
	
	public int authenticate(String email, String password) {
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int generatedId = -1; // Inizializziamo con un valore di errore

        try {
        	connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id FROM user WHERE ( email=? AND password=?);";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        statement.setString(2, password);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            generatedId = resultSet.getInt("id");
	        }
	        
	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
	    } finally {
	        try {
	        	if (statement != null) {
	                statement.close();
	            }
	    		if (resultSet != null) {
	                resultSet.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            logger.log(Level.WARNING, e.getMessage());
	        }
	    }

	    return generatedId;
    }
    
    public int registerUser(String firstName, String lastName, String email, String password) {
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int generatedId = -1; // Inizializziamo con un valore di errore

        try {
        	connection = DriverManagerConnectionPool.getConnection();
	        String query = "INSERT INTO user (firstName, lastName, email, password) VALUES (?, ?, ?, ?);";

	        // Passiamo il flag Statement.RETURN_GENERATED_KEYS al PreparedStatement
	        statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, firstName);
	        statement.setString(2, lastName);
	        statement.setString(3, email);
	        statement.setString(4, password);
	        statement.executeUpdate();

	        // Otteniamo l'ID generato
	        resultSet = statement.getGeneratedKeys();
	        if (resultSet.next()) {
	            generatedId = resultSet.getInt(1);
	        }

	        connection.commit();
	        
	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
	    } finally {
	        try {    	
	        	if (statement != null) {
	                statement.close();
	            }
	    		if (resultSet != null) {
	                resultSet.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            logger.log(Level.WARNING, e.getMessage());
	        }
	    }
        
        return generatedId;

    }  
    
    public boolean verifyEmail(String email) {
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    boolean isValid = true;

        try {
        	connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id FROM user WHERE ( email=? );";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            isValid=false;
	        }
	        
	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
	    } finally {
	        try {
	        	if (statement != null) {
	                statement.close();
	            }
	    		if (resultSet != null) {
	                resultSet.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            logger.log(Level.WARNING, e.getMessage());
	        }
	    }

	    return isValid;
    }
    
}