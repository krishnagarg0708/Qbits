package servlet;

import dao.StudentDAO;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/StudentInsert")
public class StudentInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setEmail(email);

        StudentDAO studentDAO = new StudentDAO();
        try {
            studentDAO.addStudent(student);
            response.sendRedirect("studentLogin.jsp?status=registered");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?status=error");
        }
    }
}
