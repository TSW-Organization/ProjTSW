package it.unisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unisa.bean.Admin;
import it.unisa.utils.DriverManagerConnectionPool;


public class AdminDAO {
	
	private static final Logger logger = Logger.getLogger(AdminDAO.class.getName());

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
	        } else {
	            System.out.println("Email not found for: " + email);
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
    
	public boolean isAdmin(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isAdmin = false;

        try {
            connection = DriverManagerConnectionPool.getConnection();
            String query = "SELECT isAdmin FROM admin WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                isAdmin = resultSet.getBoolean("isAdmin");
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

        return isAdmin;
    }

	public Admin getAdminByEmail(String email) {
	    try (Connection connection = DriverManagerConnectionPool.getConnection();
	         PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE email = ?")) {

	        statement.setString(1, email);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                Admin admin = new Admin();
	                admin.setId(resultSet.getInt("id"));
	                admin.setFirstName(resultSet.getString("firstName"));
	                admin.setLastName(resultSet.getString("lastName"));
	                admin.setEmail(email);
	                admin.setAdmin(resultSet.getBoolean("isAdmin"));
	                return admin;
	            }
	        }
	    } catch (SQLException e) {
	        // Handle SQLException
	        e.printStackTrace();  // For debugging purposes
	    }
	    return null;
	}


}