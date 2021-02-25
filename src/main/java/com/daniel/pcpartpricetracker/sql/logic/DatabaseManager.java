package com.daniel.pcpartpricetracker.sql.logic;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.daniel.pcpartpricetracker.interfaces.Collector;
import com.daniel.pcpartpricetracker.interfaces.Submitter;

public class DatabaseManager {
	//private Connection conn = null;
	private Session session=null;
	private Transaction transaction = null;
	public Object run;
	public DatabaseManager() {
		//connect();
	}
	public void initFirstRun() {
		//createTables();
	}
	public void run(Submitter s) {
		connect();
		try{
			submit(s);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			transaction.commit();
			close();	
		}
	}
	public <E> ArrayList<E> collector(Collector<E> s) {
		
		connect();
		try{
			return collect(s);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();	
		}
		return null;
	}
	private void connect() {
		try {
			/*
			 * Configuration conf = new Configuration()
			 * .configure(); 
			 * ServiceRegistry sr = new
			 * StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			 * SessionFactory sf = conf.buildSessionFactory(sr);
			 */
			SessionFactory sf = new Configuration()
					  .configure().buildSessionFactory();
		     session= sf.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			// commit transaction
			
			// end
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		/*
	    try {
	        // db parameters
	        String url = "jdbc:sqlite:pcpartpickerdatabase.db";
	        // create a connection to the database
	        conn = DriverManager.getConnection(url);
	        
	        System.out.println("Connection to SQLite has been established.");
	        
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	       
	    }
	    */
	}
	/*public void createTables() {
		Statement st;
		try {
			st = conn.createStatement();
			
			String[] tables = {"CREATE TABLE IF NOT EXISTS "+BuildColumns.BUILD_TABLE+" ( "+BuildColumns._ID+" integer PRIMARY KEY, "+BuildColumns.PC_BUILD_ID+" integer NOT NULL,"+BuildColumns.PC_PART_ID+" integer NOT NULL)",
					"CREATE TABLE IF NOT EXISTS "+PCBuildColumns.PC_BUILD_TABLE+" ( "+PCBuildColumns._ID+" integer PRIMARY KEY, "+PCBuildColumns.NAME+" text NOT NULL)",
					"CREATE TABLE IF NOT EXISTS "+PCPartColumns.PC_PART_TABLE+" ( "+PCPartColumns._ID+" integer PRIMARY KEY, "+PCPartColumns.NAME+" text NOT NULL,"+PCPartColumns.TYPE+" integer NOT NULL)",
					"CREATE TABLE IF NOT EXISTS "+ShopColumns.PRICE_TABLE+" ( "+ShopColumns._ID+" integer PRIMARY KEY, "+ShopColumns.PC_PART_ID+" integer NOT NULL,"+ ShopColumns.PRICE+" real NOT NULL)"};
			for(String s : tables)
				st.execute(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	public void close() {
		session.close();
	}
	
	public boolean isConnected() {
		return session.isConnected();
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	private void  submit(Submitter s){
		s.submit();
	}
	private <E> ArrayList<E>  collect(Collector<E> s){
		transaction.commit();
		return s.collect();
	}
}
