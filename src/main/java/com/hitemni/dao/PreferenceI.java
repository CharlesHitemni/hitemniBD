package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.Preference;


public interface PreferenceI {
	
	public void creerPreference(Preference preference);
	public void suprimerPreference(Preference preference);
	public void sauvegarderPreference(Preference preference);
	
	public List<Preference> listePreference();
	public Preference getPreferenceById(int idPreference);
	
}

