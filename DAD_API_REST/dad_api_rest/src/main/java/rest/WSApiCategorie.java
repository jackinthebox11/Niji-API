package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		FactoryCategorie factoryCategorie = new FactoryCategorie();
		return factoryCategorie.getOneCategorieWithoutPersist();
	}
}
