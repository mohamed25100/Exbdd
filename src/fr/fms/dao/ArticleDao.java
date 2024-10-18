package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	@Override
	public void create(Article obj) {
		try (Connection conn = BddConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(
	                     "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?)")) {
				ps.setString(1, obj.getDescription());
				ps.setString(2, obj.getBrand());
				ps.setDouble(3, obj.getPrice());
				ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public Article read(int id) {
		Article article = null;
	    try (Connection conn = BddConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(
	                 "SELECT * FROM T_Articles WHERE IdArticle = ?")) {
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            article = new Article(
	                    rs.getInt("IdArticle"),
	                    rs.getString("Description"),
	                    rs.getString("Brand"),
	                    rs.getDouble("UnitaryPrice")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return article;
	}

	@Override
	public boolean update(Article obj) {
		boolean isUpdated = false;
	    try (Connection conn = BddConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(
	                 "UPDATE T_Articles SET Description = ?, Brand = ?, UnitaryPrice = ? WHERE IdArticle = ?")) {
	        ps.setString(1, obj.getDescription());
	        ps.setString(2, obj.getBrand());
	        ps.setDouble(3, obj.getPrice());
	        ps.setInt(4, obj.getId());

	        int rowsUpdated = ps.executeUpdate();
	        isUpdated = rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isUpdated;
	}

	@Override
	public boolean delete(Article obj) {
		boolean isDeleted = false;
	    try (Connection conn = BddConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement("DELETE FROM T_Articles WHERE IdArticle = ?")) {
	        ps.setInt(1, obj.getId());

	        int rowsDeleted = ps.executeUpdate();
	        isDeleted = rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return isDeleted;
	}

	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> articles = new ArrayList<>();
        try (Connection conn = BddConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM T_Articles");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Article article = new Article(
                        rs.getInt("IdArticle"),
                        rs.getString("Description"),
                        rs.getString("Brand"),
                        rs.getDouble("UnitaryPrice")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
	}

}
