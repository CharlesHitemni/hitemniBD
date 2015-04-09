package com.hitemni.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Technologie;

public class TechnologieTest {
	
	private static ClassPathXmlApplicationContext context;
	private static TechnologieI technologieI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		technologieI= (TechnologieI) context.getBean("technologieI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave() {
		Technologie technologie = new Technologie("spring");
		technologie.setIdTechnologie(400);
		technologieI.creerTechnologie(technologie);
		assertNotNull(technologie.getIdTechnologie());
	}
	
	@Test
	public void testFindById() {
		Technologie technologie = technologieI.getTechnologieById(400);
		assertNotNull(technologie);
		assertEquals(400, technologie.getIdTechnologie());
		System.out.println(technologie);
	}
	
	@Test
	public void testFindAll() {
		List<Technologie> allTechnologie=technologieI.listeTechnologie();
		assertNotNull(allTechnologie);
		assertTrue(allTechnologie.size() > 0);
		System.out.println(allTechnologie);
	}
	
	@Test
	public void testRemove() {
		Technologie technologie = technologieI.getTechnologieById(400);
		technologieI.suprimerTechnologie(technologie);
	}

}
