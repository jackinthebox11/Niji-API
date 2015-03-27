package middle;


import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * Représente un groupe 
 */
 
@javax.persistence.Entity 
public class Groupe  implements Serializable
{
	private long idGroupe;
	private String nomGroupe;
	private Collection<User> users;
	
	public Groupe(){
		
	}
	
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	
	public Groupe(String nomGroupe, Collection<User> users) {
		super();
		this.nomGroupe = nomGroupe;
		this.users = users;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}


	@ManyToMany( mappedBy="groupes")
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
}

