package it.unisa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.Purchase;
import it.unisa.dao.PurchaseDAO;

@WebServlet("/orders")
public class AdminOrdersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupera la lista degli ordini dal PurchaseDAO
        PurchaseDAO purchaseDAO = new PurchaseDAO();
        List<Purchase> orders = purchaseDAO.getAllPurchases(); // Assumi un metodo getAllPurchases() nel PurchaseDAO

        
        // Passa la lista alla pagina JSP
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("viewOrders.jsp").forward(request, response);
    }

}
