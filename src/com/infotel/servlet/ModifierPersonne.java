package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ModifierPersonne
 */
@WebServlet("/ModifierPersonne")
public class ModifierPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service= new ServiceImpl();

    /**
     * Default constructor. 
     */
    public ModifierPersonne() {
        // TODO Auto-generated constructor stub
    	 super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Personne p = service.affichagePersonne(Integer.parseInt(request.getParameter("idPersonne")));
		request.setAttribute("id",p.getId());
		request.setAttribute("nom",p.getNom());
		request.setAttribute("prenom",p.getPrenom());
		request.setAttribute("age",p.getAge());
		
		 //preparation à l'envoi
		   
		request.setAttribute("personnes", service.findAllPersonne());
		request.setAttribute("adresses", service.findAllAdresse());
		
		//appel de la JSP
		request.getRequestDispatcher("Personne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
