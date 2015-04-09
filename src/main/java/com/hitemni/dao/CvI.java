package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.Cv;


public interface CvI {
	
	public void creerCv(Cv cv);
	public void suprimerCv(Cv cv);
	public void sauvegarderCv(Cv cv);
	
	public List<Cv> listeCv();
	public Cv getCvById(int idCv);
	
}

