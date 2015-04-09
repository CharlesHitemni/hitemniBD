package com.hitemni.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Entreprise;

@Service("entrepriseI")
@Transactional
public class EntrepriseDAO implements EntrepriseI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerEntreprise(Entreprise entreprise) {
		sessionFactory.getCurrentSession().saveOrUpdate(entreprise);
	}

	@Override
	public void suprimerEntreprise(Entreprise entreprise) {
		sessionFactory.getCurrentSession().delete(entreprise);
	}

	@Override
	public void sauvegarderEntreprise(Entreprise entreprise) {
		sessionFactory.getCurrentSession().saveOrUpdate(entreprise);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entreprise> listeEntreprise() {		
		return sessionFactory.getCurrentSession().createCriteria(Entreprise.class).list();
	}

	@Override
	public Entreprise getEntrepriseById(int idEntreprise) {
		return (Entreprise) sessionFactory.getCurrentSession().get(Entreprise.class, idEntreprise);
	}

}
