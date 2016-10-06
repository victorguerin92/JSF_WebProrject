package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.model.User;

public class UserDaoImpl implements IUserDao {

	public static final String urlDb="jdbc:mysql://localhost:3306/dbuser";
	public static final String userDb="root";
	public static final String passwordDb="root";
	
	private Connection cx=null;
	private PreparedStatement ps=null;
	@Override
	public void ajouterUser(User u) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);
			 
			String sqlReq = "INSERT INTO user (prenom,mail,mdp,nom) VALUES (?,?,?,?);";
			
			ps=cx.prepareStatement(sqlReq);
			
			ps.setString(1, u.getPrenom());
			ps.setString(2, u.getMail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getNom());
			
			
			int verif = ps.executeUpdate();
			
			
			if (verif == 1) {
				System.out.println("Tout est ok !");
			} else {
				System.out.println("l'ajout a échoué");
			}
			// Etape 6 Utilisation du resultat

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}

		}
}	

	@Override
	public void supprimerUser(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);

			
			String sqlReq = "DELETE  FROM user WHERE id=? ";

			// Etape 4 : Creation du prepare statement

			ps = cx.prepareStatement(sqlReq);

			// 4.1 Recuperer les parametres

			ps.setInt(1, id);

			// Etape 5 : Envoyer la requete et recuperer le resultat

			int verif = ps.executeUpdate();

			// Etape 6 : Utilisation du resultat

			if (verif == 1) {
				System.out.println("Tout est ok");
			} else {
				System.out.println("La modif a échoué");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

		
	@Override
	public void modifierUser(User u) {
		
		try {
			// Etape 1 : Charger le driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : Etablir la connection
			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);


			// Formuler la requete

			String sqlReq = "UPDATE user SET  prenom=?, mail=?, mdp=?, nom=?  WHERE id=? ";

			// Etape 4 : Creation du prepare statement

			ps = cx.prepareStatement(sqlReq);

			ps.setString(1, u.getPrenom());
			ps.setString(2, u.getMail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getNom());
			ps.setInt(5, u.getId());

			// Etape 5 : Envoyer la requete et recuperer le resultat

			int verif = ps.executeUpdate();

			// Etape 6 : Utilisation du resultat

			if (verif == 1) {
				System.out.println("Tout est ok");
			} else {
				System.out.println("La modif a échoué");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
}
		
	@Override
	public List<User> getallUser() {
		try {
			// 1-Charger le driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2-Creer la connexion

			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);

			// 3-Creer une requete

			String reqSql = " SELECT * FROM user ";

			// 4-Creation du prepare statement
			ps = cx.prepareStatement(reqSql);

			// Etape 5 : Envoyer la requete et recuperer le resultat

			ResultSet rs = ps.executeQuery();

			List<User> listeUsers = new ArrayList<User>();

			while (rs.next()) {
				int id_u = rs.getInt("id");
				String nom_u = rs.getString("nom");
				String prenom_u = rs.getString("prenom");
				String mail_u = rs.getString("mail");
				String mdp_u = rs.getString("mdp");

				User userT = new User(id_u, nom_u, prenom_u,
						mail_u, mdp_u);
				listeUsers.add(userT);
			}
			return listeUsers;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}
		

	@Override
	public User getByIdUser(int id) {
		try {
			// 1-Charger le driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2-Creer la connexion

			cx = DriverManager.getConnection(urlDb, userDb, passwordDb);

			// 3-Creer une requete

			String reqSql = " SELECT * FROM user WHERE id=? ";

			// 4-Creation du prepare statement

			PreparedStatement ps = cx.prepareStatement(reqSql);

			// 4.2 Passer les parametres dans ps

			ps.setInt(1, id);
			// Etape 5 : Envoyer la requete et recuperer le resultat

			ResultSet rs = ps.executeQuery();

			// Etape 6 : Utilisation du resultat
			// obliger rs de sauter la ligne
			rs.next();
			// recup desinfos a partir de rs
			int id_u = rs.getInt("id");
			String nom_u = rs.getString("nom");
			String prenom_u = rs.getString("prenom");
			String mail_u = rs.getString("mail");
			String mdp_u = rs.getString("mdp");
			
			User user1=new User(id_u, nom_u, prenom_u, mail_u, mdp_u);
			return user1;
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (cx != null) {
				try {
					cx.close();
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;}
}

