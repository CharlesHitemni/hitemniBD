package com.hitemni.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hitemni.model.Utilisateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-config.xml"})
@Transactional
public class utilisateurTest {
	
	@Autowired
	private UtilisateurI utilisateurI;

		
	@Test
	public void testFindById() {
		Utilisateur utilisateur = utilisateurI.getUtilisateurById(1);
		assertNotNull(utilisateur);
		assertEquals(1, utilisateur.getIdUtilisateur());
		System.out.println(utilisateur.getIdUtilisateur());
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
		assertNotNull(utilisateur);
	}

}
