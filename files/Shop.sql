-- Reconstruction de la base de donnees
DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;

-- construction de la table des articles en vente

CREATE TABLE T_Articles (
	IdArticle		int(4)		PRIMARY KEY AUTO_INCREMENT,
	Description		varchar(30)	NOT NULL,
	Brand			varchar(30)	NOT NULL,
	UnitaryPrice	float(8)	NOT NULL
)ENGINE = InnoDB;


-- Création de la table des catégories
CREATE TABLE T_Categories (
    IdCategory 		INT(4) 			PRIMARY KEY AUTO_INCREMENT,
    CatName			VARCHAR(30)		NOT NULL,
    Description		VARCHAR(100)	NOT NULL
)ENGINE = InnoDB;

INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Souris','Logitoch',65);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Clavier','Microhard',49.5);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Systeme d''exploitation','Fenetres Vistouille',150);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Tapis souris','Chapeau Bleu',5);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Cle USB 8 To','Syno',8);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Laptop','PH',1199);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('CD x 500','CETHE',250);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('DVD-R x 100','CETHE',99);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('DVD+R x 100','CETHE',105);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Batterie Laptop','PH',80);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Casque Audio','Syno',105);
INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('WebCam','Logitoch',755);

SELECT * FROM T_Articles;


-- Insertion de données dans la table des catégories
INSERT INTO T_Categories (CatName,Description) VALUES ('Materiel info','Tout materiel informatique physique en lien avec un ordinateur');
INSERT INTO T_Categories (CatName,Description) VALUES ('Logiciel','Tout logiciel au systeme');
INSERT INTO T_Categories (CatName,Description) VALUES ('Smartphone','Telephone de derniere generation avec ecran tactile + applis');
INSERT INTO T_Categories (CatName,Description) VALUES ('PC','Ordinateur portable ou pas');

ALTER TABLE T_Articles ADD COLUMN IdCategory INT(4);
ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

--Mises à jour de la colonne IdCategory pour la table T_Articles
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 1;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 2;
UPDATE T_Articles SET IdCategory = 2 WHERE IdArticle = 3;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 4;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 5;
UPDATE T_Articles SET IdCategory = 4 WHERE IdArticle = 6;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 7;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 8;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 9;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 10;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 11;
UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle = 12;

INSERT INTO T_Articles ( Description, Brand, UnitaryPrice, IdCategory ) VALUES ( 'Macbook' , 'Apple', 2000, 4);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice, IdCategory ) VALUES ( 'S10' , 'Samsung', 2000, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice, IdCategory ) VALUES ( 'Iphone50' , 'Apple', 20000, 3);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice, IdCategory ) VALUES ( 'Office' , 'Microsoft', 150, 4);
-- mysql -u root -p
-- 1.1 source Shop.sql
-- 1.2 select * from T_Articles;
-- 1.3 DESC T_Articles; || DESCRIBE T_Articles;
-- 1.4 INSERT INTO T_Articles (Description,Brand,UnitaryPrice) VALUES ('Souris','Logitoch',65);
-- 1.5 UPDATE T_Articles SET Brand = 'Logitech' WHERE IdArticle = 1; 
-- 1.6 DELETE FROM T_Articles WHERE IdArticle = 1;
-- 1.7 SELECT * FROM T_Articles WHERE UnitaryPrice > 100;
-- 1.8 SELECT * FROM T_Articles WHERE UnitaryPrice BETWEEN 50 AND 150; ||SELECT * FROM T_Articles WHERE UnitaryPrice >= 50 AND UnitaryPrice <= 150;
-- 1.9 SELECT * FROM T_Articles ORDER BY UnitaryPrice ASC;
-- 1.10 select Description from T_Articles;
-- 1.11 SELECT * FROM T_Articles WHERE UnitaryPrice BETWEEN 50 AND 150;
-- 1.12-13 -- SELECT T_Articles.IdArticle, T_Articles.Description, T_Articles.Brand, T_Articles.UnitaryPrice, T_Categories.CatName FROM T_Articles INNER JOIN T_Categories ON T_Articles.IdCategory = T_Categories.IdCategory WHERE IdArticle>=11 ORDER BY UnitaryPrice ASC;

-- 6
CREATE TABLE T_Users ( 
	IdUser		int(4)		PRIMARY KEY	AUTO_INCREMENT, 
	Login		varchar(20)	NOT NULL,
	Password	varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users ( Login,Password ) VALUES ( 'Mohamed' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Alik' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Natalie' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Remi' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Christophe' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Alexis' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Tarek' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Johanna' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Boujemaa' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Vincent' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Stella' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Tristan' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'Antonny' , '123456');
INSERT INTO T_Users ( Login,Password ) VALUES ( 'David' , '123456');