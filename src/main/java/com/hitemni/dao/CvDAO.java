package com.hitemni.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitemni.model.Cv;

@Service("cvI")
@Transactional
public class CvDAO implements CvI{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void creerCv(Cv cv) {
		sessionFactory.getCurrentSession().saveOrUpdate(cv);
	}

	@Override
	public void suprimerCv(Cv cv) {
		sessionFactory.getCurrentSession().delete(cv);
	}

	@Override
	public void sauvegarderCv(Cv cv) {
		sessionFactory.getCurrentSession().saveOrUpdate(cv);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cv> listeCv() {		
		return sessionFactory.getCurrentSession().createCriteria(Cv.class).list();
	}

	@Override
	public Cv getCvById(int idCv) {
		return (Cv) sessionFactory.getCurrentSession().get(Cv.class, idCv);
	}

}
