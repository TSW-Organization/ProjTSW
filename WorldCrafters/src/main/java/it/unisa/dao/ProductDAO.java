package it.unisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import it.unisa.bean.Category;
import it.unisa.bean.Product;
import it.unisa.utils.DriverManagerConnectionPool; 

public class ProductDAO {
	
	private static final Logger logger = Logger.getLogger(ProductDAO.class.getName());

	private static final String PRICE = "price";
	private static final String SELLER = "seller";
	private static final String IMG_SRC = "imgSrc";
	private static final String CATEGORY = "category";
	private static final String QUANTITY = "quantity";
	private static final String FAVORITES = "favorites";
	private static final String LISTING_DATE = "listingDate";
	private static final String DESCRIPTION = "Description";
	
	
	public List<Product> getAllProducts() {
        
        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM product WHERE quantity>0 AND status='enabled'";
	        statement = connection.prepareStatement(query);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble(PRICE);
	            String seller = resultSet.getString(SELLER);
	            String imgSrc = resultSet.getString(IMG_SRC);
	            Category category = Category.valueOf(resultSet.getString(CATEGORY).toUpperCase());
	            int quantity = resultSet.getInt(QUANTITY);
	            int favorites = resultSet.getInt(FAVORITES);
	            Date listingDate = resultSet.getDate(LISTING_DATE);
	            String description = resultSet.getString(DESCRIPTION);

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

	    return products;
    }

    public List<Product> getFavoritesProducts() {
        
        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM product WHERE quantity>0 AND status='enabled' ORDER BY favorites DESC";
	        statement = connection.prepareStatement(query);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble(PRICE);
	            String seller = resultSet.getString(SELLER);
	            String imgSrc = resultSet.getString(IMG_SRC);
	            Category category = Category.valueOf(resultSet.getString(CATEGORY).toUpperCase());
	            int quantity = resultSet.getInt(QUANTITY);
	            int favorites = resultSet.getInt(FAVORITES);
	            Date listingDate = resultSet.getDate(LISTING_DATE);
	            String description = resultSet.getString(DESCRIPTION);

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

	    return products;
    }

    public List<Product> getProductsByCategory(String chosenCategory) { 

        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM product WHERE quantity>0 AND status='enabled' AND (category=? OR category=? OR category=? OR category=?)";
	        statement = connection.prepareStatement(query);
	        
	        if (chosenCategory.equals("arte")) {
	            statement.setString(1, "fotografia");
	            statement.setString(2, "pittura");
	            statement.setString(3, "scultura");
	            statement.setString(4, "vetro");
	        } else if (chosenCategory.equals("abbigliamento")) {
	            statement.setString(1, "abbigliamento_uomo");
	            statement.setString(2, "abbigliamento_donna");
	            statement.setString(3, "abbigliamento_bambino");
	            statement.setString(4, "borse");
	        } else if (chosenCategory.equals("gioielli")) {
	            statement.setString(1, "anelli");
	            statement.setString(2, "bracciali");
	            statement.setString(3, "collane");
	            statement.setString(4, "orecchini");
	        } else if (chosenCategory.equals("intrattenimento")) {
	            statement.setString(1, "cinema");
	            statement.setString(2, "libri");
	            statement.setString(3, "musica");
	            statement.setString(4, "giochi");
	        } else {
	            statement.setString(1, chosenCategory);
	            statement.setString(2, "0");
	            statement.setString(3, "0");
	            statement.setString(4, "0");
	        }
	        
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble(PRICE);
	            String seller = resultSet.getString(SELLER);
	            String imgSrc = resultSet.getString(IMG_SRC);
	            Category category = Category.valueOf(resultSet.getString(CATEGORY).toUpperCase());
	            int quantity = resultSet.getInt(QUANTITY);
	            int favorites = resultSet.getInt(FAVORITES);
	            Date listingDate = resultSet.getDate(LISTING_DATE);
	            String description = resultSet.getString(DESCRIPTION);

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

	    return products;
    }
    
