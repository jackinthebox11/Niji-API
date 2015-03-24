package backend;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import middle.Categorie;
import middle.User;

/**
 *
 * @author alex
 */
public class CategorieDAO {

	private static String queryCat = "SELECT c from Categorie c ";
	
	public static Collection<Categorie> getCategories(EntityManager manager) { 
		try { 
			Collection<Categorie> listeC = manager
				.createQuery(queryCat,Categorie.class)
				.getResultList(); 
			return listeC;
		} catch(NoResultException e) {
			return null;
		}
	}

	private static String queryById = "SELECT c from Categorie c "
			+ "WHERE idCategorie = :idCategorie";
	
	public static Categorie getCategorieById(EntityManager manager, long idCategorie) {
		try {
			Categorie categorie = manager.createQuery(queryById, Categorie.class)
					.setParameter("idCategorie", idCategorie).getSingleResult();
			return categorie;
		} catch (NoResultException e) {
			return null;
		}
	}

}