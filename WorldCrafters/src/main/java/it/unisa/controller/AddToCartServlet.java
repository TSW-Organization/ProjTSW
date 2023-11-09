package it.unisa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.DAO.CartDAO;
import it.unisa.DAO.CartItemDAO;
import it.unisa.DAO.ProductDAO;
import it.unisa.bean.Product;


@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int selectedQuantity = Integer.parseInt(request.getParameter("selectedQuantity"));
		
		CartItemDAO cartItemDAO= new CartItemDAO();
		
		HttpSession session = request.getSession();
		int userId;
		int cartId;
		
		if(session.getAttribute("userId") != null) {
			
			userId = (int) session.getAttribute("userId");
			//salvare nel database
			CartDAO cartDAO = new CartDAO();
			
			cartId = cartDAO.getCartByUserId(userId);
			
			//Controllo se é già presente un carrello
			if(cartId == -1) {
				//creo nuovo carrello
				cartId = cartDAO.setCart(userId);
			}
			
			cartItemDAO.setCartItem(cartId, productId, selectedQuantity);
			
			//recuperare prodotti nel carrello
			List<Product> productList = new ArrayList<>();

			productList = cartDAO.getAllCartProducts(cartId);
			
			session.setAttribute("productList", productList);
	        
	        response.sendRedirect("cart");


		} else {
			//sessione non persistente
	
			ProductDAO productDAO = new ProductDAO();
			Product product = productDAO.getProductById(productId);

	        
	        @SuppressWarnings("unchecked")
	        List<Product> productList = (List<Product>) session.getAttribute("productList");
	        if (productList == null) {
	            // Se la lista non esiste ancora nella sessione, crea una nuova lista
	        	productList = new ArrayList<>();
	        }
	        
	        boolean found = false;
	        for (Product item : productList) {
	            if (item.getId() == productId) {
	            	// Aggiorna la quantità se il prodotto è già presente
	            	//int oldQuantity = item.getSelectedQuantity();
	            	item.setSelectedQuantity(selectedQuantity);
	            	found = true;
	                break;
	            }
	        }
	        
	        if(!found) {
	        	product.setSelectedQuantity(selectedQuantity);
	        	productList.add(product);
	        }
	        
	        // Aggiorna la lista del carrello nella sessione
			session.setAttribute("productList", productList);
	        response.sendRedirect("cart");
		}
  
	}

}
