package it.unisa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unisa.utils.DriverManagerConnectionPool;


public class AdminDAO {

	public boolean authenticateEmail(String email) {
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    boolean emailFound = false;

        try {
        	connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id FROM admin WHERE ( email=? );";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            emailFound = true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
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

	    return emailFound;
    }
	
	public boolean authenticate(String email, String password) {
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    boolean isValid = false;

        try {
        	connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id FROM admin WHERE ( email=? AND password=?);";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        statement.setString(2, password);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	        	isValid = true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
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

	    return isValid;
    }
    
    
	public boolean verifyEmail(String email) {
	        
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    boolean isValid = true;
	
	    try {
	    	connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id FROM admin WHERE ( email=? );";
	        statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        resultSet = statement.executeQuery();
	
	        if (resultSet.next()) {
	            isValid=false;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
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
	
	    return isValid;
	}
}