package factory;

import java.util.ArrayList;
import java.util.Collection;







import java.util.Random;

import javax.persistence.EntityManager;








import backend.CategorieDAO;
import backend.GroupeDAO;
import backend.UtilisateurDAO;
import middle.Categorie;
import middle.Groupe;
import middle.User;

/**
 * Permet de générer des utilisateurs dans la base
 * @author samy
 */
public class FactoryUser {
	private EntityManager manager;

	private User[] tabusers = new User[1000];
	private User user1;
	private User user2;
	private User user3;
	public FactoryUser(){
	}
	public FactoryUser(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Génère des utilisateurs avec des prénom et des noms presque identiques
	 * suivi d'un commentaire basique exemple : prenom0, nom0,login0, password0,
	 * commentaire0 prenom1, nom1, login1, password1, commentaire1
	 */
	public void generateSomeUsersAndSave() {
		
		Collection<Categorie> c;
		Groupe g;
		c = CategorieDAO.getCategories(manager);
		for (int i = 0; i < tabusers.length; i++) {
			Random r = new Random();
			long valeur = 1 + r.nextInt(11 - 1);
			tabusers[i] = new User("prenom" + i, "nom " + i, "login" + i,
					"password" + i, "commentaire " + i, GroupeDAO.getGroupeById(manager, valeur), c);
			manager.persist(tabusers[i]);
		}
	}

	/**
	 * Génère des utilisateurs avec des noms et prénom différent suivi d'un
	 * commentaire basique
	 */
	public void generateUsers() {
		Groupe g = new Groupe("groupeAutomatique2");
		user1 = new User("Jacques", "Martin", "loginJacques",
				"passwordJacques", "est un consommateur qui consomme peu",g);
		user2 = new User("Laurine", "Dupont", "loginLaurine",
				"passwordLaurine", "est un consommateur qui consomme beaucoup",g);
		user3 = new User("Toto", "Plury", "loginToto", "passwordToto",
				"est un consommateur qui consomme moyennement",g);
		manager.persist(user1);
		manager.persist(user2);
		manager.persist(user3);
	}
	
	/**
	 * Génère des utilisateurs avec des noms et prénom différent suivi d'un
	 * commentaire basique
	 */
	public void generateUsersWithoutPersist() {
		Groupe g = new Groupe("GroupeAutomatique3");
		user1 = new User("Jacques", "Martin", "loginJacques",
				"passwordJacques", "est un consommateur qui consomme peu",g);
		user2 = new User("Laurine", "Dupont", "loginLaurine",
				"passwordLaurine", "est un consommateur qui consomme beaucoup",g);
		user3 = new User("Toto", "Plury", "loginToto", "passwordToto",
				"est un consommateur qui consomme moyennement",g);
	}
	
	public User getOneUserWithoutPersist(){
		Groupe g = new Groupe("GroupeAutomatique4");
		return new User("Jacques", "Martin", "loginJacques",
				"passwordJacques", "est un consommateur qui consomme peu",g);
	}

}
