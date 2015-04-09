package com.hitemni.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Mission;

@Service("missionI")
@Transactional
public class MissionDAO implements MissionI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerMission(Mission mission) {
		sessionFactory.getCurrentSession().saveOrUpdate(mission);
	}

	@Override
	public void suprimerMission(Mission mission) {
		sessionFactory.getCurrentSession().delete(mission);
	}

	@Override
	public void sauvegarderMission(Mission mission) {
		sessionFactory.getCurrentSession().saveOrUpdate(mission);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> listeMission() {		
		return sessionFactory.getCurrentSession().createCriteria(Mission.class).list();
	}

	@Override
	public Mission getMissionById(int idMission) {
		return (Mission) sessionFactory.getCurrentSession().get(Mission.class, idMission);
	}

}
