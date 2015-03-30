package backend;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import middle.Categorie;
import middle.Groupe;
import middle.User;

public class UtilisateurDAO {
	
	private static String queryrByIdentifiants = "SELECT u FROM User u "
			+ "WHERE  userlogin = :collogin"
			+ " AND userpassword = :colpassword";
	
	private static String queryById = "SELECT u from User u "
			+ " WHERE userid = :userid ";
	
	private static String queryCat = "SELECT c FROM Categorie c "
			+ "WHERE idCategorie = 4";
	
	private static String queryGrp = "SELECT g FROM Groupe g "
			+ "WHERE idGroupe = 2";

	
	/**
	 * Récupère un utilisateur dans la base grace à son id
	 * @param manager
	 * @param userid
	 * @return
	 */
	public static User getUserById(EntityManager manager, long userid) {
		try {
			User user = manager.createQuery(queryById, User.class)
					.setParameter("userid", userid).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/*
	public static boolean verifyUtilisateurDAObyLogins(EntityManager manager,
			String login, String password) {
		List<User> listUser = manager
				.createQuery(queryrByIdentifiants, User.class)
				.setParameter("collogin", login)
				.setParameter("colpassword", password).getResultList();
		if (listUser.size() == 0)
			return false;
		return true;
	}

	public static long getIdUtilisateurDAOLogins(EntityManager manager,
			String login, String password) {
		try {
			User user = manager.createQuery(queryrByIdentifiants, User.class)
					.setParameter("collogin", login)
					.setParameter("colpassword", password).getSingleResult();
			return user.getUserid();
		} catch (NoResultException e) {
			return -1;
		}
	}

	public static User getUtilisateurByLogins(EntityManager manager,
			String login, String password) {
		try {
			User user = manager.createQuery(queryrByIdentifiants, User.class)
					.setParameter("collogin", login)
					.setParameter("colpassword", password).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	*/
	/**
	 * Permet d'ajouter un groupe à un utilisateur
	 * @param manager
	 * @param userid
	 * @param group
	 */
	public static void addGroupToUser(EntityManager manager, long userid){
		Collection<Groupe> groupes;
		groupes = manager.createQuery(queryGrp,Groupe.class).getResultList(); 
		User user = UtilisateurDAO.getUserById(manager, userid);
		user.setGroupes(groupes);
		manager.persist(user);
	}
	
	public static void addCategorieToUser(EntityManager manager, long userid, Collection<Categorie> categories){
		categories = manager.createQuery(queryCat,Categorie.class).getResultList();
		User user = UtilisateurDAO.getUserById(manager, userid);
		user.setCategories(categories);
		manager.persist(user);
	}
	
	public static Collection<Groupe> addGroup(EntityManager manager){
		Collection<Groupe> groupes;
		groupes = manager.createQuery(queryGrp,Groupe.class).getResultList(); 
		return groupes;
		
	}
	
	public static Collection<Categorie> addCategorie(EntityManager manager){
		Collection<Categorie> categories;
		categories = manager.createQuery(queryCat,Categorie.class).getResultList(); 
		return categories;
		
	}
	
}
