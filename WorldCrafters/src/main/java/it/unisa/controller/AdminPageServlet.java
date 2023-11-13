package it.unisa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.bean.Admin;
import it.unisa.dao.AdminDAO;

@WebServlet("/admin")
public class AdminPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String email = (String) session.getAttribute("adminEmail");

	    if (email != null && isAdmin(email)) {
	        AdminDAO adminDAO = new AdminDAO();
	        Admin admin = adminDAO.getAdminByEmail(email);
	        session.setAttribute("admin", admin); // Set the admin object in the session

	        // Forward to the admin.jsp
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
	        dispatcher.forward(request, response);
	    } else {
	        // L'amministratore non è autenticato o non è un amministratore, reindirizza alla pagina di login
	        response.sendRedirect("login.jsp");
	    }
	}


    private boolean isAdmin(String email) {
        AdminDAO adminDAO = new AdminDAO();
        return adminDAO.isAdmin(email);
    }
}
