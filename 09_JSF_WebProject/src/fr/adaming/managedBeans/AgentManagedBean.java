package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;

@ManagedBean(name="agentMB")
@ViewScoped
public class AgentManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String mdp;
	
	
	//instancier un agent service pour utiliser ses methodes
	IAgentService agentService = new AgentServiceImpl();


	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}


	/**
	 * @param mail the mail to set
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
	 * @param password the password to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	/**
	 * 
	 */
	public AgentManagedBean() {
		super();
	}

// Methode pour la connexion
	public String connexion(){
		int verif=agentService.isExistService(this.mail, this.mdp);
		if (verif==1){
			return "succes";
		}else{
			
			return "echec";
		}
	}

	
	
	
}
