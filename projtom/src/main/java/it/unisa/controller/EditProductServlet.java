package it.unisa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.bean.Product;
import it.unisa.dao.ProductDAO;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("productName");

        // Modifica: verifica se productPrice non è null prima di convertirlo
        String productPriceParam = request.getParameter("productPrice");
        double price = 0.0; // o un altro valore di default a tua scelta

        if (productPriceParam != null && !productPriceParam.trim().isEmpty()) {
            try {
                price = Double.parseDouble(productPriceParam);
            } catch (NumberFormatException e) {
                // Gestisci l'eccezione in base alle tue esigenze
                e.printStackTrace(); // Stampa l'errore nella console, potresti voler fare altro qui
            }
        } else {
            // Gestisci il caso in cui il parametro sia null o vuoto
        }

        String seller = request.getParameter("productSeller");
        // Altre informazioni da recuperare dalla richiesta...

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        if (product != null) {
            // Aggiorna le informazioni del prodotto
            product.setName(name);
            product.setPrice(price);
            product.setSeller(seller);
            // Aggiorna altre informazioni...

            // Aggiunta di logging
            System.out.println("Product before update: " + product);

            // Salva le modifiche nel database
            productDAO.updateProduct(product);

            // Aggiunta di logging dopo l'aggiornamento
            System.out.println("Product after update: " + product);

            // Puoi anche reindirizzare l'utente a una pagina di conferma o visualizzazione dettagli
            response.sendRedirect("product-details.jsp?productId=" + productId);
        } else {
            // Gestisci il caso in cui il prodotto non sia trovato
            response.sendRedirect("error.jsp");
        }
    }
}
