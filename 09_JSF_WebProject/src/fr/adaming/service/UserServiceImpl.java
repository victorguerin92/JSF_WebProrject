package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IUserDao;
import fr.adaming.dao.UserDaoImpl;
import fr.adaming.model.User;

public class UserServiceImpl implements IUserService{
	IUserDao userDao=new UserDaoImpl();
	
	public void ajouterUserService(User u) {
		userDao.ajouterUser(u);
	}
	public void supprimerUserService(int id) {
		userDao.supprimerUser(id);
	}
	public void modifierUserService(User u) {
		userDao.modifierUser(u);
	}
	public List<User> getallUserService() {
		List<User> list=userDao.getallUser();
 		return list;
	}
	public User getByIdUserService(int id) {
		
		return userDao.getByIdUser(id);
	} 
		
		
	

}
