package it.unisa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import it.unisa.DAO.PurchaseDAO;


@WebServlet("/DeletePurchaseRequestServlet")
public class DeletePurchaseRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		int purchaseId = Integer.parseInt(request.getParameter("purchaseId"));
		
		purchaseDAO.setDeleteRequestStatus(purchaseId, true);
		
		JsonObject jsonResponse = new JsonObject();
	    jsonResponse.addProperty("success", true);
	    response.setContentType("application/json");
	    response.getWriter().write(jsonResponse.toString());
	}

}