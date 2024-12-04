package servlet;

import dao.StudentDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ValidateStudent")
public class ValidateStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StudentDAO studentDAO = new StudentDAO();
        try {
            Student student = studentDAO.getStudentByUsername(username);
            if (student != null && student.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("student", student);
                response.sendRedirect("studentDashboard.jsp");
            } else {
                response.sendRedirect("studentLogin.jsp?status=invalid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("studentLogin.jsp?status=error");
        }
    }
}
