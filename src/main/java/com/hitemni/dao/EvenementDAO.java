package com.hitemni.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Evenement;

@Service("evenementI")
@Transactional
public class EvenementDAO implements EvenementI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerEvenement(Evenement evenement) {
		sessionFactory.getCurrentSession().saveOrUpdate(evenement);
	}

	@Override
	public void suprimerEvenement(Evenement evenement) {
		sessionFactory.getCurrentSession().delete(evenement);
	}

	@Override
	public void sauvegarderEvenement(Evenement evenement) {
		sessionFactory.getCurrentSession().saveOrUpdate(evenement);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evenement> listeEvenement() {		
		return sessionFactory.getCurrentSession().createCriteria(Evenement.class).list();
	}

	@Override
	public Evenement getEvenementById(int idEvenement) {
		return (Evenement) sessionFactory.getCurrentSession().get(Evenement.class, idEvenement);
	}

}
