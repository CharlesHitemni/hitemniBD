package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.Technologie;


public interface TechnologieI {
	
	public void creerTechnologie(Technologie technologie);
	public void suprimerTechnologie(Technologie technologie);
	public void sauvegarderTechnologie(Technologie technologie);
	
	public List<Technologie> listeTechnologie();
	public Technologie getTechnologieById(int idTechnologie);
	
}

