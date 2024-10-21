package fr.fms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class TestJdbcExo2 {

	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");//enregistre la class auprès du driver manager
													// autrement dit : charge le pilote
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2024";
		
		try(Connection connection = DriverManager.getConnection(url, login, password)){//connection de java.sql
			String strSql = "SELECT * FROM T_Articles"; // une fois connecté, réalisation d'une requête
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(strSql)){
					while(resultSet.next()) {
						int rsIdArticle = resultSet.getInt(1);// soit index(de 1 à n) de la colonne, soit le nom de la colonne
						String rsDescription = resultSet.getString(2);
						String rsBrand = resultSet.getString(3);
						double rsPrice = resultSet.getDouble(4);
						articles.add((new Article(rsIdArticle, rsDescription, rsBrand, rsPrice)));
					}
				}
			}
			for (Article a : articles)
				System.out.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
