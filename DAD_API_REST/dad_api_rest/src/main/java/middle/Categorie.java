package middle;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Symbolise une catégorie 
 * @author samy
 */
@Entity
public class Categorie {
	private long idCategorie;
	private String nomCategorie;
	private Collection<User> users;
	
	public Categorie(){
		
	}
	
	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}

	
	public Categorie(String nomCategorie, Collection<User> users) {
		super();
		this.nomCategorie = nomCategorie;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	@ManyToMany(cascade=CascadeType.PERSIST, mappedBy="categories")
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
}
