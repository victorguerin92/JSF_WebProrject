package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.User;
import fr.adaming.service.IUserService;
import fr.adaming.service.UserServiceImpl;

@ManagedBean(name ="userMB")
@SessionScoped
public class UserManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String password;
	private User user1;
	IUserService userService = new UserServiceImpl();
	List<User> listUsers = userService.getallUserService();

	//

	/**
	 * 
	 */
	public UserManagedBean() {
		user1=new User();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 * the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the user
	 */
	public List<User> getUser() {
		return listUsers;
	}

	/**
	 * @param user
	 * the user to set
	 */
	public void setUser(List<User> user) {
		this.listUsers = user;
	}

	/**
	 * @return the user1
	 */
	public User getUser1() {
		return user1;
	}

	/**
	 * @param user1
	 * the user1 to set
	 */
	public void setUser1(User user1) {
		this.user1 = user1;
	}

	//Methode ajouter pour ajouter un client
	public String ajouter() {
		
		userService.ajouterUserService(user1);
		listUsers = userService.getallUserService();
		return "acceuil";
	}
	
	public String supprimer() {
		userService.supprimerUserService(user1.getId());
		listUsers = userService.getallUserService();
		return "acceuil";
	}
	
	public String modifier() {
	
		userService.modifierUserService(user1);
		listUsers = userService.getallUserService();
		return "acceuil";
	}
}
