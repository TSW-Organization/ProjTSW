package it.unisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import it.unisa.utils.DriverManagerConnectionPool;

public class CartItemDAO {
	
	private static final Logger logger = Logger.getLogger(CartItemDAO.class.getName());

	public void setCartItem(int cartId, int productId, int selectedQuantity) {
	    
		Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "INSERT INTO cart_item (cartId, productId, selectedQuantity) VALUES (?, ?, ?) " +
	                       "ON DUPLICATE KEY UPDATE selectedQuantity = ?";

	        statement = connection.prepareStatement(query);
	        statement.setInt(1, cartId);
	        statement.setInt(2, productId);
	        statement.setInt(3, selectedQuantity);
	        statement.setInt(4, selectedQuantity);
	        statement.executeUpdate();

	        connection.commit();
	        
	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
	        // Gestire eccezioni e rollback in caso di errore.
	        try {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException ex) {
	        	logger.log(Level.WARNING, ex.getMessage());
	        }
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            logger.log(Level.WARNING, e.getMessage());
	        }
	    }
	}
	
	public void deleteCartItem(int cartId, int productId) {
		    
		Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "DELETE FROM cart_item WHERE cartId = ? AND productId = ?";

	        statement = connection.prepareStatement(query);
	        statement.setInt(1, cartId);
	        statement.setInt(2, productId);
	        statement.executeUpdate();

	        connection.commit();
	        
	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
	        // Gestire eccezioni e rollback in caso di errore.
	        try {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException ex) {
	        	logger.log(Level.WARNING, ex.getMessage());
	        }
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            logger.log(Level.WARNING, e.getMessage());
	        }
	    }
	}
	
	
}
