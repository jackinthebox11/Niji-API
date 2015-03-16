package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import client.Client;
import middle.Groupe;
import factory.FactoryGroupe;


/**
 * Permet de générer des données via une url
 */
@Path("/GenerateData")
public class WSApiGenerateData {
	
	@GET
	@Path("/main")
	@Produces(MediaType.TEXT_PLAIN)
	public String launchMain(){
		Client.main(null);
		return "Done)";
	}
}
