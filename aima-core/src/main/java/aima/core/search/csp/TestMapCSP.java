package aima.core.search.csp;



import aima.core.search.csp.Assignment;
import aima.core.search.csp.BacktrackingStrategy;
import aima.core.search.csp.CSP;
import aima.core.search.csp.MapCSP;
import aima.core.search.csp.MinConflictsStrategy;

public class TestMapCSP {
	private static CSP csp;
//
//	//@Before
//	public void setUp() {
//		csp = new MapCSP();
//	}

	//@Test
	public static void testBackTrackingSearch() {
		Assignment results = new BacktrackingStrategy().solve(csp);
//		Assert.assertNotNull(results);
//		Assert.assertEquals(MapCSP.GREEN, results.getAssignment(MapCSP.WA));
//		Assert.assertEquals(MapCSP.RED, results.getAssignment(MapCSP.NT));
//		Assert.assertEquals(MapCSP.BLUE, results.getAssignment(MapCSP.SA));
//		Assert.assertEquals(MapCSP.GREEN, results.getAssignment(MapCSP.Q));
//		Assert.assertEquals(MapCSP.RED, results.getAssignment(MapCSP.NSW));
//		Assert.assertEquals(MapCSP.GREEN, results.getAssignment(MapCSP.V));
//		Assert.assertEquals(MapCSP.RED, results.getAssignment(MapCSP.T));
		if (results != null) {

			System.out.println( results.getAssignment(MapCSP.WA));//"MapCSP.GREEN,"+
			System.out.println(results.getAssignment(MapCSP.NT)); //"MapCSP.RED,"+ 
			System.out.println( results.getAssignment(MapCSP.SA));//"MapCSP.BLUE,"
			System.out.println(results.getAssignment(MapCSP.Q)); // "MapCSP.GREEN," +
			System.out.println( results.getAssignment(MapCSP.NSW));//"MapCSP.RED,"
			System.out.println( results.getAssignment(MapCSP.V)); //"MapCSP.GREEN,"+
			System.out.println( results.getAssignment(MapCSP.T)); //"MapCSP.RED," +
		}
	}

	//@Test
	public void testMCSearch() {
		new MinConflictsStrategy(100).solve(csp);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		csp = new MapCSP();
		testBackTrackingSearch();
	}

}
