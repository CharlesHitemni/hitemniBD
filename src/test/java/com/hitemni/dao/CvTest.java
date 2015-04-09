package com.hitemni.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Cv;

public class CvTest {
	
	private static ClassPathXmlApplicationContext context;
	private static CvI cvI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		cvI= (CvI) context.getBean("cvI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave() {
		//TODO marche pas parce que cv non existant dans un utilisateur
		Cv cv = new Cv(new Date(), "cv pour ca_cf");
		cv.setId_CV(400);
		cvI.creerCv(cv);
		assertNotNull(cv.getId_CV());
	}
	
	@Test
	public void testFindById() {
		Cv cv = cvI.getCvById(400);
		assertNotNull(cv);
		assertEquals(400, cv.getId_CV());
		System.out.println(cv);
	}
	
	@Test
	public void testFindAll() {
		List<Cv> allCv=cvI.listeCv();
		assertNotNull(allCv);
		assertTrue(allCv.size() > 0);
		System.out.println(allCv);
	}
	
	@Test
	public void testRemove() {
		Cv cv = cvI.getCvById(400);
		cvI.suprimerCv(cv);
	}

}
