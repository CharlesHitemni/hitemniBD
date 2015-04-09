package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.Evenement;


public interface EvenementI {
	
	public void creerEvenement(Evenement evenement);
	public void suprimerEvenement(Evenement evenement);
	public void sauvegarderEvenement(Evenement evenement);
	
	public List<Evenement> listeEvenement();
	public Evenement getEvenementById(int idevenement);
	
}

