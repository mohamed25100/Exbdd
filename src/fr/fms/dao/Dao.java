package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface Dao<T> {

	public Connection connection = BddConnection.getConnection();
	public void create(T obj); // ajout d'une nouvelle occurence en base
	public T read(int id); // renvoi un objet correspondant à l'id en base
	public boolean update(T obj);// met à jour l'objet en base, renvoi vrai si c'est fait
	public boolean delete(T obj);// supprime un objet en base, renvoi vrai si c'est fait
	public ArrayList<T> readAll();// renvoi tous les objets de la table correspondante
}
