package com.helper;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	private static SessionFactory factory ;
	
	public static SessionFactory getFactory() 
	{
		if(factory == null) 
		{
			Configuration cnf = new Configuration() ;
			cnf.configure("hibernate.cfg.xml") ;
			factory = cnf.buildSessionFactory() ;
		}
		
		return factory ;
	}
	
	public static void closeFactory() 
	{
		if(factory.isOpen()) 
		{
			factory.close();
		}
	}
}
