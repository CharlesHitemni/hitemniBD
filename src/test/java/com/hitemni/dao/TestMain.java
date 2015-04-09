package com.hitemni.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Entreprise;


public class TestMain {

	private static ClassPathXmlApplicationContext context;
	private static EntrepriseI entrepriseI;
	
	public static void main(String[] args) {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		entrepriseI= context.getBean(EntrepriseI.class);
		
		List<Entreprise> allEntreprise=entrepriseI.listeEntreprise();
		assertNotNull(allEntreprise);
		assertTrue(allEntreprise.size() > 0);
		System.out.println(allEntreprise);
		
		context.close();

	}

}
