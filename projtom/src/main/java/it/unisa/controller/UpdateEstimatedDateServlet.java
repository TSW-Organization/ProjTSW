package it.unisa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.dao.PurchaseDAO;

@WebServlet("/updateEstimatedDate")
public class UpdateEstimatedDateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int purchaseId = Integer.parseInt(request.getParameter("purchaseId"));

        // Chiamata al metodo nel tuo PurchaseDAO per aggiornare la data stimata
        PurchaseDAO purchaseDAO = new PurchaseDAO();
        purchaseDAO.updateEstimatedDate(purchaseId);

        // Puoi restituire una risposta se necessario
        response.getWriter().write("Data stimata aggiornata con successo");
    }
}
