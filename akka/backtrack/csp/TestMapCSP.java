package backtrack.csp;

public class TestMapCSP {
	private static CSP csp;
	public static void testBackTrackingSearch() {
		
	
		
		long start = System.currentTimeMillis();
		Assignment results = new BacktrackingStrategy().solve(csp);	
		long end = System.currentTimeMillis();
		
		if (results != null) {

			System.out.print("\tTotal time: " + (end - start)
					+ " milliseconds \t");

		}
		if (results != null) {
			 for(int i = 0 ; i< 100; i++) {
			System.out.println("actors["+ i+"]="+ results.getAssignment( MapCSP.actors[i]));
			
		 }
		}
	}

//	//@Test
//	public void testMCSearch() {
//		new MinConflictsStrategy(100).solve(csp);
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		csp = new MapCSP();
		testBackTrackingSearch();
	}

}
