package com.servlet.lifecycle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class KaushalListener
 *
 */
@WebListener
public class KaushalListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public KaushalListener() {
    	 System.out.println("KaushalListener Constructor()");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("KaushalListener contextDestroyed()");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("KaushalListener contextInitialized()");
    }
	
}
