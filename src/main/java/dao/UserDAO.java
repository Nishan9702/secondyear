package dao;

import model.User;
import utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    public boolean insertUser(User user) {

        // Basic validation: prevent null or empty name/email
        if (user == null || user.getName() == null || user.getName().trim().isEmpty()) {
            return false;
        }

        String sql = "INSERT INTO profile (name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName().trim());
            ps.setString(2, user.getEmail().trim());
            ps.setString(3, user.getPassword().trim());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            System.out.println("Insert error: " + e.getMessage());
            return false;
        }
    }



    public List<User> getAllUsers() {


        List<User> users = new ArrayList<>();

        String sql = "SELECT id, name, email, password FROM profile ORDER BY id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {


                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User user = new User(id, name, email, password);

                users.add(user);
            }

        } catch (SQLException e) {

            System.out.println("Fetch all error: " + e.getMessage());
        }

        return users;
    }



    public User getUserById(int id) {

        String sql = "SELECT id, name, email, password FROM profile WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");


                return new User(id, name, email, password);
            }

        } catch (SQLException e) {

            System.out.println("Fetch by ID error: " + e.getMessage());
        }

        return null;
    }
}
