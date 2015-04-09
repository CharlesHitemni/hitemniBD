package com.hitemni.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the preference database table.
 * 
 */
@Entity
@Table(name="preference")
@NamedQuery(name="Preference.findAll", query="SELECT p FROM Preference p")
public class Preference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_preference", unique=true, nullable=false)
	private int idPreference;

	@Column(name="adresse_pro_preference", nullable=false)
	private boolean adresseProPreference;

	@Column(name="age_preference", nullable=false)
	private boolean agePreference;

	@Column(name="cv_preference", nullable=false)
	private boolean cvPreference;

	@Column(name="mail_preference", nullable=false)
	private boolean mailPreference;

	@Column(name="nom_preference", nullable=false)
	private boolean nomPreference;

	@Column(name="personnalite_preference", nullable=false)
	private boolean personnalitePreference;

	@Column(name="photo_preference", nullable=false)
	private boolean photoPreference;

	@Column(name="prenom_preference", nullable=false)
	private boolean prenomPreference;

	@Column(name="promo_preference", nullable=false)
	private boolean promoPreference;

	@Column(name="sexe_preference", nullable=false)
	private boolean sexePreference;

	@Column(name="telephone_preference", nullable=false)
	private boolean telephonePreference;
	
	@Column(name="position_utilisateur", nullable=false)
	private boolean position_utilisateur;
	
	public boolean getPosition_utilisateur() {
		return position_utilisateur;
	}

	public void setPosition_utilisateur(boolean position_utilisateur) {
		this.position_utilisateur = position_utilisateur;
	}

	//bi-directional one-to-one association to Utilisateur
	@OneToOne(mappedBy="preference")
	private Utilisateur utilisateur;

	public Preference() {
	}

	public int getIdPreference() {
		return this.idPreference;
	}

	public Preference(boolean adresseProPreference, boolean agePreference,
			boolean cvPreference, boolean mailPreference,
			boolean nomPreference, boolean personnalitePreference,
			boolean photoPreference, boolean prenomPreference,
			boolean promoPreference, boolean sexePreference,
			boolean telephonePreference, boolean position_utilisateur) {
		this.adresseProPreference = adresseProPreference;
		this.agePreference = agePreference;
		this.cvPreference = cvPreference;
		this.mailPreference = mailPreference;
		this.nomPreference = nomPreference;
		this.personnalitePreference = personnalitePreference;
		this.photoPreference = photoPreference;
		this.prenomPreference = prenomPreference;
		this.promoPreference = promoPreference;
		this.sexePreference = sexePreference;
		this.telephonePreference = telephonePreference;
		this.position_utilisateur = position_utilisateur;
	}

	public void setIdPreference(int idPreference) {
		this.idPreference = idPreference;
	}

	public boolean getAdresseProPreference() {
		return this.adresseProPreference;
	}

	public void setAdresseProPreference(boolean adresseProPreference) {
		this.adresseProPreference = adresseProPreference;
	}

	public boolean getAgePreference() {
		return this.agePreference;
	}

	public void setAgePreference(boolean agePreference) {
		this.agePreference = agePreference;
	}

	public boolean getCvPreference() {
		return this.cvPreference;
	}

	public void setCvPreference(boolean cvPreference) {
		this.cvPreference = cvPreference;
	}

	public boolean getMailPreference() {
		return this.mailPreference;
	}

	public void setMailPreference(boolean mailPreference) {
		this.mailPreference = mailPreference;
	}

	public boolean getNomPreference() {
		return this.nomPreference;
	}

	public void setNomPreference(boolean nomPreference) {
		this.nomPreference = nomPreference;
	}

	public boolean getPersonnalitePreference() {
		return this.personnalitePreference;
	}

	public void setPersonnalitePreference(boolean personnalitePreference) {
		this.personnalitePreference = personnalitePreference;
	}

	public boolean getPhotoPreference() {
		return this.photoPreference;
	}

	public void setPhotoPreference(boolean photoPreference) {
		this.photoPreference = photoPreference;
	}

	public boolean getPrenomPreference() {
		return this.prenomPreference;
	}

	public void setPrenomPreference(boolean prenomPreference) {
		this.prenomPreference = prenomPreference;
	}

	public boolean getPromoPreference() {
		return this.promoPreference;
	}

	public void setPromoPreference(boolean promoPreference) {
		this.promoPreference = promoPreference;
	}

	public boolean getSexePreference() {
		return this.sexePreference;
	}

	public void setSexePreference(boolean sexePreference) {
		this.sexePreference = sexePreference;
	}

	public boolean getTelephonePreference() {
		return this.telephonePreference;
	}

	public void setTelephonePreference(boolean telephonePreference) {
		this.telephonePreference = telephonePreference;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}