package com.hitemni.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Preference;

@Service("preferenceI")
@Transactional
public class PreferenceDAO implements PreferenceI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerPreference(Preference preference) {
		sessionFactory.getCurrentSession().saveOrUpdate(preference);
	}

	@Override
	public void suprimerPreference(Preference preference) {
		sessionFactory.getCurrentSession().delete(preference);
	}

	@Override
	public void sauvegarderPreference(Preference preference) {
		sessionFactory.getCurrentSession().saveOrUpdate(preference);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Preference> listePreference() {		
		return sessionFactory.getCurrentSession().createCriteria(Preference.class).list();
	}

	@Override
	public Preference getPreferenceById(int idPreference) {
		return (Preference) sessionFactory.getCurrentSession().get(Preference.class, idPreference);
	}

}
