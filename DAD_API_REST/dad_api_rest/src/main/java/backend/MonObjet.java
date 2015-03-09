package backend;

import java.io.Serializable; 

public class MonObjet implements Serializable { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String champ1; 
	private String champ2; 

	public MonObjet() { 
		super(); 
	} 

	public MonObjet(String champ1, String champ2) { 
		super(); 
		this.champ1 = champ1; 
		this.champ2 = champ2; 
	} 

	public String getChamp1() { 
		return champ1; 
	} 

	public void setChamp1(String champ1) { 
		this.champ1 = champ1; 
	} 

	public String getChamp2() { 
		return champ2; 
	} 

	public void setChamp2(String champ2) { 
		this.champ2 = champ2; 
	} 
} 