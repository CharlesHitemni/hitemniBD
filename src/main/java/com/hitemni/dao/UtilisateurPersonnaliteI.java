package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.UtilisateurPersonnalite;


public interface UtilisateurPersonnaliteI {
	
	public void creerUtilisateurPersonnalite(UtilisateurPersonnalite utilisateurPersonnalite);
	public void suprimerUtilisateurPersonnalite(UtilisateurPersonnalite utilisateurPersonnalite);
	public void sauvegarderUtilisateurPersonnalite(UtilisateurPersonnalite utilisateurPersonnalite);
	
	public List<UtilisateurPersonnalite> listeUtilisateurPersonnalite();
	public UtilisateurPersonnalite getUtilisateurPersonnaliteById(int idutilisateurPersonnalite);
	
}

