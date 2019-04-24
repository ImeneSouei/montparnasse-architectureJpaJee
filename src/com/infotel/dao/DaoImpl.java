package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class DaoImpl implements Idao {
	
	//unité de persistance créé autoroute
	EntityManagerFactory emf;
	
	//porteur de requete
	EntityManager em;

	@Override
	public int ajouterPersonne(Personne p) {
		
		// ouverture unité de persistance et transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			//1- débuter la transaction
			
			tx.begin();
			
			//2-effectuer la requete
			em.persist(p);
			
			//3- valider la transaction
			tx.commit();
			
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annule la transaction
			
			tx.rollback();
		}
		
		return p.getId();
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Personne p = new Personne();
		try {
			
			p=em.getReference(Personne.class, idPersonne);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p ;
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		
		// ouverture unité de persistance et transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				try {
					
					//1- débuter la transaction
					
					tx.begin();
					
					//2-effectuer la requete
					em.remove(p);
					
					//3- valider la transaction
					tx.commit();
					
					//4- fermer l'unité de persistence
					em.close();
					emf.close();
					
				} catch (Exception e) {
					// annule la transaction
					
					tx.rollback();
				}
				
			
		return p.getId();
	}

	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		// ouverture unité de persistance et transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				try {
					
					//1- débuter la transaction
					
					tx.begin();
					
					//2-effectuer la requete
					em.merge(p);
					
					//3- valider la transaction
					tx.commit();
					
					//4- fermer l'unité de persistence
					em.close();
					emf.close();
					
				} catch (Exception e) {
					// annule la transaction
					
					tx.rollback();
				}
				
				return p.getId();
		
	}

	@Override
	public Personne affichagePersonne(int idPersonne) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Personne p = new Personne();
		try {
			
			p=em.find(Personne.class, idPersonne);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p ;
	
	}

	@Override
	public List<Personne> findAllPersonne() {
		// TODO Auto-generated method stub
		
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Personne> l = new ArrayList<Personne>();
		
		try {
			
			q=em.createQuery("Select p FROM Personne p");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l ;
	}

	@Override
	public List<Personne> rechercherParMc(String mc) {
		// TODO Auto-generated method stub
		
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Personne> l = new ArrayList<Personne>();
		
		try {
			
			q=em.createQuery("Select p FROM Personne p where nom like :lenom");//lenom ici c comme? 
			q.setParameter("lenom","%"+mc+"%");// % veut dire c qui est avant et apres mc
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l ;
		
	}

	@Override
	public int ajouterAdresse(Adresse a) {
		
		
		// ouverture unité de persistance et transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				try {
					
					//1- débuter la transaction
					
					tx.begin();
					
					//2-effectuer la requete
					em.persist(a);
					
					//3- valider la transaction
					tx.commit();
					
					//4- fermer l'unité de persistence
					em.close();
					emf.close();
					
				} catch (Exception e) {
					// annule la transaction
					
					tx.rollback();
				}
				
				return a.getIdAdresse();
		
	}

	@Override
	public Adresse getAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Adresse a = new Adresse();
		try {
			
			a=em.getReference(Adresse.class, idAdresse);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a ;
	}

	@Override
	public Adresse affichageAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Adresse a = new Adresse();
		try {
			
			a=em.find(Adresse.class, idAdresse);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a ;
	
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		// TODO Auto-generated method stub
		// ouverture unité de persistance et transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			//1- débuter la transaction
			
			tx.begin();
			
			//2-effectuer la requete
			em.remove(a);
			
			//3- valider la transaction
			tx.commit();
			
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annule la transaction
			
			tx.rollback();
		}
		
	
        return a.getIdAdresse();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		// ouverture unité de persistance et transaction
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			//1- débuter la transaction
			
			tx.begin();
			
			//2-effectuer la requete
			em.merge(a);
			
			//3- valider la transaction
			tx.commit();
			
			//4- fermer l'unité de persistence
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// annule la transaction
			
			tx.rollback();
		}
		
		return a.getIdAdresse();
	}

	@Override
	public List<Adresse> findAllAdresse() {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Adresse> adl = new ArrayList<Adresse>();
		
		try {
			
			q=em.createQuery("Select a FROM Adresse a");
			adl=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return adl ;
	}

	@Override
	public List<Adresse> rechercherParMcAdresse(String mc) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Adresse> adl = new ArrayList<Adresse>();
		
		try {
			
			q=em.createQuery("Select a FROM Adresse a where nomRue like :lenom");//lenom ici c comme? 
			q.setParameter("lenom","%"+mc+"%");// % veut dire c qui est avant et apres mc
			adl=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return adl ;
		
	}

	@Override
	public int ajouterConnexion(Connexion c) {
	
		// ouverture unité de persistance et transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				try {
					
					//1- débuter la transaction
					
					tx.begin();
					
					//2-effectuer la requete
					em.persist(c);
					
					//3- valider la transaction
					tx.commit();
					
					//4- fermer l'unité de persistence
					em.close();
					emf.close();
					
				} catch (Exception e) {
					// annule la transaction
					
					tx.rollback();
				}
				
				return c.getIdConnexion();

	}

	@Override
	public Connexion getConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Connexion c = new Connexion();
		try {
			
			c=em.getReference(Connexion.class, idConnexion);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c ;
	}

	@Override
	public Connexion affichageConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Connexion c = new Connexion();
		try {
			
			c=em.find(Connexion.class, idConnexion);
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c ;
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		// TODO Auto-generated method stub
		// ouverture unité de persistance et transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				try {
					
					//1- débuter la transaction
					
					tx.begin();
					
					//2-effectuer la requete
					em.remove(c);
					
					//3- valider la transaction
					tx.commit();
					
					//4- fermer l'unité de persistence
					em.close();
					emf.close();
					
				} catch (Exception e) {
					// annule la transaction
					
					tx.rollback();
				}
				
			
		        return c.getIdConnexion();
	}

	@Override
	public int modifierConnexion(Connexion c) {
		// TODO Auto-generated method stub
		// ouverture unité de persistance et transaction
				emf= Persistence.createEntityManagerFactory("demojpa-pu");
				em= emf.createEntityManager();
				EntityTransaction tx = em.getTransaction();
				
				try {
					
					//1- débuter la transaction
					
					tx.begin();
					
					//2-effectuer la requete
					em.merge(c);
					
					//3- valider la transaction
					tx.commit();
					
					//4- fermer l'unité de persistence
					em.close();
					emf.close();
					
				} catch (Exception e) {
					// annule la transaction
					
					tx.rollback();
				}
				
				return c.getIdConnexion();
	}

	@Override
	public List<Connexion> findAllConnexion() {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Connexion> cxl = new ArrayList<Connexion>();
		
		try {
			
			q=em.createQuery("Select c FROM Connexion c");
			cxl=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cxl ;
	}

	@Override
	public List<Connexion> rechercherParMcConnexion(String mc) {
		// TODO Auto-generated method stub
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Connexion> cxl = new ArrayList<Connexion>();
		
		try {
			
			q=em.createQuery("Select c FROM Connexion c where login like :lenom");//lenom ici c comme? 
			q.setParameter("lenom","%"+mc+"%");// % veut dire c qui est avant et apres mc
			cxl=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cxl ;
	}

	@Override
	public List<Personne> findAllPersonnesConnexion() {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Personne> l = new ArrayList<Personne>();
		
		try {
			
			q=em.createQuery("Select p FROM Personne p join p.connexion");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l ;
	}

	@Override
	public List<Personne> findAllPersonnesAdresse() {
		emf= Persistence.createEntityManagerFactory("demojpa-pu");
		em= emf.createEntityManager();
		Query q= null;
		List <Personne> l = new ArrayList<Personne>();
		
		try {
			
			q=em.createQuery("Select p FROM Personne p full join p.adresse");
			l=q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l ;
		
	}
		
	}


