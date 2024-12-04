package dao;

import java.sql.*;
import model.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    public void addQuestion(Question question) throws SQLException {
        String query = "INSERT INTO questions (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, question.getQuizId());
            stmt.setString(2, question.getQuestionText());
            stmt.setString(3, question.getOptionA());
            stmt.setString(4, question.getOptionB());
            stmt.setString(5, question.getOptionC());
            stmt.setString(6, question.getOptionD());
            stmt.setString(7, question.getCorrectOption());
            stmt.executeUpdate();
        }
    }

    public Question getQuestionById(int id) throws SQLException {
        String query = "SELECT * FROM questions WHERE question_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Question(rs.getInt("question_id"), rs.getInt("quiz_id"), rs.getString("question_text"),
                        rs.getString("option_a"), rs.getString("option_b"), rs.getString("option_c"),
                        rs.getString("option_d"), rs.getString("correct_option"));
            }
        }
        return null;
    }

    public List<Question> getAllQuestions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM questions";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                questions.add(new Question(rs.getInt("question_id"), rs.getInt("quiz_id"), rs.getString("question_text"),
                        rs.getString("option_a"), rs.getString("option_b"), rs.getString("option_c"),
                        rs.getString("option_d"), rs.getString("correct_option")));
            }
        }
        return questions;
    }

    public void deleteQuestion(int id) throws SQLException {
        String query = "DELETE FROM questions WHERE question_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
