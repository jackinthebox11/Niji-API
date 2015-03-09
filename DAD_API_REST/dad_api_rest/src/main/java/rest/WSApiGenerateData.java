package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import client.Client;
import middle.Groupe;
import factory.FactoryGroupe;


@Path("/GenerateData")
public class WSApiGenerateData {
	
	@GET
	@Path("/main")
	@Produces(MediaType.TEXT_PLAIN)
	public String launchMain(){
		Client.main(null);
		return "C'est fait (message pour afficher quelque chose)";
	}
}
