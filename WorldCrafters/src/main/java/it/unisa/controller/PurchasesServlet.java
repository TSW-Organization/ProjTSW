package it.unisa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.DAO.PaymentDAO;
import it.unisa.DAO.ProductDAO;
import it.unisa.DAO.PurchaseDAO;
import it.unisa.DAO.PurchaseItemDAO;
import it.unisa.bean.Purchase;




@WebServlet("/purchases")
public class PurchasesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Crea un'istanza di ProductDAO
	    ProductDAO productDAO = new ProductDAO();
		PurchaseDAO purchaseDAO = new PurchaseDAO();
	    PaymentDAO paymentDAO = new PaymentDAO();
	    PurchaseItemDAO purchaseItemDAO = new PurchaseItemDAO();


	    List<Purchase> purchases = purchaseDAO.getPurchasesByCustomerId(1);
	    
	    /*
	    for(Purchase purchase : purchases) {
	    	Payment payment = paymentDAO.getPaymentByPurchaseIdAndCustomerId();
	    }
	    */
	    
	       
		request.setAttribute("purchases", purchases);	
		request.getRequestDispatcher("purchases.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
