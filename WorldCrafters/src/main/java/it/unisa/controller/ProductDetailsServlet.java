package it.unisa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.Product;
import it.unisa.dao.ProductDAO;



@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productIdStr = request.getParameter("id");
		int productId = -1;
		
		try {
			productId = Integer.parseInt(productIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	    
		ProductDAO productDAO = new ProductDAO();

	    Product product = productDAO.getProductById(productId);
		
		request.setAttribute("product", product);
		
		try {
			request.getRequestDispatcher("product-details.jsp").forward(request, response);
        } catch (ServletException se) {
    		se.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doGet(request, response);
        } catch (ServletException se) {
    		se.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
	}

}