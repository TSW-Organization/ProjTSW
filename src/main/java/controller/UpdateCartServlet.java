package controller;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import model.CartItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/update-cart")
public class UpdateCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		Gson gson = new Gson();
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Recupera la lista dei prodotti aggiunti al carrello dalla sessione
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
        
        if (cartItems == null || cartItems.isEmpty()) {

            String json = gson.toJson(cartItems);
            response.getWriter().write(json);
            return;
        }
        
        String json = gson.toJson(cartItems);

        // Scrivi il JSON come risposta alla chiamata GET
        response.getWriter().write(json);
         
	}
	
}