    public Product getProductById(int productId) {
        
        Product product = new Product();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM product WHERE id = ?";
	        statement = connection.prepareStatement(query);
	        
	        statement.setInt(1, productId);
	        
	        resultSet = statement.executeQuery();

	        if(resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble(PRICE);
	            String seller = resultSet.getString(SELLER);
	            String imgSrc = resultSet.getString(IMG_SRC);
	            Category category = Category.valueOf(resultSet.getString(CATEGORY).toUpperCase());
	            int quantity = resultSet.getInt(QUANTITY);
	            int favorites = resultSet.getInt(FAVORITES);
	            Date listingDate = resultSet.getDate(LISTING_DATE);
	            String description = resultSet.getString(DESCRIPTION);

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

	    return product;
    }
    
    public List<Product> getProductsByName(String searchTerm) { 

        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM product WHERE quantity>0 AND status='enabled' AND name LIKE ?";
	        statement = connection.prepareStatement(query);

	        statement.setString(1, searchTerm);
	        
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble(PRICE);
	            String seller = resultSet.getString(SELLER);
	            String imgSrc = resultSet.getString(IMG_SRC);
	            Category category = Category.valueOf(resultSet.getString(CATEGORY).toUpperCase());
	            int quantity = resultSet.getInt(QUANTITY);
	            int favorites = resultSet.getInt(FAVORITES);
	            Date listingDate = resultSet.getDate(LISTING_DATE);
	            String description = resultSet.getString(DESCRIPTION);

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

	    return products;
    }
    
    public List<Product> getProductsBySearch(String search) {
        
        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM product WHERE quantity>0 AND status='enabled' AND (LOWER(name) LIKE ? OR LOWER(category) LIKE ? OR LOWER(description) LIKE ?)";
	        statement = connection.prepareStatement(query);
	        String searchParam = "%" + search.toLowerCase() + "%";
	        statement.setString(1, searchParam);
	        statement.setString(2, searchParam);
	        statement.setString(3, searchParam);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble(PRICE);
	            String seller = resultSet.getString(SELLER);
	            String imgSrc = resultSet.getString(IMG_SRC);
	            Category category = Category.valueOf(resultSet.getString(CATEGORY).toUpperCase());
	            int quantity = resultSet.getInt(QUANTITY);
	            int favorites = resultSet.getInt(FAVORITES);
	            Date listingDate = resultSet.getDate(LISTING_DATE);
	            String description = resultSet.getString(DESCRIPTION);

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

	    return products;
    }
    
    public void sellProduct(int id, int selectedQuantity) {
        
        Connection connection = null;
	    PreparedStatement statement = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "UPDATE product SET quantity=quantity-?, favorites=favorites+? WHERE id=?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, selectedQuantity);
	        statement.setInt(2, selectedQuantity);
	        statement.setInt(3, id);
	        statement.executeUpdate();
	        
	        connection.commit();

	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
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

	public List<Product> getProductsByPurchaseId(int purchaseId) {
		
		List<Product> products = new ArrayList<>();
	    
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	
	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query =  "SELECT P.id, P.name, P.price, P.seller, P.imgSrc, P.quantity, P.favorites, P.ListingDate, P.description, P.category " +
	    			"FROM product P " +
	    			"JOIN purchase_item ON P.id = purchase_item.productId " +
	    			"JOIN purchase ON  purchase_item.purchaseId = purchase.id " +
	    			"WHERE purchase.id = ?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, purchaseId);
	        resultSet = statement.executeQuery();
	
	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble(PRICE);
	            String seller = resultSet.getString(SELLER);
	            String imgSrc = resultSet.getString(IMG_SRC);
	            Category category = Category.valueOf(resultSet.getString(CATEGORY).toUpperCase());
	            int quantity = resultSet.getInt(QUANTITY);
	            int favorites = resultSet.getInt(FAVORITES);
	            Date listingDate = resultSet.getDate(LISTING_DATE);
	            String description = resultSet.getString(DESCRIPTION);
	
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
	
	    return products;
	    
	}

	// Inside ProductDAO.java

	public List<Product> getEditorProductsForPage(int startIndex, int recordsPerPage) {
	    List<Product> products = new ArrayList<>();

	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller FROM product LIMIT ?, ?";
	        statement = connection.prepareStatement(query);
	        statement.setInt(1, startIndex);
	        statement.setInt(2, recordsPerPage);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String name = resultSet.getString("name");
	            double price = resultSet.getDouble("price");
	            String seller = resultSet.getString("seller");

	            Product product = new Product();
	            product.setId(id);
	            product.setName(name);
	            product.setPrice(price);
	            product.setSeller(seller);

	            products.add(product);
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

	    return products;
	}

	public void updateProduct(Product product) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "UPDATE product SET name=?, price=?, seller=?, quantity=?, category=?, description=? WHERE id=?";
	        statement = connection.prepareStatement(query);

	        statement.setString(1, product.getName());
	        statement.setDouble(2, product.getPrice());
	        statement.setString(3, product.getSeller());
	        statement.setInt(4, product.getQuantity());
	        statement.setString(5, product.getCategory().toString()); // o getCategory().name() a seconda dell'implementazione di toString() in Category
	        statement.setString(6, product.getDescription());
	        statement.setInt(7, product.getId()); // Assicurati di impostare tutti i parametri necessari

	        statement.executeUpdate();

	        connection.commit();
	    } catch (SQLException e) {
	        logger.log(Level.WARNING, e.getMessage());
	        // Gestisci l'eccezione o inserisci un log
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
	            // Gestisci l'eccezione o inserisci un log in caso di errore durante la chiusura delle risorse
	        }
	    }
	}

}
	

