package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.User;
import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IUserService;
import fr.adaming.service.UserServiceImpl;

@ManagedBean(name = "agentMB")
@ViewScoped
public class AgentManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mail;
	private String mdp;
	private List<User> listUsers;

	// instancier un agent service pour utiliser ses methodes
	IAgentService agentService = new AgentServiceImpl();
	IUserService userService = new UserServiceImpl();

	/**
	 * 
	 */
	public AgentManagedBean() {
		listUsers = userService.getallUserService();
		
		
		
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return the listUsers
	 */
	public List<User> getListUsers() {
		return listUsers;
	}

	/**
	 * @param listUsers
	 *            the listUsers to set
	 */
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	// Methode pour la connexion
	public String connexion() {
		int verif = agentService.isExistService(this.mail, this.mdp);
		if (verif == 1) {
			listUsers = userService.getallUserService();
			return "succes";
		} else {

			return "echec";
		}
	}

}
