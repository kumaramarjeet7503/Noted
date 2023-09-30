package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import com.entities.*;
import java.util.Date;
import com.helper.FactoryProvider;
import jakarta.transaction.SystemException;
import org.hibernate.Transaction;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		Session session =  FactoryProvider.getFactory().openSession() ;
		Transaction trans =  session.beginTransaction() ;
		
		try {
			String title = request.getParameter("note-title");
			String desc = request.getParameter("note-description");
			Note note = new Note(desc,title, new Date()) ;
			session.persist(note);
			trans.commit(); 
			response.setContentType("text/html");
			PrintWriter out = response.getWriter() ;
			out.print("<h2 class='text-center'>Noted !</h2>") ;
			out.println("<a href='view-notes.jsp'>View notes</a>") ;
			
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
