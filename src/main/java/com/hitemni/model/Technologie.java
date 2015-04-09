package com.hitemni.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the technologie database table.
 * 
 */
@Entity
@Table(name="technologie")
@NamedQuery(name="Technologie.findAll", query="SELECT t FROM Technologie t")
public class Technologie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_technologie", unique=true, nullable=false)
	private int idTechnologie;

	@Column(nullable=false, length=45)
	private String nom;

	//bi-directional many-to-one association to Cv
    @ManyToMany 
    @JoinTable(name="cv_technologie", 
          joinColumns=@JoinColumn(name="technologie_fk"),
          inverseJoinColumns=@JoinColumn(name="CV_fk"))
	private List<Cv> cv;

	public Technologie() {
	}

	public Technologie(String nom) {
		this.nom = nom;
	}

	public int getIdTechnologie() {
		return this.idTechnologie;
	}

	public void setIdTechnologie(int idTechnologie) {
		this.idTechnologie = idTechnologie;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Cv> getCv() {
		return this.cv;
	}

	public void setCv(List<Cv> cv) {
		this.cv = cv;
	}

}