package com.daniel.pcpartpricetracker.sql;

import static org.junit.Assert.assertSame;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.metamodel.internal.MetamodelImpl;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import com.daniel.pcpartpricetracker.Parts;
import com.daniel.pcpartpricetracker.objects.PCPart;
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
		p.executePart("add", "part add 12345 1 1".split(" "));
		p.executePart("add", "part add 54321 5 1".split(" "));

		p.executePart("show", "part show".split(" "));
	}
}
