package com.hitemni.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Technologie;

@Service("technologieI")
@Transactional
public class TechnologieDAO implements TechnologieI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerTechnologie(Technologie technologie) {
		sessionFactory.getCurrentSession().saveOrUpdate(technologie);
	}

	@Override
	public void suprimerTechnologie(Technologie technologie) {
		sessionFactory.getCurrentSession().delete(technologie);
	}

	@Override
	public void sauvegarderTechnologie(Technologie technologie) {
		sessionFactory.getCurrentSession().saveOrUpdate(technologie);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Technologie> listeTechnologie() {		
		return sessionFactory.getCurrentSession().createCriteria(Technologie.class).list();
	}

	@Override
	public Technologie getTechnologieById(int idTechnologie) {
		return (Technologie) sessionFactory.getCurrentSession().get(Technologie.class, idTechnologie);
	}

}
