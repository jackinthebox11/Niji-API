package middle;


import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Groupe
{
	private long idGroupe;
	private String nomGroupe;
	private Collection<User> utilisateurs;
	
	public Groupe(){
		
	}
	
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	
	public Groupe(String nomGroupe, Collection<User> utilisateurs) {
		super();
		this.nomGroupe = nomGroupe;
		this.utilisateurs = utilisateurs;
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


	@OneToMany(cascade=CascadeType.PERSIST)
	public Collection<User> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<User> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
}

