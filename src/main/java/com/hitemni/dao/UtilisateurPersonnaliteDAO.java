package com.hitemni.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Utilisateur;
import com.hitemni.model.UtilisateurPersonnalite;

@Service("utilisateurPersonnaliteI")
@Transactional
public class UtilisateurPersonnaliteDAO implements UtilisateurPersonnaliteI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerUtilisateurPersonnalite(UtilisateurPersonnalite utilisateurPersonnalite) {
		sessionFactory.getCurrentSession().saveOrUpdate(utilisateurPersonnalite);
	}

	@Override
	public void suprimerUtilisateurPersonnalite(UtilisateurPersonnalite utilisateurPersonnalite) {
		sessionFactory.getCurrentSession().delete(utilisateurPersonnalite);
	}

	@Override
	public void sauvegarderUtilisateurPersonnalite(UtilisateurPersonnalite utilisateurPersonnalite) {
		sessionFactory.getCurrentSession().saveOrUpdate(utilisateurPersonnalite);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UtilisateurPersonnalite> listeUtilisateurPersonnalite() {		
		return sessionFactory.getCurrentSession().createCriteria(UtilisateurPersonnalite.class).list();
	}

	@Override
	public UtilisateurPersonnalite getUtilisateurPersonnaliteById(int idUtilisateurPersonnalite) {
		return (UtilisateurPersonnalite) sessionFactory.getCurrentSession().get(UtilisateurPersonnalite.class, idUtilisateurPersonnalite);
	}

}
