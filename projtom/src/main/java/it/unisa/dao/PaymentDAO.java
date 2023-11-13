package it.unisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import it.unisa.utils.DriverManagerConnectionPool;
import java.sql.Date;
import it.unisa.bean.Payment;


public class PaymentDAO {
	
	private static final Logger logger = Logger.getLogger(PaymentDAO.class.getName());
	
	public int setPayment(Date date, Time time, double amount, int userId, String accountholder, String cardNumber, int expMonth, int expYear, int cvv) {
		
		Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int generatedId = -1; // Inizializziamo con un valore di errore

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "INSERT INTO payment (date, time, amount, userId, accountholder, cardNumber, expMonth, expYear, cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	        // Passiamo il flag Statement.RETURN_GENERATED_KEYS al PreparedStatement
	        statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        statement.setDate(1, date);
	        statement.setTime(2, time);
	        statement.setDouble(3, amount);
	        statement.setInt(4, userId);
	        statement.setString(5, accountholder);
	        statement.setString(6, cardNumber);
	        statement.setInt(7, expMonth);
	        statement.setInt(8, expYear);
	        statement.setInt(9, cvv); 
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

	    return generatedId; // Ritorniamo l'ID generato
	}
	

	public Payment getPaymentByPaymentId(int paymentId) {
		
		Payment payment = new Payment();
		
		Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, cardNumber FROM payment WHERE id=?";

	        statement = connection.prepareStatement(query);
	        statement.setInt(1, paymentId);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {   
	            int id = resultSet.getInt("id");
	            String cardNumber = resultSet.getString("cardNumber");

	            payment.setId(id);
	            payment.setCardNumber(cardNumber);

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
		
		return payment;
	}
}

