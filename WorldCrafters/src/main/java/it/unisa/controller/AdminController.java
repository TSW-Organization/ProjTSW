package it.unisa.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.DAO.ProductDAO;
import it.unisa.bean.Product;

public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Verifica l'autenticazione dell'amministratore
        // Questo è un esempio semplice, dovresti implementare l'autenticazione adeguata.

        if (!isAdminAuthenticated(request)) {
            // Se l'amministratore non è autenticato, reindirizzalo a una pagina di login
            response.sendRedirect("admin-login.jsp");
            return;
        }

        // Ottieni l'azione richiesta dall'amministratore
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("modifyProduct")) {
                // Implementa la logica per la modifica del prodotto
            } else if (action.equals("viewOrders")) {
                // Implementa la logica per visualizzare gli ordini
            } else if (action.equals("deleteProduct")) {
                // Implementa la logica per la cancellazione del prodotto
            } else {
                // Gestisci altre azioni
            }
        }

        // Recupera la lista dei prodotti dal ProductDAO
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();

        // Imposta l'attributo "products" nella richiesta
        request.setAttribute("products", products);

        // Esegui il reindirizzamento con sendRedirect()
        response.sendRedirect("admin-home.jsp");
    }

    private boolean isAdminAuthenticated(HttpServletRequest request) {
        // Implementa la logica di autenticazione dell'amministratore.
        // Restituisci true se l'amministratore è autenticato, altrimenti false.
        // Dovresti gestire le sessioni o altri meccanismi di autenticazione qui.
        return true; // Esempio semplice, dovresti migliorarlo.
    }
}
