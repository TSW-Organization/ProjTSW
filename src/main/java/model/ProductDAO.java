package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;


public class ProductDAO {
    
	public List<Product> getAllProducts() {
	    List<Product> products = new ArrayList<>();

	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT title, price, imgSrc FROM products";
	        statement = connection.prepareStatement(query);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String title = resultSet.getString("title");
	            double price = resultSet.getDouble("price");
	            String imgSrc = resultSet.getString("imgSrc");

	            Product product = new Product();
	            product.setTitle(title);
	            product.setPrice(price);
	            product.setImgSrc(imgSrc);

	            products.add(product);
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

        Collections.shuffle(products, new Random());

	    return products;
	}
}