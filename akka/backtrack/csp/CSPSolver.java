package backtrack.csp;

public class CSPSolver extends CSP {
	
	/**
	 * Constructs a map CSP for the actors with the domain from node 1 to .... nodeNum.
	 */
	public CSPSolver(int nodesNum, int actorsNum, int constraintsNum ) {
		
		String[] actorList = new String[actorsNum];
		Variable[] actorVarArr = new Variable[actorsNum];
		for(int i=0; i< actorsNum; i++) {
			actorList[i] = "actor" + i ;
			actorVarArr[i] = new Variable( actorList[i]);
			addVariable(actorVarArr[i]);
		}
		String[] nodeList = new String[nodesNum];
	
		for(int i=0; i< nodesNum; i++) {
			nodeList[i] = "node" + i ;
		}
		Domain nodes = new Domain( new Object[] {nodeList});
		for (Variable var : getVariables())
			setDomain(var, nodes);

		//Separate constraints List
		int count_of_constraints =0;
		for(int i=0 ;i < constraintsNum/2; i++) {
			for(int j=i+1 ; j < constraintsNum/2; j++) {
				new NotEqualConstraint(actorVarArr[i], actorVarArr[j] );
				count_of_constraints ++;
			}
		}
	
		//Separate constraints list.
		for(int i= constraintsNum/2+1 ;i < constraintsNum; i++) {
			for(int j=i+1 ; j < constraintsNum-1; j++) {				
				new NotEqualConstraint(actorVarArr[i], actorVarArr[j] );
				count_of_constraints ++;
			}
		}		
		System.out.print("\nnodeNum= " + nodesNum + 
				"\tactorsNum= " + actorsNum +
				"\tConstraints= " + count_of_constraints);		
	}

	public static void main(String[] args) {
		//int nodesNum = 10, actorsNum=10, constraintsNum =10;
		
//		if (args.length > 1) {
//		    try {
//		    	nodesNum = Integer.parseInt(args[0]);
//		    	actorsNum = Integer.parseInt(args[1]);
//		    	constraintsNum = Integer.parseInt(args[2]);
//		    } catch (NumberFormatException e) {
//		        System.err.println("Argument" + args[0] + " must be an integer.");
//		        System.exit(1);
//		    }
//		}
		
//		int[] nodeNumList = new int[6];
		//int[] actorNumList = new int[6];
		//int[] constraintsNumList = new int[6];
		
		int[] nodesNumList ={ 100, 200, 300 , 400, 500 , 600 };
		int[] actorsNumList = { 20, 40, 60, 80, 100, 120 };
		int constraintsNum = 20;
		
		for (int i = 0; i < 6; i++) {
			//test case 1:
			//CSP csp = new CSPSolver(600, actorsNumList[i]*12, constraintsNum*12);new CSPSolver(600, actorsNumList[i]*12, constraintsNum*12);
			CSP csp = new CSPSolver(100, actorsNumList[i]*12, constraintsNum*12);
			// test case 2:
			//CSP csp = new CSPSolver(nodesNumList[i]*12, actorsNumList[i]*12, constraintsNum*12);
			
		
			long start = System.currentTimeMillis();
			Assignment results = new BacktrackingStrategy().solve(csp);
			long end = System.currentTimeMillis();
			if (results != null) {

				System.out.print("\tTotal time: " + (end - start)
						+ " milliseconds \t");

			}
		}
		
	}
}
