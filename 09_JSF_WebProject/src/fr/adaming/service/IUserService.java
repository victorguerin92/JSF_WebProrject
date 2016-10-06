package fr.adaming.service;

import java.util.List;

import fr.adaming.model.User;

public interface IUserService {
	public void ajouterUserService(User u);
	public void supprimerUserService(int id);
	public void modifierUserService(User u);
	public List<User> getallUserService();
	public User getByIdUserService(int id);
}
