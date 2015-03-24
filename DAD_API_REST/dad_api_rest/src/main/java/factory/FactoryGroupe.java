package factory;


/**
 * Permet de générer des groupes 
 */
import javax.persistence.EntityManager;

import middle.Categorie;
import middle.Groupe;

public class FactoryGroupe {

	private EntityManager manager;

	private Groupe[] tabgrp = new Groupe[10];
	
	public FactoryGroupe(){
	}
	public FactoryGroupe(EntityManager manager) {
		this.manager = manager;
	}
	
	/**
	 * Génère des groupes avec des nomGroupes + numero
	 */
	public void generateSomeGroupesAndSave() {
		for (int i = 0; i < tabgrp.length; i++) {
			tabgrp[i] = new Groupe("nomGroupe" + i);
			manager.persist(tabgrp[i]);
		}
	}
	
	public Groupe getOneGroupeWithoutPersist(){
		return new Groupe("nomGroupe2");
	}
}
