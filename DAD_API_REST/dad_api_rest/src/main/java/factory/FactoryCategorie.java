package factory;

import middle.Categorie;

import javax.persistence.EntityManager;

/**
 * Permet de générer des categories dans la base
 * 
 * @author alex
 */
public class FactoryCategorie {
	private EntityManager manager;

	private Categorie[] tabcat = new Categorie[10];

	// private Categorie categorie1;
	// private Categorie categorie2;
	// private Categorie categorie3;
	public FactoryCategorie() {
	}

	public FactoryCategorie(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Génère des categories avec des nomCategories + numero
	 */
	public void generateSomeCategoriesAndSave() {
		for (int i = 0; i < tabcat.length; i++) {
			tabcat[i] = new Categorie("nomCategorie" + i);
			manager.persist(tabcat[i]);
		}
	}

	/**
	 * Génère des utilisateurs avec des noms et prénom différent suivi d'un
	 * commentaire basique public void generateUsers() { user1 = new
	 * User("Jacques", "Martin", "loginJacques", "passwordJacques",
	 * "est un consommateur qui consomme peu",g); user2 = new User("Laurine",
	 * "Dupont", "loginLaurine", "passwordLaurine",
	 * "est un consommateur qui consomme beaucoup",g); user3 = new User("Toto",
	 * "Plury", "loginToto", "passwordToto",
	 * "est un consommateur qui consomme moyennement",g);
	 * manager.persist(user1); manager.persist(user2); manager.persist(user3); }
	 */

	public static Categorie getOneCategorieWithoutPersist() {
		return new Categorie("nomCategorie1");
	}

}
