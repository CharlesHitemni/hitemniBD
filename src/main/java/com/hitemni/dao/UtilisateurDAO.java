package com.hitemni.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Utilisateur;

@Service("UtilisateurI")
@Transactional
public class UtilisateurDAO implements UtilisateurI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerUtilisateur(Utilisateur u) {
		sessionFactory.getCurrentSession().saveOrUpdate(u);
	}

	@Override
	public void suprimerUtilisateur(Utilisateur utilisateur) {
		sessionFactory.getCurrentSession().delete(utilisateur);
	}

	@Override
	public void sauvegarderUtilisateur(Utilisateur utilisateur) {
		sessionFactory.getCurrentSession().saveOrUpdate(utilisateur);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> listeUtilisateur() {		
		return sessionFactory.getCurrentSession().createCriteria(Utilisateur.class).list();
	}

	@Override
	public Utilisateur getUtilisateurById(int idUtilisateur) {
		return (Utilisateur) sessionFactory.getCurrentSession().get(Utilisateur.class, idUtilisateur);
	}

	@Override
	public Utilisateur getUtilisateurByMail(String mail) {
		return (Utilisateur) sessionFactory.getCurrentSession().createCriteria(Utilisateur.class).add(Restrictions.eq("mail",mail)).uniqueResult();
	}

	@Override
	public List<String> getPositionUtilisateur(int idUtilisateur) {
		List<String> lngLat = new ArrayList<String>();
		Utilisateur utilisateur = getUtilisateurById(idUtilisateur);
		lngLat.add(utilisateur.getLongitude());
		lngLat.add(utilisateur.getLatitude());
		return lngLat;
	}

}
