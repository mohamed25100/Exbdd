package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection {

	static Connection getConnection() {
		Properties prop = null;
		try {
			prop = readPropertiesFile("lib/config.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Class.forName(prop.getProperty("db.driver.class"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = prop.getProperty("db.url");
		String login = prop.getProperty("db.login");
		String password = prop.getProperty("db.password");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

}
