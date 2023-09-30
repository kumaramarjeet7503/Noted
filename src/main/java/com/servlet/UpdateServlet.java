package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session =  FactoryProvider.getFactory().openSession() ;
		Transaction trans =  session.beginTransaction() ;
		
		try {
			int id = Integer.parseInt(request.getParameter("id"))  ;
			String title = request.getParameter("note-title");
			String desc = request.getParameter("note-description");
			Note note = (Note) session.get(Note.class,id) ;
			
			note.setDescription(desc);
			note.setTitle(title) ;
			
			session.persist(note);
			trans.commit(); 
			response.sendRedirect("view-notes.jsp");
			
		}catch(Exception e) 
		{
			
			try {
				trans.rollback();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
