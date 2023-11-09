package it.unisa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.bean.Product;
import it.unisa.dao.AdminDAO;
import it.unisa.dao.CartDAO;
import it.unisa.dao.CartItemDAO;
import it.unisa.dao.UserDAO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String email = request.getParameter("email").trim();
        String password = request.getParameter("password");
        int userId;
        String error = "";
        UserDAO userDAO = new UserDAO();
        AdminDAO adminDAO = new AdminDAO();
        	
		//Se è admin
        if(adminDAO.authenticateEmail(email)==true) {
			
        	request.setAttribute("email", email);
        	if(adminDAO.authenticate(email, password)==true) {
        		
	            HttpSession session = request.getSession();
	            session.setAttribute("isAdmin", true);
	            session.setMaxInactiveInterval(24*60*60);  //Imposta la durata della sessione a 24 ore

	            response.sendRedirect("home");
        	} else {
        		error += "Password errata<br>";
        		request.setAttribute("error", error);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
        	}

		
		//Se è user
		} else {
			
			if (!isValidEmail(email)) {
				error += "Inserisci email valida<br>";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
	        	dispatcher.forward(request, response);
			} else if(userDAO.authenticateEmail(email)==false){	
				error += "Email inesistente<br>";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
	        	dispatcher.forward(request, response);
			} else {
				
				//Email esistente
				request.setAttribute("email", email);
				
				userId = userDAO.authenticate(email,password);
				
				if (userId != -1) {
        
					HttpSession session = request.getSession();    
			        session.setAttribute("userId", userId);
			        session.setMaxInactiveInterval(24*60*60);  //Imposta la durata della sessione a 24 ore

			        CartDAO cartDAO = new CartDAO();
					CartItemDAO cartItemDAO = new CartItemDAO();
					int cartId = cartDAO.getCartByUserId(userId);
					List<Product> productList;

					List<Product> productListDb = cartDAO.getAllCartProducts(cartId);
					
					if(productListDb.size()==0) {
						productList = (List<Product>) session.getAttribute("productList");
							
						//Controllo se é già presente un carrello
						if(cartId == -1) {
							//creo nuovo carrello
							cartId = cartDAO.setCart(userId);
						}
						for(Product product:productList) {
							cartItemDAO.setCartItem(cartId, product.getId(), product.getSelectedQuantity());
						}
			
					}

			        response.sendRedirect("home");
		        } else {
		        	error += "Password errata<br>";
		        	request.setAttribute("error", error);
		        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		        	dispatcher.forward(request, response); // Reindirizza alla pagina di login con un messaggio di errore
		        }
				
			}
			
		}

    }
	
	// Verifica se l'indirizzo email è valido utilizzando una semplice espressione regolare
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
    
}