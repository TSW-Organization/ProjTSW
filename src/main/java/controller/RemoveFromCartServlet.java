package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productIdStr = request.getParameter("productId");
        int productId = Integer.parseInt(productIdStr);

        // Ottieni la sessione corrente o crea una nuova sessione
        HttpSession session = request.getSession(true);

        List<Integer> cartItemsId = (List<Integer>) session.getAttribute("cartItemsId");
        if (cartItemsId == null) {
            // Se la lista non esiste nella sessione, non c'è niente da rimuovere
            return;
        }

        if (cartItemsId.contains(productId)) {
            cartItemsId.remove(Integer.valueOf(productId));
        } 

        // Aggiorna la lista del carrello nella sessione
        session.setAttribute("cartItemsId", cartItemsId);
	}

}
