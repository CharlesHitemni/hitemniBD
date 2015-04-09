package com.hitemni.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
@Table(name="entreprise")
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_entreprise", unique=true, nullable=false)
	private int idEntreprise;

	@Column(nullable=false, length=45)
	private String adresse;

	@Column(nullable=false, length=45)
	private String nom;

	//bi-directional many-to-many association to Cv
	@ManyToMany(mappedBy="entreprises", fetch=FetchType.EAGER)
	private List<Cv> cvs;

	//bi-directional many-to-one association to Mission
	@OneToMany(mappedBy="entreprise", fetch=FetchType.EAGER)
	private List<Mission> missions;

	public Entreprise() {
	}

	public Entreprise(String adresse, String nom) {
		super();
		this.adresse = adresse;
		this.nom = nom;
	}

	public int getIdEntreprise() {
		return this.idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Cv> getCvs() {
		return this.cvs;
	}

	public void setCvs(List<Cv> cvs) {
		this.cvs = cvs;
	}

	public List<Mission> getMissions() {
		return this.missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Mission addMission(Mission mission) {
		getMissions().add(mission);
		mission.setEntreprise(this);

		return mission;
	}

	public Mission removeMission(Mission mission) {
		getMissions().remove(mission);
		mission.setEntreprise(null);

		return mission;
	}

}