package com.hitemni.dao;

import java.util.List;

import com.hitemni.model.Mission;


public interface MissionI {
	
	public void creerMission(Mission mission);
	public void suprimerMission(Mission mission);
	public void sauvegarderMission(Mission mission);
	
	public List<Mission> listeMission();
	public Mission getMissionById(int idMission);
	
}

