package com.hitemni.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Utilisateur;

public class utilisateurTest {
	
	private static ClassPathXmlApplicationContext context;
	private static UtilisateurI utilisateurI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		utilisateurI= (UtilisateurI) context.getBean("utilisateurI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSave() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateurI.creerUtilisateur(utilisateur);
		assertNotNull(utilisateur.getIdUtilisateur());
	}
	
	@Test
	public void testFindById() {
		Utilisateur utilisateur = utilisateurI.getUtilisateurById(1);
		assertNotNull(utilisateur);
		assertEquals(1, utilisateur.getIdUtilisateur());
		System.out.println(utilisateur);
	}

}
