package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.User;

public interface IUserDao {
	
	public void ajouterUser(User u);
	public void supprimerUser(int id);
	public void modifierUser(User u);
	public List<User> getallUser();
	public  User getByIdUser(int id);
	

}
