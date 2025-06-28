package com.servlet.lifecycle;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class KeertanListener
 *
 */
@WebListener
public class KeertanListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public KeertanListener() {
    	System.out.println("KeertanListener constructor");
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("KeertanListener request destroyed");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("KeertanListener requestInitialized");
    }
	
}
