package fr.adaming.test;

import java.util.List;

import fr.adaming.dao.IUserDao;
import fr.adaming.dao.UserDaoImpl;
import fr.adaming.model.User;



@SuppressWarnings("unused")
public class ClassTest {
	public static void main(String[] args){
		//IAgentService AgentService = new AgentServiceImpl();
		
		//System.out.println(AgentService.isExistService("vic@gmail.com", "vg"));
	
		IUserDao userDao=new UserDaoImpl();
		//User user1 = new User("GUERIN", "Victor", "victorguerin92@gmail.com", "totor");
		//userDao.ajouterUser(user1);
		
		//userDao.supprimerUser(18);
		
		//User user2 = new User(5, "Totor", "victorguerin92@gmail.com", "totor","GUERIN");
		
		//userDao.modifierUser(user2);
		
		//afficher tout les utilisateurs
		//List<User> liste=userDao.getallUser();
		//for(User user:liste){
		//System.out.println(user);}
		
		 
		//User user3 = userDao.getByIdUser(5);
		//System.out.println(user3);
	}

}
