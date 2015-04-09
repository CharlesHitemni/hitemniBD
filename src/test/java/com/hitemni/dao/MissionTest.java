package com.hitemni.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hitemni.model.Mission;

public class MissionTest {
	
	private static ClassPathXmlApplicationContext context;
	private static MissionI missionI;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context =new ClassPathXmlApplicationContext("spring/application-config.xml");
		missionI= (MissionI) context.getBean("missionI");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	@Test
	public void testSave() {
		Mission mission = new Mission(new Date(), new Date(), "faire les dao", "implementation");
		mission.setIdProjet(400);
		missionI.creerMission(mission);
		assertNotNull(mission.getIdProjet());
	}
	
	@Test
	public void testFindById() {
		Mission mission = missionI.getMissionById(400);
		assertNotNull(mission);
		assertEquals(400, mission.getIdProjet());
		System.out.println(mission);
	}
	
	@Test
	public void testFindAll() {
		List<Mission> allMission=missionI.listeMission();
		assertNotNull(allMission);
		assertTrue(allMission.size() > 0);
		System.out.println(allMission);
	}
	
	@Test
	public void testRemove() {
		Mission mission = missionI.getMissionById(400);
		missionI.suprimerMission(mission);
	}

}
