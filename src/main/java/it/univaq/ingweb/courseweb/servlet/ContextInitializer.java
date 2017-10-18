package it.univaq.ingweb.courseweb.servlet;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import it.univaq.ingweb.courseweb.utils.Database;

@WebServlet(name = "ContextListener", urlPatterns = {"/ContextListener"})
public class ContextInitializer implements ServletContextListener {
	private static Logger logger = LoggerFactory.getLogger(ContextInitializer.class);

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			Database.connect();
		} catch (NamingException e) {
			log
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
		try {
			Database.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
   
}
