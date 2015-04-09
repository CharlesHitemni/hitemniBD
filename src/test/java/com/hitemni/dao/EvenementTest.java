package com.hitemni.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Evenement;

public class EvenementTest {
	
	private static ClassPathXmlApplicationContext context;
	private static EvenementI EvenementI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		EvenementI= (EvenementI) context.getBean("evenementI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave() {
		Evenement evenement = new Evenement("desmoulin", new Date(), "JPD", "hitemax");
		evenement.setIdEvenement(400);
		EvenementI.creerEvenement(evenement);
		assertNotNull(evenement.getIdEvenement());
	}
	
	@Test
	public void testFindById() {
		Evenement evenement = EvenementI.getEvenementById(400);
		assertNotNull(evenement);
		assertEquals(400, evenement.getIdEvenement());
		System.out.println(evenement);
	}
	
	@Test
	public void testFindAll() {
		List<Evenement> allEvenement=EvenementI.listeEvenement();
		assertNotNull(allEvenement);
		assertTrue(allEvenement.size() > 0);
		System.out.println(allEvenement);
	}
	
	@Test
	public void testRemove() {
		Evenement evenement = EvenementI.getEvenementById(400);
		EvenementI.suprimerEvenement(evenement);
	}

}
