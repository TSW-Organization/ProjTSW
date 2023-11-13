package it.unisa.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());
	
	private static final String LOGIN = "/login.jsp";
	private static final String EMAIL = "email";
	private static final String ERROR = "error";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doPost(request, response);
        } catch (ServletException se) {
        	logger.log(Level.WARNING, se.getMessage());
    	} catch (IOException e) {
    		logger.log(Level.WARNING, e.getMessage());
    	}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String email = request.getParameter(EMAIL).trim();
        String password = request.getParameter("password");
        AdminDAO adminDAO = new AdminDAO();
        	
        // Se è admin
        if(adminDAO.authenticateEmail(email)) {
            System.out.println("Email is authenticated as admin.");
            caseAdmin(request, response, email, password);
        } else {
            // Aggiungi messaggio di debug
            System.out.println("Email is not authenticated as admin.");

            // Controllo se è un utente
            if(checkIfUser(request, response, email)) {
                caseUser(request, response, email, password);
            }   
        }
    }
	
	// Verifica se l'indirizzo email è valido utilizzando una semplice espressione regolare
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
    
    private void caseAdmin(HttpServletRequest request, HttpServletResponse response, String email, String password) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        String error = "";
        request.setAttribute(EMAIL, email);

        // Stampa i valori di email e password per debug
        System.out.println("Trying to authenticate as admin with email: " + email + " and password: " + password);

        // Verifica sia l'indirizzo email che la password
        if (adminDAO.authenticate(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("isAdmin", true);
            session.setAttribute("adminEmail", email); // Aggiunto per memorizzare l'email dell'amministratore
            session.setMaxInactiveInterval(24 * 60 * 60); // Imposta la durata della sessione a 24 ore

            System.out.println("Successfully authenticated as admin.");

            Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");

            if (isAdmin != null && isAdmin) {
                try {
                    // Reindirizza alla servlet dell'area amministratore invece di admin.jsp
                    response.sendRedirect("admin");
                    return; // Importante: termina la funzione dopo il reindirizzamento
                } catch (IOException e) {
                    logger.log(Level.WARNING, e.getMessage());
                }
            }
            // Aggiungi messaggi di debug
            System.out.println("Autenticazione riuscita. Utente è admin: " + isAdmin);
        } else {
            System.out.println("Authentication failed for email: " + email + ". Redirecting to login page.");
            // Gestisci il caso in cui isAdmin è diverso da true o non presente
            error = "Accesso non autorizzato<br>";
            request.setAttribute(ERROR, error);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(LOGIN);
            dispatcher.forward(request, response);
        }
    }

    private boolean checkIfUser(HttpServletRequest request, HttpServletResponse response, String email) {
    	
    	UserDAO userDAO = new UserDAO();
    	String error = "";
    	boolean isUser = true;
    	
        if (!isValidEmail(email)) {
            error = "Inserisci email valida<br>";
            request.setAttribute(ERROR, error);
        } else if(!userDAO .authenticateEmail(email)){	
			error = "Email inesistente<br>";
			request.setAttribute(ERROR, error);
		}
        
        if(!error.equals("")) {
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(LOGIN);
        	try {
        		dispatcher.forward(request, response);
            } catch (ServletException se) {
            	logger.log(Level.WARNING, se.getMessage());
        	} catch (IOException e) {
        		logger.log(Level.WARNING, e.getMessage());
        	}
        	isUser = false;
        }

        return isUser;
    }
    
	private void caseUser(HttpServletRequest request, HttpServletResponse response, String email, String password) {
    	
    	request.setAttribute(EMAIL, email);
    	UserDAO userDAO = new UserDAO();
    	int userId = userDAO.authenticate(email,password);
    	
    	if (userId != -1) {

    	    HttpSession session = request.getSession();    
    	    session.setAttribute("userId", userId);
    	    session.setMaxInactiveInterval(24*60*60);  //Imposta la durata della sessione a 24 ore
    	    
    	    retrieveCart(session, userId);

    	    try {
    	        response.sendRedirect("home");
    	    } catch (IOException e) {
    	    	logger.log(Level.WARNING, e.getMessage());
    	    }
    	    
    	} else {
    	    String error = "Password errata<br>";
    	    request.setAttribute(ERROR, error);
    	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(LOGIN);
    	    try {
    	        dispatcher.forward(request, response); // Reindirizza alla pagina di login con un messaggio di errore
    	    } catch (ServletException se) {
    	    	logger.log(Level.WARNING, se.getMessage());
    	    } catch (IOException e) {
    	    	logger.log(Level.WARNING, e.getMessage());
    	    }
    	}
    	
    }
    
	@SuppressWarnings("unchecked")
    private void retrieveCart(HttpSession session, int userId) {
    	
    	CartDAO cartDAO = new CartDAO();
	    CartItemDAO cartItemDAO = new CartItemDAO();
	    int cartId = cartDAO.getCartByUserId(userId);
	    List<Product> productList = null;
	    List<Product> productListDb = cartDAO.getAllCartProducts(cartId);
	    
	    if(productListDb.isEmpty()) {
	        productList = (List<Product>) session.getAttribute("productList");
	            
	        //Controllo se é già presente un carrello
	        if(cartId == -1) {
	            //creo nuovo carrello
	            cartId = cartDAO.setCart(userId);
	        }
	        if(productList!=null) {
	        	for(Product product:productList) {
		            cartItemDAO.setCartItem(cartId, product.getId(), product.getSelectedQuantity());
		        }
	        }
	    }
    }
   
    
}