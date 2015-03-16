package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		
}
