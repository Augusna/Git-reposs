package listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import servlet.FindAllServlet;


@WebListener
public class MainListener implements ServletContextListener {


    public MainListener() {
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
    	
    	ServletContext sc = arg0.getServletContext(); 
        ServletRegistration sr = sc.addServlet("main", FindAllServlet.class); 
        sr.addMapping("/"); 

        
    }
	
}
