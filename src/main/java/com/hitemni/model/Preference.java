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
	private byte adresseProPreference;

	@Column(name="age_preference", nullable=false)
	private byte agePreference;

	@Column(name="cv_preference", nullable=false)
	private byte cvPreference;

	@Column(name="mail_preference", nullable=false)
	private byte mailPreference;

	@Column(name="nom_preference", nullable=false)
	private byte nomPreference;

	@Column(name="personnalite_preference", nullable=false)
	private byte personnalitePreference;

	@Column(name="photo_preference", nullable=false)
	private byte photoPreference;

	@Column(name="prenom_preference", nullable=false)
	private byte prenomPreference;

	@Column(name="promo_preference", nullable=false)
	private byte promoPreference;

	@Column(name="sexe_preference", nullable=false)
	private byte sexePreference;

	@Column(name="telephone_preference", nullable=false)
	private byte telephonePreference;

	//bi-directional one-to-one association to Utilisateur
	@OneToOne(mappedBy="preference")
	private Utilisateur utilisateur;

	public Preference() {
	}

	public int getIdPreference() {
		return this.idPreference;
	}

	public void setIdPreference(int idPreference) {
		this.idPreference = idPreference;
	}

	public byte getAdresseProPreference() {
		return this.adresseProPreference;
	}

	public void setAdresseProPreference(byte adresseProPreference) {
		this.adresseProPreference = adresseProPreference;
	}

	public byte getAgePreference() {
		return this.agePreference;
	}

	public void setAgePreference(byte agePreference) {
		this.agePreference = agePreference;
	}

	public byte getCvPreference() {
		return this.cvPreference;
	}

	public void setCvPreference(byte cvPreference) {
		this.cvPreference = cvPreference;
	}

	public byte getMailPreference() {
		return this.mailPreference;
	}

	public void setMailPreference(byte mailPreference) {
		this.mailPreference = mailPreference;
	}

	public byte getNomPreference() {
		return this.nomPreference;
	}

	public void setNomPreference(byte nomPreference) {
		this.nomPreference = nomPreference;
	}

	public byte getPersonnalitePreference() {
		return this.personnalitePreference;
	}

	public void setPersonnalitePreference(byte personnalitePreference) {
		this.personnalitePreference = personnalitePreference;
	}

	public byte getPhotoPreference() {
		return this.photoPreference;
	}

	public void setPhotoPreference(byte photoPreference) {
		this.photoPreference = photoPreference;
	}

	public byte getPrenomPreference() {
		return this.prenomPreference;
	}

	public void setPrenomPreference(byte prenomPreference) {
		this.prenomPreference = prenomPreference;
	}

	public byte getPromoPreference() {
		return this.promoPreference;
	}

	public void setPromoPreference(byte promoPreference) {
		this.promoPreference = promoPreference;
	}

	public byte getSexePreference() {
		return this.sexePreference;
	}

	public void setSexePreference(byte sexePreference) {
		this.sexePreference = sexePreference;
	}

	public byte getTelephonePreference() {
		return this.telephonePreference;
	}

	public void setTelephonePreference(byte telephonePreference) {
		this.telephonePreference = telephonePreference;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}