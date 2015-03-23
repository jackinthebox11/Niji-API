package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import backend.UtilisateurDAO;
import factory.FactoryCategorie;
import factory.FactoryUser;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		System.out.println("Launch of the Client...");
		FactoryUser factoryuser = new FactoryUser(manager);
		FactoryCategorie factorycat = new FactoryCategorie(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		//factoryuser.generateSomeUsersAndSave();
		factorycat.generateSomeCategoriesAndSave();
		//UtilisateurDAO.addGroupToUser(manager, 10);
		tx.commit();
		System.out.println("Done ...");
	}
}
