package middle;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * Représente un utilisateur
 */
@Entity
public class User {

	private long userid;
	private String userprenom;
	private String usernom;
	private String userlogin;
	private String userpassword;
	private String userinfoComplementaire;
	private Groupe groupe;
	private Collection<Categorie> categories;
	
	public User() {

	}
	
	public User(String userprenom, String usernom, String userlogin,
			String userpassword, String userinfoComplementaire, Groupe groupe) {
		super();
		this.userprenom = userprenom;
		this.usernom = usernom;
		this.userlogin = userlogin;
		this.userpassword = userpassword;
		this.userinfoComplementaire = userinfoComplementaire;
		this.groupe = groupe;
	}
	
	
	

	public User(String userprenom, String usernom, String userlogin,
			String userpassword, String userinfoComplementaire, Groupe groupe,
			Collection<Categorie> categories) {
		super();
		this.userprenom = userprenom;
		this.usernom = usernom;
		this.userlogin = userlogin;
		this.userpassword = userpassword;
		this.userinfoComplementaire = userinfoComplementaire;
		this.groupe = groupe;
		this.categories = categories;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUserprenom() {
		return userprenom;
	}

	public void setUserprenom(String userprenom) {
		this.userprenom = userprenom;
	}

	public String getUsernom() {
		return usernom;
	}

	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}

	public String getUserinfoComplementaire() {
		return userinfoComplementaire;
	}

	public void setUserinfoComplementaire(String userinfoComplementaire) {
		this.userinfoComplementaire = userinfoComplementaire;
	}

	public String getUserlogin() {
		return userlogin;
	}

	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "idGroupe")
	@JsonManagedReference
	public Groupe getGroupe() {
		return groupe;
	}

	public Groupe setGroupe(Groupe groupe) {
		return this.groupe = groupe;
	}

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name = "User_Categorie",
			joinColumns = @JoinColumn(name="userId"),
			inverseJoinColumns = @JoinColumn(name="idCategorie")
			)
	@JsonManagedReference
	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}
	
}
