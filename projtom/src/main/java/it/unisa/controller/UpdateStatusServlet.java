package it.unisa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.dao.PurchaseDAO;


//UpdateStatusServlet.java

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     int purchaseId = Integer.parseInt(request.getParameter("purchaseId"));
     String newStatus = request.getParameter("newStatus");

     PurchaseDAO purchaseDAO = new PurchaseDAO();
     purchaseDAO.updatePurchaseStatus(purchaseId, newStatus);

     response.getWriter().write(newStatus); // Restituisci il nuovo stato
 }
}
