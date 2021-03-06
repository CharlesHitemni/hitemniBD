package com.hitemni.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cv database table.
 * 
 */
@Entity
@Table(name="cv")
@NamedQuery(name="Cv.findAll", query="SELECT c FROM Cv c")
public class Cv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id_CV;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(length=45)
	private String intitule;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne(mappedBy="cv")
	private Utilisateur utilisateur;

	//bi-directional many-to-many association to Entreprise
	@ManyToMany 
	@JoinTable(name="entreprise_cv", 
	     joinColumns=@JoinColumn(name="CV_id_CV"),
	     inverseJoinColumns=@JoinColumn(name="entreprise_id_entreprise"))
	private List<Entreprise> entreprises;

	//bi-directional many-to-many association to Evenement
    @ManyToMany 
    @JoinTable(name="cv_technologie", 
          joinColumns=@JoinColumn(name="CV_fk"),
          inverseJoinColumns=@JoinColumn(name="technologie_fk"))
	private List<Technologie> technologies;

	public Cv() {
	}

	public Cv(Date date, String intitule) {
		super();
		this.date = date;
		this.intitule = intitule;
	}

	public int getId_CV() {
		return this.id_CV;
	}

	public void setId_CV(int id_CV) {
		this.id_CV = id_CV;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Entreprise> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	public List<Technologie> getTechnologies() {
		return this.technologies;
	}

	public void setTechnologies(List<Technologie> technologies) {
		this.technologies = technologies;
	}

}