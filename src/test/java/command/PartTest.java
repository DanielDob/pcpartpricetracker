package command;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.daniel.pcpartpricetracker.Parts;
import com.daniel.pcpartpricetracker.sql.logic.DatabaseManager;

public class PartTest {
	public static int TEST_ID=123;
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void add() {
		Parts p = new Parts();
		DatabaseManager dm = new DatabaseManager();
		int a=0,b=0;
		a=dm.size();
		p.executePart("add", new String[] {"part","add",TEST_ID+"","1","1"});
		b=dm.size();
		assertNotEquals("Nie dodano rekordu.", a, b);
		
	}
}
