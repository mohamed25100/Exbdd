package fr.fms.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Exo 4 : Classe CreateConfigFile contient méthode pour la création et la lecture d'un fichier config.
 *
 */
public class CreateConfigFile {
	private static FileInputStream fis;
	private static Properties prop = new Properties();
//	public static void createFile() throws IOException{
//		Properties prop = new Properties();
//		prop.put("db.driver.class", "org.mariadb.jdbc.Driver");
//		prop.put("db.url", "jdbc:mariadb://localhost:3306/Shop");
//		prop.put("db.login", "root");
//		prop.put("db.password", "fms2024");
//		String outPutPath = "C:\\Users\\BoucherbaM\\eclipse-workspace\\ExBdd\\lib\\config.properties";
//		FileOutputStream fos = new FileOutputStream(outPutPath);
//		prop.store(fos,"C'est un fichier pour la configuration");
//		System.out.println("Fichier créé !");
//	}
	public static Properties config(String fileName)throws IOException{
		try {
			fis = new FileInputStream(fileName);
			
			prop.load(fis);
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
	         fis.close();
	      }
	return prop;
	}
}