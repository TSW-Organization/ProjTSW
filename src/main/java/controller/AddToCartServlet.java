package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productIdStr = request.getParameter("productId");
		int productId = Integer.parseInt(productIdStr);

        // Ottieni la sessione corrente o crea una nuova sessione
        HttpSession session = request.getSession(true);
        
        List<Integer> cartItemsId = (List<Integer>) session.getAttribute("cartItemsId");
        if (cartItemsId == null) {
            // Se la lista non esiste ancora nella sessione, crea una nuova lista
            cartItemsId = new ArrayList<>();
        }

        if (!cartItemsId.contains(productId)) {
            cartItemsId.add(productId);
            System.out.println("Aggiunto il prodotto con ID: " + productId);
        } else {
            System.out.println("Il prodotto con ID " + productId + " e` gia` presente nel carrello.");
        }
        
        System.out.println("Contenuto della lista cartItemsId:");
        for (Integer id : cartItemsId) {
            System.out.println(id);
        }
        
        // Aggiorna la lista del carrello nella sessione
        session.setAttribute("cartItemsId", cartItemsId);
			
	}

}
