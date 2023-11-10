package it.unisa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.bean.Payment;
import it.unisa.bean.Product;
import it.unisa.bean.Purchase;
import it.unisa.dao.PaymentDAO;
import it.unisa.dao.ProductDAO;
import it.unisa.dao.PurchaseDAO;


@WebServlet("/purchases")
public class PurchasesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Crea un'istanza di ProductDAO
	    ProductDAO productDAO = new ProductDAO();
		PurchaseDAO purchaseDAO = new PurchaseDAO();
	    PaymentDAO paymentDAO = new PaymentDAO();
	    HttpSession session = request.getSession(false);
	    int userId=-1;
	    Map<Integer, List<Product>> productsByPurchase = new HashMap<>();
	    
	    if(session.getAttribute("userId")!=null) {
	    	userId = (int) session.getAttribute("userId");
	    	List<Purchase> purchases = purchaseDAO.getPurchasesByUserId(userId);
	    	List<Payment> payments = new ArrayList<>();
		    
		    
		    for(Purchase purchase : purchases) {
		    	//Prelevo il metodo di pagamento
		    	int paymentId = purchase.getPaymentId();
		    	Payment payment = paymentDAO.getPaymentByPaymentId(paymentId);
		    	payments.add(payment);
		    	
		    	//Prelevo i prodotti associati all'ordine
		    	List<Product> products = productDAO.getProductsByPurchaseId(purchase.getId());
		    	productsByPurchase.put(purchase.getId(), products);
		    			
		    }
		    
		    
			request.setAttribute("purchases", purchases);
			request.setAttribute("payments", payments);
			request.setAttribute("productsByPurchase", productsByPurchase);
			request.getRequestDispatcher("purchases.jsp").forward(request, response);
	    } else {
	    	response.sendRedirect("login.jsp");
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
