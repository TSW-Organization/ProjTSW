package it.unisa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
            // Verifica se l'attributo desiderato è presente nella sessione
            Object userId = session.getAttribute("userId");

            if (userId != null) {
            	if((int) session.getAttribute("userId") != -1) {
            		request.getRequestDispatcher("checkout.jsp").forward(request, response);
            	}
            } else {
            	response.sendRedirect("cart");
            }
        } else {
        	response.sendRedirect("cart");
        }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}