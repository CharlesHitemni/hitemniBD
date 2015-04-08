package com.hitemni.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the utilisateur_personnalite database table.
 * 
 */
@Entity
@Table(name="utilisateur_personnalite")
@NamedQuery(name="UtilisateurPersonnalite.findAll", query="SELECT u FROM UtilisateurPersonnalite u")
public class UtilisateurPersonnalite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_utilisateur_personnalite", unique=true, nullable=false)
	private int idUtilisateurPersonnalite;

	@Column(name="entreprise_actuelle", nullable=false, length=100)
	private String entrepriseActuelle;

	@Column(name="nbr_annee_exp", nullable=false)
	private int nbrAnneeExp;

	@Column(nullable=false, length=45)
	private String specialite;

	@Column(name="type_de_travaille", length=45)
	private String typeDeTravaille;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne(mappedBy="utilisateurPersonnalite")
	private Utilisateur utilisateur;

	public UtilisateurPersonnalite() {
	}
	
	

	public UtilisateurPersonnalite(String entrepriseActuelle, int nbrAnneeExp, String specialite,String typeDeTravaille) {
		this.entrepriseActuelle = entrepriseActuelle;
		this.nbrAnneeExp = nbrAnneeExp;
		this.specialite = specialite;
		this.typeDeTravaille = typeDeTravaille;
	}



	public int getIdUtilisateurPersonnalite() {
		return this.idUtilisateurPersonnalite;
	}

	public void setIdUtilisateurPersonnalite(int idUtilisateurPersonnalite) {
		this.idUtilisateurPersonnalite = idUtilisateurPersonnalite;
	}

	public String getEntrepriseActuelle() {
		return this.entrepriseActuelle;
	}

	public void setEntrepriseActuelle(String entrepriseActuelle) {
		this.entrepriseActuelle = entrepriseActuelle;
	}

	public int getNbrAnneeExp() {
		return this.nbrAnneeExp;
	}

	public void setNbrAnneeExp(int nbrAnneeExp) {
		this.nbrAnneeExp = nbrAnneeExp;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getTypeDeTravaille() {
		return this.typeDeTravaille;
	}

	public void setTypeDeTravaille(String typeDeTravaille) {
		this.typeDeTravaille = typeDeTravaille;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}