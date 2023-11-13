package it.unisa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.unisa.bean.Product;
import it.unisa.dao.ProductDAO;
@WebServlet("/EditorServlet")
public class EditorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int recordsPerPage = 20;
        
        // Chiamata al tuo metodo del DAO per ottenere una lista di prodotti paginata per l'editor
        List<Product> products = getEditorProductListForPage(page, recordsPerPage);
        
        // Invia i dati al client (JSON è un'opzione comune)
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(products));
    }
    
 // Inside EditorServlet.java

    private List<Product> getEditorProductListForPage(int page, int recordsPerPage) {
        // Assuming you have a ProductDAO instance
        ProductDAO productDAO = new ProductDAO();

        // Calculate the starting index of records for the specified page
        int startIndex = (page - 1) * recordsPerPage;

        // Call the DAO method to fetch the products for the current page
        List<Product> products = productDAO.getEditorProductsForPage(startIndex, recordsPerPage);

        return products;
    }

}
