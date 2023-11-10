package it.unisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import it.unisa.utils.DriverManagerConnectionPool;

public class PurchaseItemDAO {
	
	private static final Logger logger = Logger.getLogger(PurchaseItemDAO.class.getName());
	
	public int setOrderItem(int quantity, double price, int productId, int orderId) {
		
		Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int generatedId = -1;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "INSERT INTO purchase_item (quantity, price, productId, purchaseId) VALUES (?, ?, ?, ?);";

	        // Passiamo il flag Statement.RETURN_GENERATED_KEYS al PreparedStatement
	        statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        statement.setInt(1, quantity);
	        statement.setDouble(2, price);
	        statement.setInt(3, productId);
	        statement.setInt(4, orderId);
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
}
