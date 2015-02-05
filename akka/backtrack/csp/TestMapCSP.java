package backtrack.csp;


 public class TestMapCSP {
	//private static MapCSP csp = new MapCSP();
	
//
//	//@Before
//	public void setUp() {
//		csp = new MapCSP();
//	}

	//@Test
	public static void testBackTrackingSearch(MapCSP csp) {
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

			System.out.println(String.format(" %s ->node %s", MapCSP.WA ,  results.getAssignment(MapCSP.WA)));//"MapCSP.GREEN,"+
			System.out.println(String.format(" %s ->node %s", MapCSP.NT , results.getAssignment(MapCSP.NT))); //"MapCSP.RED,"+ 
			System.out.println(String.format(" %s ->node %s", MapCSP.SA ,  results.getAssignment(MapCSP.SA)));//"MapCSP.BLUE,"
			System.out.println(String.format(" %s ->node %s", MapCSP.Q , results.getAssignment(MapCSP.Q))); // "MapCSP.GREEN," +
			System.out.println(String.format(" %s ->node %s", MapCSP.NSW , results.getAssignment(MapCSP.NSW)));//"MapCSP.RED,"
			System.out.println(String.format(" %s ->node %s", MapCSP.V , results.getAssignment(MapCSP.V))); //"MapCSP.GREEN,"+
			System.out.println(String.format(" %s ->node %s", MapCSP.T , results.getAssignment(MapCSP.T))); //"MapCSP.RED," +
		}
	}

	//@Test
//	public void testMCSearch() {
//		new MinConflictsStrategy(100).solve(csp);
//	}
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MapCSP csp = new MapCSP();
		testBackTrackingSearch(csp);
	}

}
