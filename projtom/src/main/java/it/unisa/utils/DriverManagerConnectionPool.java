package it.unisa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManagerConnectionPool  {

	private DriverManagerConnectionPool() {}
	
	private static List<Connection> freeDbConnections;
	private static final Logger logger = Logger.getLogger(DriverManagerConnectionPool.class.getName());
			
	static {
		freeDbConnections = new LinkedList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.log(Level.WARNING, e.getMessage());
			
		} 
	}
	
	private static synchronized Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String dbUrl = null;
		String dbUsername = null;
		String dbPassword = null;
		     
        try {
        	InputStream input = DriverManagerConnectionPool.class.getClassLoader().getResourceAsStream("config.properties");
        	Properties prop = new Properties();
            if (input == null) {
                logger.log(Level.WARNING, "Sorry, unable to find config.properties");
            }
            prop.load(input);

            dbUrl = prop.getProperty("db.url");
            dbUsername = prop.getProperty("db.username");
            dbPassword = prop.getProperty("db.password");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error loading configuration", ex);
        }

        try {
        	newConnection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    		newConnection.setAutoCommit(false);
        } catch (Exception e) {
        	logger.log(Level.WARNING, e.getMessage());
        }
        return newConnection;
        
	}


	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) {
		if(connection != null) freeDbConnections.add(connection);
	}
}
