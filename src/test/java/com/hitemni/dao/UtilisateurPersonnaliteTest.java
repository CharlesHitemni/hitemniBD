package com.hitemni.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.UtilisateurPersonnalite;

public class UtilisateurPersonnaliteTest {
	
	private static ClassPathXmlApplicationContext context;
	private static UtilisateurPersonnaliteI utilisateurPersonnaliteI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		utilisateurPersonnaliteI= (UtilisateurPersonnaliteI) context.getBean("utilisateurPersonnaliteI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave() {
		UtilisateurPersonnalite utilisateurPersonnalite = new UtilisateurPersonnalite("CA_CF", 2, "etude", "programation");
		utilisateurPersonnalite.setIdUtilisateurPersonnalite(400);
		utilisateurPersonnaliteI.creerUtilisateurPersonnalite(utilisateurPersonnalite);
		assertNotNull(utilisateurPersonnalite.getIdUtilisateurPersonnalite());
	}
	
	@Test
	public void testFindById() {
		UtilisateurPersonnalite utilisateurPersonnalite = utilisateurPersonnaliteI.getUtilisateurPersonnaliteById(400);
		assertNotNull(utilisateurPersonnalite);
		assertEquals(400, utilisateurPersonnalite.getIdUtilisateurPersonnalite());
		System.out.println(utilisateurPersonnalite);
	}
	
	@Test
	public void testFindAll() {
		List<UtilisateurPersonnalite> allutilisateurPersonnalite=utilisateurPersonnaliteI.listeUtilisateurPersonnalite();
		assertNotNull(allutilisateurPersonnalite);
		assertTrue(allutilisateurPersonnalite.size() > 0);
		System.out.println(allutilisateurPersonnalite);
	}
	
	@Test
	public void testRemove() {
		UtilisateurPersonnalite utilisateurPersonnalite = utilisateurPersonnaliteI.getUtilisateurPersonnaliteById(400);
		utilisateurPersonnaliteI.suprimerUtilisateurPersonnalite(utilisateurPersonnalite);
	}

}
