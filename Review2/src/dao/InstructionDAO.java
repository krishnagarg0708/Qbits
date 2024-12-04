package dao;

import java.sql.*;
import model.Instruction;
import java.util.ArrayList;
import java.util.List;

public class InstructionDAO {
    public void addInstruction(Instruction instruction) throws SQLException {
        String query = "INSERT INTO instructions (instruction_text) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, instruction.getInstructionText());
            stmt.executeUpdate();
        }
    }

    public Instruction getInstructionById(int id) throws SQLException {
        String query = "SELECT * FROM instructions WHERE instruction_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Instruction(rs.getInt("instruction_id"), rs.getString("instruction_text"));
            }
        }
        return null;
    }

    public List<Instruction> getAllInstructions() throws SQLException {
        List<Instruction> instructions = new ArrayList<>();
        String query = "SELECT * FROM instructions";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                instructions.add(new Instruction(rs.getInt("instruction_id"), rs.getString("instruction_text")));
            }
        }
        return instructions;
    }

    public void deleteInstruction(int id) throws SQLException {
        String query = "DELETE FROM instructions WHERE instruction_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
