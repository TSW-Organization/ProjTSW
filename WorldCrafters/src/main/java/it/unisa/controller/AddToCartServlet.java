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

import it.unisa.DAO.ProductDAO;
import it.unisa.bean.CartItem;
import it.unisa.bean.Product;

//QUESTA SERVLET SERVE ANCHE AD AGGIORNARE LA QUANTITÀ NEL CARRELLO
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int selectedQuantity = Integer.parseInt(request.getParameter("selectedQuantity"));
		
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProductById(productId);
		
		
        HttpSession session = request.getSession(true);
        
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems == null) {
            // Se la lista non esiste ancora nella sessione, crea una nuova lista
            cartItems = new ArrayList<>();
        }
        
        boolean found = false;
        for (CartItem cartItem : cartItems) {
            if (cartItem.getId() == productId) {
            	// Aggiorna la quantità se il prodotto è già presente
            	cartItem.setSelectedQuantity(selectedQuantity);
            	found = true;
                break;
            }
        }
        
        if(!found) {
        	CartItem cartItem = new CartItem(product, selectedQuantity);
        	cartItems.add(cartItem);
        }
        
        // Aggiorna la lista del carrello nella sessione
        session.setAttribute("cartItems", cartItems);
        
        response.sendRedirect("cart");
	}

}
