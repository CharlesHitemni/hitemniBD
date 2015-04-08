package com.hitemni.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Utilisateur;

@Service
@Transactional
public class UtilisateurDAO implements UtilisateurI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void creerUtilisateur(Utilisateur u) {
		sessionFactory.getCurrentSession().saveOrUpdate(u);
	}

	@Override
	@Transactional
	public void suprimerUtilisateur(Utilisateur utilisateur) {
		sessionFactory.getCurrentSession().delete(utilisateur);
	}

	@Override
	@Transactional
	public void sauvegarderUtilisateur(Utilisateur utilisateur) {
		sessionFactory.getCurrentSession().saveOrUpdate(utilisateur);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Utilisateur> listeUtilisateur() {		
		return sessionFactory.getCurrentSession().createCriteria(Utilisateur.class).list();
	}

	@Override
	@Transactional
	public Utilisateur getUtilisateurById(int idUtilisateur) {
		return (Utilisateur) sessionFactory.getCurrentSession().get(Utilisateur.class, idUtilisateur);
	}

	@Override
	@Transactional
	public Utilisateur getUtilisateurByMail(String mail) {
		return (Utilisateur) sessionFactory.getCurrentSession().createCriteria(Utilisateur.class).add(Restrictions.eq("mail",mail)).uniqueResult();
	}

	@Override
	@Transactional
	public List<String> getPositionUtilisateur(int idUtilisateur) {
		List<String> lngLat = new ArrayList<String>();
		Utilisateur utilisateur = getUtilisateurById(idUtilisateur);
		lngLat.add(utilisateur.getLongitude());
		lngLat.add(utilisateur.getLatitude());
		return lngLat;
	}

}
