package fr.adaming.service;

import fr.adaming.dao.AgentDaoImpl;
import fr.adaming.dao.IAgentDao;

public class AgentServiceImpl implements IAgentService{

	IAgentDao agentDao=new AgentDaoImpl();
	@Override
	public int isExistService(String login, String mdp) {
		
		int i=agentDao.isExist(login,mdp);
		return i;
	}
	

}
