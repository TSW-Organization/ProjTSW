package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartItem;


@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        int productId = Integer.parseInt(request.getParameter("productId"));

        HttpSession session = request.getSession(true);

        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        if (cartItems == null) {
            // Se la lista non esiste nella sessione, non c'è niente da rimuovere
            return;
        }
        
        for (CartItem cartItem : cartItems) {  
        	if (cartItem.getId() == productId) {    
        		cartItems.remove(cartItem);
        		break;	   
            }
        }

        // Aggiorna la lista del carrello nella sessione
        session.setAttribute("cartItems", cartItems);
	}

}
