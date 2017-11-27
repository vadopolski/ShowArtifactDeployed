package com;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyAppServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("ServletContextListener initialized.");
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("ServletContextListener destroyed.");
    }
}