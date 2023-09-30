package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session ;
import com.entities.Note;
import com.helper.*;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id")) ;
		Session s =  FactoryProvider.getFactory().openSession() ;
	
		Note note = (Note) s.get(Note.class,id) ;
		System.out.println(note);
		s.remove(note);
//		s.close();
//		response.sendRedirect("view-notes.jsp") ;
		
	}

}
