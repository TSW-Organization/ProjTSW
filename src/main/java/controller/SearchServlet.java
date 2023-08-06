package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Product;
import model.ProductDAO;


@WebServlet("/api/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Qui dovresti ottenere la lista di prodotti dal tuo ProductDAO
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();

        // Converti la lista di prodotti in formato JSON e inviali al client
        Gson gson = new Gson();
        String json = gson.toJson(products);
        out.print(json);
    }

}
