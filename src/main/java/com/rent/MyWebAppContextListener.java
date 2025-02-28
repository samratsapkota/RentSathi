package com.rent;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class MyWebAppContextListener implements ServletContextListener {

	 @Override
	    public void contextDestroyed(ServletContextEvent event) {
	        try {
	            AbandonedConnectionCleanupThread.checkedShutdown();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	    }
	
	 /**
	    * Registers the JDBC drivers distributed with the application.
	    */
	   @Override
	   public void contextInitialized(ServletContextEvent event) {
	      Iterator<Driver> driversIterator = ServiceLoader.load(Driver.class).iterator();
	      while (driversIterator.hasNext()) {
	         try {
	            // Instantiates the driver
	            driversIterator.next();
	         } catch (Throwable t) {
	            event.getServletContext().log("JDBC Driver registration failure.", t);
	         }
	      }
	   }
}
