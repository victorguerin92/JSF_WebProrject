package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AgentDaoImpl implements IAgentDao {
	
	public static final String urlDb="jdbc:mysql://localhost:3306/dbuser";
	public static final String userDb="root";
	public static final String passwordDb="root";
	
	private Connection cx=null;
	private PreparedStatement ps=null;
	
	@Override
	public int isExist(String login, String mdp) {
		
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);
			 
			String sqlReq = "SELECT count(id) from agents where mail=? and mdp=?";
			
			ps=cx.prepareStatement(sqlReq);
			
			ps.setString(1, login);
			ps.setString(2,mdp);
			
			ResultSet rs= ps.executeQuery();
			
			rs.next();
			return rs.getInt(1);
			
			}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			finally{
					try {
						cx.close();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}				
		return 0;	
			
		}	
}
