//package com.demo.listener;
//
//import javax.servlet.ServletRequestEvent;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.annotation.WebListener;
//
///**
// * Application Lifecycle Listener implementation class MyDemoListener
// *
// */
//@WebListener
//public class MyDemoListener implements ServletRequestListener {
//
//    /**
//     * Default constructor. 
//     */
//    public MyDemoListener() {
//       System.out.println("MyDemoListener Constructor Destroyed");
//    }
//
//	/**
//     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
//     */
//    public void requestDestroyed(ServletRequestEvent sre)  { 
//       System.out.println("MyDemoListener Destroyed");
//    }
//
//	/**
//     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
//     */
//    public void requestInitialized(ServletRequestEvent sre)  { 
//     System.out.println("MyDemoListener Initialized");
//    }
//	
//}
