package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import factory.FactoryUser;
import middle.User;
import backend.UtilisateurDAO;

@Path("/user")
public class WSApiUser {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
	
	@GET
	@Path("getOneUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserDefault(){
		FactoryUser factory = new FactoryUser();
		return factory.getOneUserWithoutPersist();
	}

	/**
	 * Permet d'obtenir l'id d'un utilisateur grace à ses logins exemple :
	 * /utilisateur/verifylogins/user1login/user1password
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param password
	 *            : le passworde de l'utilisateur
	 * @return du JSon si le fichier existe -1 sinon Exemple : *
	 *         {"userinfoComplementaire"
	 *         :"est un consommateur qui consomme peu","userid"
	 *         :11,"userprenom":"Jacques"
	 *         ,"usernom":"Martin","userlogin":"loginJacques"
	 *         ,"userpassword":"passwordJacques"}
	 */
	@GET
	@Path("/id/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("userid") long userid) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return UtilisateurDAO.getUserById(manager, userid);
	}
	
	
	
	/**
	 * Permet de verifier les indentifants d'un utilisateur grace à ses logins
	 * exemple : /utilisateur/verifylogins/user1login/user1password
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param password
	 *            : le passworde de l'utilisateur
	 * @return true ou false
	 */
	/*@GET
	@Path("/verifylogins/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean verifylogins(@PathParam("login") String login,
			@PathParam("password") String password) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return UtilisateurDAO.verifyUtilisateurDAObyLogins(manager, login,
				password);

	}*/

	/**
	 * Permet d'obtenir l'id d'un utilisateur grace à ses logins exemple :
	 * /utilisateur/verifylogins/user1login/user1password
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param password
	 *            : le passworde de l'utilisateur
	 * @return long > 0 si l'id existe dans la base -1 sinon
	 */
	/*@GET
	@Path("/getidbylogins/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public long getIdByLogins(@PathParam("login") String login,
			@PathParam("password") String password) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return UtilisateurDAO.getIdUtilisateurDAOLogins(manager, login,
				password);
	}
*/
	/**
	 * Permet d'obtenir l'id d'un utilisateur grace à ses logins exemple :
	 * /utilisateur/verifylogins/user1login/user1password
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param password
	 *            : le passworde de l'utilisateur
	 * @return long > 0 si l'id existe dans la base -1 sinon
	 */
	/*@GET
	@Path("/getUserbylogins/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getInformationByLogins(@PathParam("login") String login,
			@PathParam("password") String password) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return UtilisateurDAO.getUtilisateurByLogins(manager, login, password);
	}*/

	/**
	 * Permet d'obtenir l'id d'un utilisateur grace à ses logins exemple :
	 * /utilisateur/verifylogins/user1login/user1password
	 * 
	 * @param login
	 *            : le login de l'utilisateur
	 * @param password
	 *            : le passworde de l'utilisateur
	 * @return du JSon si le fichier existe -1 sinon Exemple : *
	 *         {"userinfoComplementaire"
	 *         :"est un consommateur qui consomme peu","userid"
	 *         :11,"userprenom":"Jacques"
	 *         ,"usernom":"Martin","userlogin":"loginJacques"
	 *         ,"userpassword":"passwordJacques"}
	 */
	/*@GET
	@Path("/id/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("userid") long userid) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		return UtilisateurDAO.getUserById(manager, userid);
	}*/
}