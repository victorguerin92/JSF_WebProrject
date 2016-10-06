package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.adaming.model.User;
@ManagedBean
@ViewScoped
public class MonBeanUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User u;
		
	/**
	 * @param user1
	 */
	public MonBeanUser(User user1) {
		super();
		
	}

	/**
	 * @return the u
	 */
	public User getU() {
		return u;
	}

	/**
	 * @param u the u to set
	 */
	public void setU(User u) {
		this.u = u;
	}

}
