package com.daniel.pcpartpricetracker.sql;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.daniel.pcpartpricetracker.Parts;

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
		//p.executePart("add", "part add 12345 CPU XKOM".split(" "));
		//.executePart("add", "part add 54321 HDD_2 MORELE".split(" "));
		
		p.executePart("show", "part show -all".split(" "));
	}
	
	@Test
	public void open() {
	    Parts p = new Parts();
	    p.executePart("open", "part open 606125".split(" "));
	}
	public void shopPart() {
		
	}
}
