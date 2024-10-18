/**
 * Exo 4 : Utilisation de la classe CreateConfigFile pour exploiter la base de données
 *
 */
package fr.fms.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import fr.fms.entities.Article;

import java.sql.ResultSet;

public class TestCreateConfigFile {

	public static void main(String[] args){
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles";
		try {
			//CreateConfigFile.createFile();
			Properties prop = CreateConfigFile.config("lib/config.properties");
			Class.forName(prop.getProperty("db.driver.class"));			
			String url = prop.getProperty("db.url");
			String login = prop.getProperty("db.login");
			String password = prop.getProperty("db.password");
				try(Connection connection = DriverManager.getConnection(url, login, password)){
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(strSql);				
						while(resultSet.next()) {
							int rsIdUser = resultSet.getInt(1);
							String rsDescription = resultSet.getString(2);
							String rsBrand = resultSet.getString(3);
							double rsPrice = resultSet.getDouble(4);
							articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
						}
					articles.forEach((a) -> {System.out.println(a.getId()+ " - " +a.getDescription()+ " - " +a.getBrand()+ " - " +a.getPrice());});
				}
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
	}
	
}