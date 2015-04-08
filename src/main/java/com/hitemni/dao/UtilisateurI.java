package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.Utilisateur;


public interface UtilisateurI {
	
	public void creerUtilisateur(Utilisateur u);
	public void suprimerUtilisateur(Utilisateur utilisateur);
	public void sauvegarderUtilisateur(Utilisateur utilisateur);
	
	public List<Utilisateur> listeUtilisateur();
	public Utilisateur getUtilisateurById(int idUtilisateur);
	public Utilisateur getUtilisateurByMail(String mail);
	public List<String> getPositionUtilisateur(int idUtilisateur);
	
}

