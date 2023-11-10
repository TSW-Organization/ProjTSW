package it.unisa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.Product;
import it.unisa.dao.ProductDAO;


public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera la lista dei prodotti dal ProductDAO
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();

        // Imposta l'attributo "products" nella richiesta
        request.setAttribute("products", products);

        // Esegui il reindirizzamento con sendRedirect()
        response.sendRedirect("home.jsp");
    }
}
