package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;
import com.infotel.service.Iservice;

import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();

	/**
	 * Default constructor.
	 */
	public ServletPersonne() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1-récuperation des infos

		String nom;
		String prenom;
		int age;
		int id;
		int adr;
		String login;
		String mdp;

		if (request.getParameter("nom") != null)

		{

			age = Integer.parseInt(request.getParameter("age"));
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			adr = Integer.parseInt(request.getParameter("idAdresse"));
			login= request.getParameter("login");
			 mdp= request.getParameter("mdp");

			// 2- envoyer à la couche service
			Personne p = new Personne();
            
			p.setAge(age);
			p.setNom(nom);// set=écrire
			p.setPrenom(prenom);
			
				Connexion c = new Connexion ();
				c.setLogin((login));
				c.setMdp(mdp);
			    
				p.setConnexion(c);
			if (adr != 0) {
				p.setAdresse(service.getAdresse(adr));
			}

			if (request.getParameter("ajouter") != null) {

				service.ajouterPersonne(p);// appeler la couche service
			}
			if (request.getParameter("modifier") != null) {
				id = Integer.parseInt(request.getParameter("id"));
				p.setId(id);

				service.modifierPersonne(p);
			}
		}

		// preparation à l'envoi
		request.setAttribute("personnes", service.findAllPersonne());
		request.setAttribute("adresses", service.findAllAdresse());

		// appel de la JSP
		request.getRequestDispatcher("Personne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
