package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.Entreprise;


public interface EntrepriseI {
	
	public void creerEntreprise(Entreprise entreprise);
	public void suprimerEntreprise(Entreprise entreprise);
	public void sauvegarderEntreprise(Entreprise entreprise);
	
	public List<Entreprise> listeEntreprise();
	public Entreprise getEntrepriseById(int idEntreprise);
	
}

