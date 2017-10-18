package it.univaq.ingweb.courseweb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {
	
	private static Connection db;
	
	public static void connect() throws NamingException, SQLException{
		
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/coruseweb");
		db = ds.getConnection();
	
	}
	
	public static void close() throws SQLException {
		
		db.close();
		
	}
	
	

}
