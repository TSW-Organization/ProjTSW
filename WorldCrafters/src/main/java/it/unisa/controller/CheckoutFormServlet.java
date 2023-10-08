package it.unisa.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.DAO.CartDAO;
import it.unisa.DAO.CartItemDAO;
import it.unisa.DAO.PaymentDAO;
import it.unisa.DAO.ProductDAO;
import it.unisa.DAO.PurchaseDAO;
import it.unisa.DAO.PurchaseItemDAO;
import it.unisa.bean.CartItem;
import it.unisa.bean.Product;


@WebServlet("/CheckoutForm")
public class CheckoutFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkout.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Ottenere i valori dei campi del modulo
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        String accountholder = request.getParameter("accountholder");
        String cardNumber = request.getParameter("cardNumber");
        String expDate = request.getParameter("expDate");
        String cvv = request.getParameter("cvv");
        String error = "";
/*
        // Convalida fullName
        if (fullName == null || fullName.trim().equals("") || !Pattern.matches("^[A-Za-z]+\\s+[A-Za-z]+$", fullName)) {
            error += "Inserisci nome valido<br>";
        } else {
            request.setAttribute("fullName", fullName);
        }

        // Convalida email
        if (email == null || !Pattern.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$", email)) {
            error += "Inserisci email valida<br>";
        } else {
            request.setAttribute("email", email);
        }

        // Convalida address
        if (address == null || !Pattern.matches("^[A-Za-z\\s]+\\s\\d+$", address)) {
            error += "Inserisci un indirizzo valido<br>";
        } else {
            request.setAttribute("address", address);
        }
        
        // Convalida città
        if (city == null || !Pattern.matches("^[A-Za-z\\s]+$", city)) {
            error += "Inserisci una città valida<br>";
        } else {
            request.setAttribute("city", city);
        }
        
        // Convalida stato
        if (state == null || !Pattern.matches("^[A-Za-z\\s]+$", state)) {
            error += "Inserisci uno stato valido<br>";
        } else {
            request.setAttribute("state", state);
        }
           
        // Convalida zipCode
        if (zipCode == null || !Pattern.matches("^\\d{5}$", zipCode)) {
            error += "Inserisci un codice postale valido<br>";
        } else {
            request.setAttribute("zipCode", zipCode);
        }
        
        // Convalida accountholder
        if (accountholder == null || accountholder.trim().equals("") || !Pattern.matches("^[A-Za-z]+\\s+[A-Za-z]+$", accountholder)) {
            error += "Inserisci intestatario valido<br>";
        } else {
            request.setAttribute("accountholder", accountholder);
        }

        // Convalida cardNumber
        if (cardNumber == null || !Pattern.matches("^\\d{4}-?\\d{4}-?\\d{4}-?\\d{4}$", cardNumber)) {
            error += "Inserisci un numero di carta valido<br>";
        } else {
            request.setAttribute("cardNumber", cardNumber);
        }

        // Convalida expDate
        if (expDate == null || !Pattern.matches("^\\d{2}\\/\\d{2}$", expDate)) {
            error += "Inserisci una data di scadenza valida (MM/YYYY)<br>";
        } else {
            request.setAttribute("expDate", expDate);
        }

        // Convalida cvv
        if (cvv == null || !Pattern.matches("^\\d{3}$", cvv)) {
            error += "Inserisci un codice CVV valido<br>";
        } else {
            request.setAttribute("cvv", cvv);
        }
*/
        if (!error.equals("")) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/checkout.jsp").forward(request, response);
        } else {
            // I campi sono validi, puoi inviare i dati al server
            // Aggiungi qui la logica per elaborare i dati inviati dal modulo

        
        	HttpSession session = request.getSession();
        	int userId = (int) session.getAttribute("userId");
        	@SuppressWarnings("unchecked")
        	List<Product> productList = (List<Product>) session.getAttribute("productList");
        	ProductDAO productDAO = new ProductDAO();
        	double amount = 0.0;
        	
        	//Elimino i cartItem associati al cart dell'utente dal db
        	CartItemDAO cartItemDAO = new CartItemDAO();
        	CartDAO cartDAO = new CartDAO();
        	int cartId = cartDAO.getCartByUserId(userId);
        	
        	for(Product item : productList) {
        		productDAO.sellProduct(item.getId(),item.getSelectedQuantity());
        		cartItemDAO.deleteCartItem(cartId, item.getId());
        	}
        	
        	//Elimino il cart dell'utente dal db
        	cartDAO.deleteCart(cartId);
        	
        	
        	//Aggiorno quantity e favorites di product
        	for(Product item : productList) {
        		productDAO.sellProduct(item.getId(),item.getSelectedQuantity());
        		amount += item.getSelectedQuantity() * item.getPrice();
        	}

        	//Creo un payment
        	long currentTimeMillis = System.currentTimeMillis();
            Date currentDate = new Date(currentTimeMillis);
            Time currentTime = new Time(currentTimeMillis);
        	
        	PaymentDAO paymentDAO = new PaymentDAO();
        	int generatedPaymentId = paymentDAO.setPayment(currentDate, currentTime, amount, userId);
        	
        	//Creo un order
        	currentTimeMillis = System.currentTimeMillis();
            currentDate = new Date(currentTimeMillis);
        	
        	PurchaseDAO purchaseDAO = new PurchaseDAO();
        	int generatedPurchaseId = purchaseDAO.setPurchase(currentDate, amount, userId, generatedPaymentId);
        	

        	//Aggiungo gli orderItem nel db e li collego all'order
        	PurchaseItemDAO purchaseItemDAO = new PurchaseItemDAO();
        	for(Product item : productList) {
        		purchaseItemDAO.setOrderItem(item.getSelectedQuantity(), item.getPrice(), item.getId(), generatedPurchaseId);
        	}
        	

            session.removeAttribute("productList");
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/checkout-success.jsp");
            dispatcher.forward(request, response);
        }
        
	}
	
}
