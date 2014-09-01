package backtrack.csp;

import java.util.ArrayList;
import java.util.Random;


/**
 * Artificial Intelligence A Modern Approach (3rd Ed.): Figure 6.1, Page 204.<br>
 * <br>
 *  Location assignment can be viewed as a constraint satisfaction problem (CSP). 
 * The goal is to assign actors to the nodes so that  satisfy the separate and collocate relationship.
 * 
 * @author Hua Zhang 
 */
public class MapCSP extends CSP {
	public static final int actors_num = 100;
	public static final int nodes_num = 20;
	public static final int constraints_num = 100;

	public static final Variable[] actors = new Variable[actors_num];
	public static final String[] nodes = new String[nodes_num];

	
	public static final Variable  X = new Variable("X");
	public static final Variable Y = new Variable("Y");
	private static final Constraint C1 = new NotEqualConstraint(X, Y);
	private static final Constraint C2 = new EqualConstraint(X, Y);
	
	 private void collectVariables() {
		for(int i=0; i< actors_num; i++ ) {
			actors[i] = new Variable("actor" + i);
			addVariable(actors[i]);
		}
		
	}

	 
	/**
	 * Constructs a  CSP for separate and collocate relations
	 */
	public MapCSP() {
		collectVariables();
		
		for (int i = 0; i< nodes_num ; i++) 
			nodes[i] = "node" + i;
		Domain colors = new Domain(nodes);

		for (Variable var : getVariables())
			setDomain(var, colors);
		
		for (int i = 0; i< actors_num-2 ; i++)  {
		
			addConstraint(new NotEqualConstraint(actors[i], actors[i+1]));
			addConstraint(new NotEqualConstraint(actors[i], actors[i+2]));
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i =0; i< actors_num; i++) {
			list.add(i);
		}
		
		Variable actor1 , actor2, actor3, actor4;
		Random rand = new Random();
		int sepConstraints_num = constraints_num;
		while( sepConstraints_num >0) {

				actor1 =actors[ rand.nextInt(list.size())]; // select one actor 				       
				actor2 = actors[rand.nextInt(list.size())];    //select second actor
				if (actor1 != actor2)
					addConstraint(new NotEqualConstraint(actor1, actor2));				
			//System.out.println("sepConstraints_num= "+sepConstraints_num);
			sepConstraints_num--;
		}
//	
//     	int colConstraints_num = constraints_num;
//		while( colConstraints_num >0) {
//
//				actor3 =actors[ rand.nextInt(list.size())]; // select third actor 	
//				System.out.println("actor3=" + actor3);
//				actor4 = actors[rand.nextInt(list.size())];    //select  forth actor
//				System.out.println("actor4=" + actor4);
//				if (actor4 != actor3)
//					addConstraint(new EqualConstraint(actor3, actor4));				
//			//System.out.println("sepConstraints_num= "+colConstraints_num);
//			colConstraints_num--;
//		}
	}
}