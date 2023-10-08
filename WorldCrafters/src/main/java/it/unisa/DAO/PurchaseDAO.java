package it.unisa.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unisa.bean.Purchase;
import it.unisa.utils.DriverManagerConnectionPool;

public class PurchaseDAO {
	
	public int setPurchase(Date date, double amount, int userId, int paymentId) {
		
		Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int generatedId = -1; // Inizializziamo con un valore di errore

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "INSERT INTO purchase (date, amount, userId, paymentId) VALUES (?, ?, ?, ?);";

	        // Passiamo il flag Statement.RETURN_GENERATED_KEYS al PreparedStatement
	        statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        statement.setDate(1, date);
	        statement.setDouble(2, amount);
	        statement.setInt(3, userId);
	        statement.setInt(4, paymentId);
	        statement.executeUpdate();

	        // Otteniamo l'ID generato
	        resultSet = statement.getGeneratedKeys();
	        if (resultSet.next()) {
	            generatedId = resultSet.getInt(1);
	        }

	        connection.commit();
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

	    return generatedId; // Ritorniamo l'ID generato
	}
	
	public List<Purchase> getPurchasesByUserId(int userId) {
		
		List<Purchase> purchases = new ArrayList<>();
		
		Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, date, amount, paymentId FROM purchase WHERE (userId = ?);";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, userId);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	Date date = resultSet.getDate("date");
	            double amount = resultSet.getDouble("amount");
	            int paymentId = resultSet.getInt("paymentId");

	            Purchase purchase = new Purchase();
	            purchase.setId(id);
	            purchase.setDate(date);
	            purchase.setAmount(amount);
	            purchase.setPaymentId(paymentId);

	            purchases.add(purchase);
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

	    return purchases;

	}
	
	
	
}
