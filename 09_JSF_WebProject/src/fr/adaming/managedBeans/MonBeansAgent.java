package fr.adaming.managedBeans;

import java.io.Serializable;

import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;

public class MonBeansAgent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	IAgentService AgentService = new AgentServiceImpl();


	/**
	 * 
	 */
	public MonBeansAgent() {
		super();
	}


	/**
	 * @return the agentService
	 */
	public IAgentService getAgentService() {
		return AgentService;
	}


	/**
	 * @param agentService the agentService to set
	 */
	public void setAgentService(IAgentService agentService) {
		AgentService = agentService;
	}
	
	
	
}
