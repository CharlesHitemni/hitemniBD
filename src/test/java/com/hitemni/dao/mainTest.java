package com.hitemni.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Utilisateur;

public class mainTest {
	
	
	private static ClassPathXmlApplicationContext context;
	private static UtilisateurI utilisateurI;
	

	public static void main(String[] args) throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		utilisateurI= (UtilisateurI) context.getBean("utilisateurI");
		Utilisateur utilisateur = utilisateurI.getUtilisateurById(1);
		assertNotNull(utilisateur);
		assertEquals(1, utilisateur.getIdUtilisateur());
		System.out.println(utilisateur);
		context.close();

	}

}
