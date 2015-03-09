package backend;

import java.util.Hashtable; 
import javax.naming.Context; 
import javax.naming.NamingException; 
import javax.naming.directory.DirContext; 
import javax.naming.directory.InitialDirContext; 

public class testLDAP {

	public static void main(String[] args) { 
		Hashtable env = new Hashtable(); 
		env.put(Context.INITIAL_CONTEXT_FACTORY, 
				"com.sun.jndi.ldap.LdapCtxFactory"); 
		env.put(Context.PROVIDER_URL, "ldap://localhost:389"); 
		env.put(Context.SECURITY_AUTHENTICATION, "simple"); 
		env.put(Context.SECURITY_PRINCIPAL, "cn=ldap-admin,dc=test-ldap,dc=net"); 
		env.put(Context.SECURITY_CREDENTIALS, "ldap-admin"); 
		DirContext dirContext; 

		try { 

			dirContext = new InitialDirContext(env); 
			MonObjet objet = (MonObjet) dirContext.lookup("cn=monobject,dc=test-ldap,dc=net"); 

			System.out.println("champ1="+objet.getChamp1()); 
			System.out.println("champ2="+objet.getChamp2()); 

			dirContext.close(); 
		} catch (NamingException e) { 
			System.err.println("Erreur lors de l'acces au serveur LDAP" + e); 
			e.printStackTrace(); 
		} 
		System.out.println("fin des traitements"); 
	} 

}
