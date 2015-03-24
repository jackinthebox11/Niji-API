package rest;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import backend.CategorieDAO;
import backend.GroupeDAO;
import middle.Categorie;
import middle.Groupe;
import middle.User;
import factory.FactoryGroupe;
import factory.FactoryUser;


/**
 * Définition des urls permettant d'appeler les fonctions relatives aux groupes
 */
@Path("/groupe")
public class WSApiGroupe {
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
	
	@GET
	@Path("getOneGroupe")
	@Produces(MediaType.APPLICATION_JSON)
	public Groupe getGroupeDefault(){
		FactoryGroupe factoryGroupe = new FactoryGroupe();
		return factoryGroupe.getOneGroupeWithoutPersist();
	}
	
	@GET
	@Path("/id/{idGroupe}")
	@Produces(MediaType.APPLICATION_JSON)
	public Groupe getGroupeById(@PathParam("idGroupe") long idGroupe) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return GroupeDAO.getGroupeById(manager, idGroupe);
	}
	
	@GET
	@Path("getGroupes")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Groupe> getGroupes() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return GroupeDAO.getGroupes(manager);
	}
}
