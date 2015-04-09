package com.hitemni.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Entreprise;

public class EntrepriseTest {
	
	private static ClassPathXmlApplicationContext context;
	private static EntrepriseI entrepriseI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		entrepriseI= (EntrepriseI) context.getBean("entrepriseI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave() {
		Entreprise entreprise = new Entreprise("Evry", "CA_CF");
		entreprise.setIdEntreprise(400);
		entrepriseI.creerEntreprise(entreprise);
		assertNotNull(entreprise.getIdEntreprise());
	}
	
	@Test
	public void testFindById() {
		Entreprise entreprise = entrepriseI.getEntrepriseById(400);
		assertNotNull(entreprise);
		assertEquals(400, entreprise.getIdEntreprise());
		System.out.println(entreprise);
	}
	
	@Test
	public void testFindAll() {
		//TODO attention marche pas????
		List<Entreprise> allEntreprise=entrepriseI.listeEntreprise();
		assertNotNull(allEntreprise);
		assertTrue(allEntreprise.size() > 0);
		System.out.println(allEntreprise);
	}
	
	@Test
	public void testRemove() {
		Entreprise entreprise = entrepriseI.getEntrepriseById(400);
		entrepriseI.suprimerEntreprise(entreprise);
	}

}
