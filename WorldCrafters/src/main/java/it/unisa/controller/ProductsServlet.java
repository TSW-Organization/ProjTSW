package it.unisa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.Product;
import it.unisa.dao.ProductDAO;



@WebServlet(urlPatterns = {"/products", "/search"})
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("category");
        String search = request.getParameter("search");
        ProductDAO productDAO = new ProductDAO();

        List<Product> products;

        if (category != null) {
            // Se è presente il parametro "category", ottieni prodotti in base alla categoria
            products = productDAO.getProductsByCategory(category);
        } else if (search != null) {
            // Se è presente il parametro "search", ottieni prodotti in base al testo di ricerca
            products = productDAO.getProductsBySearch(search);
        } else {
            // Se nessun parametro è presente, ottieni tutti i prodotti
            products = productDAO.getAllProducts();
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("products.jsp").forward(request, response);
	}

}