package fr.adaming.managedBeans;

import java.io.Serializable;

import fr.adaming.model.Agent;

public class MonBeansAgent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Agent a;
	

	/**
	 * @return the a
	 */
	public Agent getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(Agent a) {
		this.a = a;
	}
}
