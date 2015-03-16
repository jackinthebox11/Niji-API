package factory;


/**
 * Permet de générer des groupes 
 */
import javax.persistence.EntityManager;

import middle.Groupe;

public class FactoryGroupe {

	private EntityManager manager;

	private Groupe[] tabusers = new Groupe[10];
	private Groupe g1;
	private Groupe g2;
	private Groupe g3;
	
	public FactoryGroupe(){
	}
	public FactoryGroupe(EntityManager manager) {
		this.manager = manager;
	}
	
	
	public Groupe getOneGroupeWithoutPersist(){
		return new Groupe("GroupebyFactory");
	}
}
