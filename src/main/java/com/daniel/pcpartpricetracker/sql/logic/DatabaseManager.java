package com.daniel.pcpartpricetracker.sql.logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.daniel.pcpartpricetracker.interfaces.Submitter;
import com.sun.media.sound.SF2GlobalRegion;

public class DatabaseManager {
	//private Connection conn = null;
	private Session session=null;
	private Transaction transaction = null;
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
			close();	
		}
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
	public void  submit(Submitter s){
		s.submit();
		transaction.commit();
	}
}
