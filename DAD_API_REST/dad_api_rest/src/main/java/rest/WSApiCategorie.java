package rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import backend.CategorieDAO;
import backend.UtilisateurDAO;
import middle.Groupe;
import middle.User;
import middle.Categorie;
import factory.FactoryGroupe;
import factory.FactoryUser;
import factory.FactoryCategorie;

/**
 * Définition des urls permettant d'appeler les fonctions relatives aux catégories
 */
@Path("/categorie")
public class WSApiCategorie {
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
	
	@GET
	@Path("getOneCategorie")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie getCategorieDefault(){
		FactoryCategorie factorycategorie = new FactoryCategorie();
		return factorycategorie.getOneCategorieWithoutPersist();
	}
	
	@GET
	@Path("/id/{idCategorie}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categorie getCategorieById(@PathParam("idCategorie") long idCategorie) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return CategorieDAO.getCategorieById(manager, idCategorie);
	}
	
	@GET
	@Path("getCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categorie> getCategories() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return CategorieDAO.getCategories(manager);
	}
}
