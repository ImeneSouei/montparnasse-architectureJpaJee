package com.infotel.service;

import java.util.List;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public interface Iservice {
	
	//Personne
	
	    public int ajouterPersonne(Personne p);
	    public Personne getPersonne(int idPersonne);
	    public Personne affichagePersonne(int idPersonne);
	    public int supprimerPersonne(Personne p);
	    public int modifierPersonne(Personne p);
	    public List<Personne> findAllPersonne();
	    public List<Personne>rechercherParMc(String mc);
	    
	    public List<Personne>findAllPersonnesConnexion();
	    public List<Personne>findAllPersonnesAdresse();
	    
	//Adresse
	    
	    public int ajouterAdresse(Adresse a);
	    public Adresse getAdresse(int idAdresse);
	    public Adresse affichageAdresse(int idAdresse);
	    public int supprimerAdresse(Adresse a);
	    public int modifierAdresse(Adresse a);
	    public List<Adresse> findAllAdresse();
	    public List<Adresse>rechercherParMcAdresse(String mc);
	    
	//CONNEXION
	    public int ajouterConnexion(Connexion c);
	    public Connexion getConnexion(int idConnexion);
	    public Connexion affichageConnexion(int idConnexion);
	    public int supprimerConnexion(Connexion c);
	    public int modifierConnexion(Connexion c);
	    public List<Connexion> findAllConnexion();
	    public List<Connexion>rechercherParMcConnexion(String mc);
	    
      
}
