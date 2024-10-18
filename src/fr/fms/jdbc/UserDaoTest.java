package fr.fms.jdbc;

import fr.fms.dao.UserDao;
import fr.fms.entities.User;

public class UserDaoTest {
	public static void main(String[] args) {
		
        // Test: Create a new user
        UserDao userDao = new UserDao();
        User newUser = new User("newUser", "password123");
        userDao.create(newUser);
        System.out.println("Utilisateur crée!");
        
		
     // Test: Read a user with ID
        int id = 12;
        User userRead = userDao.read(id);
        if (userRead != null) {
            System.out.println("Utilisateur trouvé: " + userRead.getLogin() + ", " + userRead.getPassword());
        } else {
            System.out.println("Utilisateur avec ID "+id+" non trouvé.");
        }
		
        // Test: Update a user
        if (userRead != null) { // Assurer que l'utilisateur a été trouvé
            userRead.setLogin("updatedUser");
            userRead.setPassword("newPassword456");
            boolean isUpdated = userDao.update(userRead);
            if (isUpdated) {
                System.out.println("Utilisateur mis à jour: " + userRead.getLogin() + ", " + userRead.getPassword());
            } else {
                System.out.println("Échec de la mise à jour utilisateur.");
            }
        }
        
        // delete
        boolean isDeleted = userDao.delete(userRead);
        if (isDeleted) {
            System.out.println("Utilisateur supprimé avec succès.");
        } else {
            System.out.println("La suppression de l'utilisateur a échoué.");
        }
	}
}
