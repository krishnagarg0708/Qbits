package servlet;

import dao.AdminDAO;
import model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ValidateAdmin")
public class ValidateAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDAO adminDAO = new AdminDAO();
        try {
            Admin admin = adminDAO.getAdminByUsername(username);
            if (admin != null && admin.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("adminLogin.jsp?status=invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("adminLogin.jsp?status=error");
        }
    }
}

