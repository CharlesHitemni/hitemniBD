package com.hitemni.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_utilisateur", unique=true, nullable=false)
	private int idUtilisateur;

	@Column(name="adresse_pro", length=45)
	private String adressePro;

	@Column(nullable=false, length=45)
	private String age;

	@Column(nullable=false, length=45)
	private String mail;

	@Column(name="mot_de_passe", nullable=false, length=45)
	private String motDePasse;

	@Column(nullable=false, length=45)
	private String nom;

	@Column(length=200)
	private String photo;

	@Column(nullable=false, length=45)
	private String prenom;

	@Column(nullable=false, length=45)
	private String promo;

	private boolean sexe;

	@Column(length=40)
	private String telephone;
	
	//bi-directional one-to-one association to Cv
	@OneToOne
	@JoinColumn(name="CV_fk", nullable=true)
	private Cv cv;

	//bi-directional one-to-one association to Preference
	@OneToOne
	@JoinColumn(name="preference_fk", nullable=true)
	private Preference preference;

	//bi-directional one-to-one association to UtilisateurPersonnalite
	@OneToOne
	@JoinColumn(name="utilisateur_personnalite_fk", nullable=true)
	private UtilisateurPersonnalite utilisateurPersonnalite;

	//bi-directional many-to-many association to Evenement
    @ManyToMany 
    @JoinTable(name="inscription_evenement", 
          joinColumns=@JoinColumn(name="id_utilisateur_fk"),
          inverseJoinColumns=@JoinColumn(name="id_evenement_fk"))
	//@ManyToMany(mappedBy="utilisateur", fetch=FetchType.EAGER)
	private List<Evenement> evenements;
    
    @Column(length=40)
	private String latitude;
    
	public Utilisateur() {
	}
    
    public Utilisateur(String adressePro, String age, String mail,
			String motDePasse, String nom, String photo, String prenom,
			String promo, boolean sexe, String telephone, Cv cv,
			Preference preference,
			UtilisateurPersonnalite utilisateurPersonnalite,
			List<Evenement> evenements, String latitude, String longitude){
		this.adressePro = adressePro;
		this.age = age;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.photo = photo;
		this.prenom = prenom;
		this.promo = promo;
		this.sexe = sexe;
		this.telephone = telephone;
		this.cv = cv;
		this.preference = preference;
		this.utilisateurPersonnalite = utilisateurPersonnalite;
		this.evenements = evenements;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(length=40)
	private String longitude;

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getAdressePro() {
		return this.adressePro;
	}

	public void setAdressePro(String adressePro) {
		this.adressePro = adressePro;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPromo() {
		return this.promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public boolean getSexe() {
		return this.sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Cv getCv() {
		return this.cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public Preference getPreference() {
		return this.preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	public UtilisateurPersonnalite getUtilisateurPersonnalite() {
		return this.utilisateurPersonnalite;
	}

	public void setUtilisateurPersonnalite(UtilisateurPersonnalite utilisateurPersonnalite) {
		this.utilisateurPersonnalite = utilisateurPersonnalite;
	}

	public List<Evenement> getEvenements() {
		return this.evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

}