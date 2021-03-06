package com.daniel.pcpartpricetracker.sql;

import java.util.List;

import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import com.daniel.pcpartpricetracker.Parts;
import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;

public class PCPartTest {
	List<String> list = null;

	@Before
	public void init() {

		// session =dbm.getSession();
	}

	@Test
	public void exists() {
		/*
		DatabaseManager db = new DatabaseManager(); 
		db.run(()-> { String sql =
			"Select name FROM sqlite_master WHERE type='table' AND name= :table_name";
			@SuppressWarnings("unchecked") Query<String> query =
			db.getSession().createSQLQuery(sql).setParameter("table_name", "'pc_part'");
			list= query.getResultList();
		}); 
		assertSame(1,list.size());
		*/
	}

	@Test
	public void insert() {
		Parts p = new Parts();
		DatabaseManager db = new DatabaseManager(); 
		db.run(()-> { String sql =
			"Select * FROM pc_part ";
			@SuppressWarnings("unchecked") Query<String> query =
			db.getSession().createSQLQuery(sql);
			list= query.getResultList();
		}); 
		if(list.size()<4) {
			p.executePart("add", "part add 597348 GPU XKOM".split(" "));
			p.executePart("add", "part add 474474 M2 XKOM".split(" "));
			p.executePart("add", "part add 6731004 CPU MORELE".split(" "));
			p.executePart("add", "part add 930692 HDD MORELE".split(" "));
		}
		p.executePart("show", "part show -all".split(" "));
	}
	
	//@Test
	public void open() {
	    Parts p = new Parts();
	    //p.executePart("open", "part open 606125".split(" "));
	}
	public void shopPart() {
		
	}
}
