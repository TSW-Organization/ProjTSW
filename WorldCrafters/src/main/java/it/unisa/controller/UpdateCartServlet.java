package it.unisa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.DAO.CartDAO;
import it.unisa.bean.Product;


@WebServlet("/update-cart")
public class UpdateCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        int userId;
        int cartId;
        List<Product> productList = new ArrayList<>();
        
		if(session.getAttribute("userId")!=null) {
					
				userId = (int) session.getAttribute("userId");
				CartDAO cartDAO = new CartDAO();
				cartId = cartDAO.getCartByUserId(userId);

				productList = cartDAO.getAllCartProducts(cartId);
				
				session.setAttribute("productList", productList);
		}
		
        productList = (List<Product>) session.getAttribute("productList");
        
        if (productList == null || productList.isEmpty()) {

        	productList = new ArrayList<>();
        	String json = gson.toJson(productList);
            response.getWriter().write(json);
            return;
        }


        String json = gson.toJson(productList);
        response.getWriter().write(json);
         
	}
	
}
