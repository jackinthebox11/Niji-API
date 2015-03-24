package backend;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import middle.Categorie;
import middle.User;
import middle.Groupe;

/**
 *
 * @author alex
 */
public class GroupeDAO {

private static String queryGrp = "SELECT g from Groupe g ";
	
	public static Collection<Groupe> getGroupes(EntityManager manager) { 
		try { 
			Collection<Groupe> listeG = manager
				.createQuery(queryGrp,Groupe.class)
				.getResultList(); 
			return listeG;
		} catch(NoResultException e) {
			return null;
		}
	}

	private static String queryById = "SELECT g from Groupe g "
			+ "WHERE idGroupe = :idGroupe";
	
	public static Groupe getGroupeById(EntityManager manager, long idGroupe) {
		try {
			Groupe groupe = manager.createQuery(queryById, Groupe.class)
					.setParameter("idCategorie", idGroupe).getSingleResult();
			return groupe;
		} catch (NoResultException e) {
			return null;
		}
	}

}
