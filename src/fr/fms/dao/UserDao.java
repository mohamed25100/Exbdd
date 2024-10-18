package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.User;

public class UserDao implements Dao<User> {

	@Override
	public void create(User obj) {
		try(Connection conn = BddConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO T_Users (Login, Password) VALUES (?, ?)")) {
				ps.setString(1, obj.getLogin());
				ps.setString(2, obj.getPassword());
				ps.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	}

	@Override
	public User read(int id) {
		User user = null;
        try (Connection conn = BddConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM T_Users WHERE IdUser = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("IdUser"),
                        rs.getString("Login"),
                        rs.getString("Password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
	}

	@Override
	public boolean update(User obj) {
		boolean isUpdated = false;
        try (Connection conn = BddConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE T_Users SET Login = ?, Password = ? WHERE IdUser = ?")) {
            ps.setString(1, obj.getLogin());
            ps.setString(2, obj.getPassword());
            ps.setInt(3, obj.getId());

            int rowsUpdated = ps.executeUpdate();
            isUpdated = rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
	}

	@Override
	public boolean delete(User obj) {
		boolean isDeleted = false;
        try (Connection conn = BddConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM T_Users WHERE IdUser = ?")) {
            ps.setInt(1, obj.getId());

            int rowsDeleted = ps.executeUpdate();
            isDeleted = rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<>();
        try (Connection conn = BddConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_Users");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                User user = new User(
                        rs.getInt("IdUser"),
                        rs.getString("Login"),
                        rs.getString("Password")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
	}

}
