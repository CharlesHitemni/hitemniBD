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
	
	@Test
	public void testCreerUtilisateur() {
		Utilisateur utilisateur = new Utilisateur(); 
		utilisateur.setAge("25");
		utilisateur.setNom("sanat");
		utilisateur.setPrenom("navid");
		utilisateur.setAdressePro("cou");
		utilisateur.setMail("navid...");
		utilisateur.setMotDePasse("dq");
		utilisateur.setLatitude("latitude");
		utilisateur.setLongitude("lng");
		utilisateur.setPromo("df");
		utilisateur.setPhoto("");
		Byte fo = 1;
		utilisateur.setSexe(fo);
		utilisateur.setTelephone("cqq");
		utilisateurI.creerUtilisateur(utilisateur);
		//assertNotNull();
	}

}
