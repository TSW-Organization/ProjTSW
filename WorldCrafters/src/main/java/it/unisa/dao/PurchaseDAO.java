package it.unisa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import it.unisa.bean.Purchase;
import it.unisa.bean.Status;
import it.unisa.utils.DriverManagerConnectionPool;

public class PurchaseDAO {
	
	public int setPurchase(Date date, Time time, double amount, int userId, int paymentId, String fullName, String address, String city, String state, String zipCode) {
		
		Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int generatedId = -1; // Inizializziamo con un valore di errore

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "INSERT INTO purchase (date, time, amount, userId, paymentId, fullName, address, city, state, zipCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	        // Passiamo il flag Statement.RETURN_GENERATED_KEYS al PreparedStatement
	        statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        statement.setDate(1, date);
	        statement.setTime(2, time);
	        statement.setDouble(3, amount);
	        statement.setInt(4, userId);
	        statement.setInt(5, paymentId);
	        statement.setString(6, fullName);
	        statement.setString(7, address);
	        statement.setString(8, city);
	        statement.setString(9, state);
	        statement.setString(10, zipCode);
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
	        String query = "SELECT id, date, time, status, amount, estimatedDate, paymentId, fullName, address, city, state, zipCode, deleteRequest FROM purchase WHERE (userId = ?) ORDER BY date DESC, time DESC;";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, userId);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	Date date = resultSet.getDate("date");
	        	Time time = resultSet.getTime("time");
	        	Status status = Status.valueOf(resultSet.getString("status"));
	            double amount = resultSet.getDouble("amount");
	            Date estimatedDate = resultSet.getDate("estimatedDate");
	            int paymentId = resultSet.getInt("paymentId");
	            String fullName = resultSet.getString("fullName");
	            String address = resultSet.getString("address");
	            String city = resultSet.getString("city");
	            String state = resultSet.getString("state");
	            String zipCode = resultSet.getString("zipCode");
	            boolean deleteRequest = resultSet.getBoolean("deleteRequest");
	            

	            Purchase purchase = new Purchase();
	            purchase.setId(id);
	            purchase.setDate(date);
	            purchase.setTime(time);
	            purchase.setStatus(status);
	            purchase.setAmount(amount);
	            purchase.setEstimatedDate(estimatedDate);
	            purchase.setPaymentId(paymentId);
	            purchase.setFullName(fullName);
	            purchase.setAddress(address);
	            purchase.setCity(city);
	            purchase.setState(state);
	            purchase.setZipCode(zipCode);
	            purchase.setDeleteRequest(deleteRequest);
	            
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
	
	public void setDeleteRequestStatus(int purchaseId, boolean status) {
		
		Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "UPDATE purchase SET deleteRequest=? WHERE id=?;";

	        statement = connection.prepareStatement(query);
	        statement.setBoolean(1, status);
	        statement.setInt(2, purchaseId);
	        statement.executeUpdate();

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
		
	}
	
	
	
}
