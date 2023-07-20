package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductDAO;


@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productIdStr = request.getParameter("id");
		int productId = Integer.parseInt(productIdStr);
	    
		ProductDAO productDAO = new ProductDAO();

	    Product product = productDAO.getProductById(productId);
		
		request.setAttribute("product", product);
			
		request.getRequestDispatcher("product-details.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}