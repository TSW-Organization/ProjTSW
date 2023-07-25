package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

import model.Product;
import model.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/get-cart")
public class GetCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		Gson gson = new Gson();
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Recupera la lista dei prodotti aggiunti al carrello dalla sessione
        List<Integer> cartItemsId = (List<Integer>) session.getAttribute("cartItemsId");
        List<Product> cartItems = new ArrayList<>();
        
        if (cartItemsId == null || cartItemsId.isEmpty()) {

            String json = gson.toJson(cartItems);
            response.getWriter().write(json);
            return;
        }
        
        ProductDAO productDAO = new ProductDAO();
        
        for(Integer id : cartItemsId) {
        	
        	cartItems.add(productDAO.getProductById(id));
        }
        
        gson = new Gson();
        String json = gson.toJson(cartItems);

        // Scrivi il JSON come risposta alla chiamata GET
        response.getWriter().write(json);
         
	}
	
}
