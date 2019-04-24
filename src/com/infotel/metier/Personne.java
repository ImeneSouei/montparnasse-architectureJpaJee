package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

@Inheritance(strategy= InheritanceType.SINGLE_TABLE) // declarer heritage méthode "Singletable"
@DiscriminatorColumn (name="Type_Pers")
@DiscriminatorValue("PERS")


//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // DECLARER HERITAGE METHODE " TABLE_PER_CLASS"//


//@Inheritance(strategy=InheritanceType.JOINED) // Declarer heritage methode ""JOINED//


public class Personne {
	
	@Id
	
	@GeneratedValue(strategy= GenerationType.IDENTITY) // DECLARER HERITAGE SINGLETABLE ET "JOINED"//
	
	private int id;
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String nom;
	private String prenom;
	private int age;
	
	@ManyToMany(mappedBy="personnes")
	private List<Club> clubs= new ArrayList<Club>();
	
	public List<Club> getClubs() {
		return clubs;
	}
	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
	@ManyToOne//(cascade = {CascadeType.PERSIST})//
	private Adresse adresse;
	
	@OneToOne( cascade = {CascadeType.PERSIST})// declarer strategie de chargement 
	private Connexion connexion;
	
	public Connexion getConnexion() {
		return connexion;
	}
	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
