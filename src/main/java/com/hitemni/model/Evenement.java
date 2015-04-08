package com.hitemni.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the evenement database table.
 * 
 */
@Entity
@Table(name="evenement")
@NamedQuery(name="Evenement.findAll", query="SELECT e FROM Evenement e")
public class Evenement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evenement", unique=true, nullable=false)
	private int idEvenement;

	@Column(nullable=false, length=100)
	private String adresse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, length=200)
	private String descriptif;

	@Column(nullable=false, length=45)
	private String titre;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy="evenements", fetch=FetchType.EAGER)
	private List<Utilisateur> utilisateurs;

	public Evenement() {
	}

	public int getIdEvenement() {
		return this.idEvenement;
	}

	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}