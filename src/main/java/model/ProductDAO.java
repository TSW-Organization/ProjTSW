package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class ProductDAO {


    private List<Product> executeProductQuery(String query, String... parameters) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DriverManagerConnectionPool.getConnection();
        		PreparedStatement statement = connection.prepareStatement(query)) {

            for (int i = 0; i < parameters.length; i++) {
                statement.setString(i + 1, parameters[i]);
            }

            ResultSet resultSet = statement.executeQuery(); 
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble("price");
	            String seller = resultSet.getString("seller");
	            String imgSrc = resultSet.getString("imgSrc");
	            Category category = Category.valueOf(resultSet.getString("category"));
	            int quantity = resultSet.getInt("quantity");
	            int favorites = resultSet.getInt("favorites");
	            Date listingDate = resultSet.getDate("listingDate");
	            String description = resultSet.getString("description");

	            Product product = new Product();
	            product.setId(id);
	            product.setName(name);
	            product.setPrice(price);
	            product.setSeller(seller);
	            product.setImgSrc(imgSrc);
	            product.setCategory(category);
	            product.setQuantity(quantity);
	            product.setFavorites(favorites);
	            product.setListingDate(listingDate);
	            product.setDescription(description);

	            products.add(product);
            }
           
        } catch (SQLException e) {
            // Gestione delle eccezioni
            e.printStackTrace();
        }
        
        

        return products;
    }

    public List<Product> getAllProducts() {
        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM products WHERE (quantity>0)";
        return executeProductQuery(query);
    }

    public List<Product> getFavoritesProducts() {
        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM products WHERE (quantity>0) ORDER BY favorites DESC";
        return executeProductQuery(query);
    }

    public List<Product> getProductsByCategory(String chosenCategory) {
        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM products WHERE (quantity>0) AND (category=? OR category=? OR category=? OR category=?)";

        if (chosenCategory.equals("arte")) {
            return executeProductQuery(query, "fotografia", "pittura", "scultura", "vetro");
        } else if (chosenCategory.equals("abbigliamento")) {
            return executeProductQuery(query, "abbigliamento_uomo", "abbigliamento_donna", "abbigliamento_bambino", "borsa");
        } else if (chosenCategory.equals("gioiello")) {
            return executeProductQuery(query, "anello", "bracciale", "collana", "orecchino");
        } else if (chosenCategory.equals("intrattenimento")) {
            return executeProductQuery(query, "cinema", "libro", "musica", "gioco");
        } else {
            return executeProductQuery(query, chosenCategory, "0", "0", "0");
        }
    }
    
}