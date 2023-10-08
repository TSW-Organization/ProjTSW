package it.unisa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    	

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Leggi i cookie dalla richiesta
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            String clientSessionToken = null;
            for (Cookie cookie : cookies) {
                if ("sessionToken".equals(cookie.getName())) {
                    clientSessionToken = cookie.getValue();
                    break;
                }
            }

            if (clientSessionToken != null) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    String serverSessionToken = (String) session.getAttribute("sessionToken");

                    if (serverSessionToken != null && serverSessionToken.equals(clientSessionToken)) {
                        request.getRequestDispatcher("checkout.jsp").forward(request, response);
                    } else {
                        // La sessione non è valida, reindirizza l'utente al login o mostra un messaggio di errore
                        response.sendRedirect("login.jsp");
                    }
                } else {
                    // La sessione non esiste, reindirizza l'utente al login
                    response.sendRedirect("login.jsp");
                }
            } else {
                // Il cookie "sessionToken" non è presente, reindirizza l'utente al login
                response.sendRedirect("login.jsp");
            }
        } else {
            // I cookie non sono presenti, reindirizza l'utente al login
            response.sendRedirect("login.jsp");
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
