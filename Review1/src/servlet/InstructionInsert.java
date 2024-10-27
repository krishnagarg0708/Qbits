package servlet;

import dao.InstructionDAO;
import model.Instruction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/InstructionInsert")
public class InstructionInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String instructionText = request.getParameter("instruction_text");

        Instruction instruction = new Instruction();
        instruction.setInstructionText(instructionText);

        InstructionDAO instructionDAO = new InstructionDAO();
        try {
            instructionDAO.addInstruction(instruction);
            response.sendRedirect("instructions.jsp?status=success");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("instructions.jsp?status=error");
        }
    }
}
