package fr.fms.jdbc;

import fr.fms.dao.ArticleDao;
import fr.fms.entities.Article;

public class ArticleDaoTest {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDao();

        // Test 1: Create article
        Article newArticle = new Article("Laptop", "Dell", 1200.99);
        articleDao.create(newArticle);
        System.out.println("Article crée: " + newArticle.getDescription() + " - " + newArticle.getBrand());

        // Test 2: Read article ID
        int articleId = 1;
        Article readArticle = articleDao.read(articleId);
        if (readArticle != null) {
            System.out.println("Article trouvé: " + readArticle.getDescription() + " - " + readArticle.getBrand() + " - " + readArticle.getPrice());
        } else {
            System.out.println("Article avec l'ID " + articleId + " non trouvé.");
        }

        // Test 3: Update article 
        if (readArticle != null) {
            readArticle.setDescription("nouveau Laptop");
            readArticle.setBrand("HP");
            readArticle.setPrice(1399.99);
            boolean isUpdated = articleDao.update(readArticle);
            if (isUpdated) {
                System.out.println("Article modifié: " + readArticle.getDescription() + " - " + readArticle.getBrand() + " - " + readArticle.getPrice());
            } else {
                System.out.println("Article pas modifié.");
            }
        }

        // Test 4: Delete the article
        if (readArticle != null) {
            boolean isDeleted = articleDao.delete(readArticle);
            if (isDeleted) {
                System.out.println("Article deleted successfully.");
            } else {
                System.out.println("Article deletion failed.");
            }
        }
    }
}
