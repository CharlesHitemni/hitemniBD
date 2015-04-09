package com.hitemni.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Preference;

public class PreferenceTest {
	
	private static ClassPathXmlApplicationContext context;
	private static PreferenceI preferenceI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		preferenceI= (PreferenceI) context.getBean("preferenceI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave() {
		Preference preference = new Preference(true, true,
				true, true,true, true, true, true, true,
				true, true, true);
		preference.setIdPreference(400);
		preferenceI.creerPreference(preference);
		assertNotNull(preference.getIdPreference());
	}
	
	@Test
	public void testFindById() {
		Preference preference = preferenceI.getPreferenceById(400);
		assertNotNull(preference);
		assertEquals(400, preference.getIdPreference());
		System.out.println(preference);
	}
	
	@Test
	public void testFindAll() {
		List<Preference> allPreference=preferenceI.listePreference();
		assertNotNull(allPreference);
		assertTrue(allPreference.size() > 0);
		System.out.println(allPreference);
	}
	
	@Test
	public void testRemove() {
		Preference preference = preferenceI.getPreferenceById(400);
		preferenceI.suprimerPreference(preference);
	}

}
