package backtrack.csp;

public class TestMapCSP {
	private static CSP csp;
	public static void testBackTrackingSearch() {
		
	
		
		long start = System.currentTimeMillis();
		Assignment results = new BacktrackingStrategy().solve(csp);	
		System.out.println(results);
		long end = System.currentTimeMillis();
		

		if (results != null) {

			System.out.print("\tTotal time: " + (end - start)
					+ " milliseconds \t");
			System.out.println(results);
			
		}else {
			System.out.println("result is null"); // result is null
		}
	}

//	//@Test
//	public void testMCSearch() {
//		new MinConflictsStrategy(100).solve(csp);
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int actors_num = 60;
		int nodes_num = 20;
		int constraints_num = 2;
		
		csp = new MapCSP(actors_num, nodes_num, constraints_num);
		testBackTrackingSearch();
	}

}
