package backtrack.csp;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;


/**
 * Artificial Intelligence A Modern Approach (3rd Ed.): Figure 6.1, Page 204.<br>
 * <br>
 *  Location assignment can be viewed as a constraint satisfaction problem (CSP). 
 * The goal is to assign actors to the nodes so that  satisfy the separate and collocate relationship.
 * 
 * @author Hua Zhang 
 */
public class MapCSP extends CSP {
		 
	/**
	 *  check the conflict between two HashMaps- separate map and collocate map
	 */

	 public void checkConflict( Map<Integer, Integer> separateMap, Map<Integer, Integer> collocateMap) {
		 
		    for (Map.Entry<Integer, Integer> separateMapEntries : separateMap.entrySet()) {
		        if(collocateMap.containsKey(separateMapEntries.getKey()) && collocateMap.get(separateMapEntries.getKey()).equals(separateMapEntries.getValue())){
		            System.out.println("\tKey: " + separateMapEntries.getKey() + " Value: " + separateMapEntries.getValue());
		        }
		    }		 
	 }
	 
	/**
	 * Constructs a  CSP for separate and collocated relations
	 */
	public MapCSP(int actors_num, int nodes_num, int constraints_num) {
		Variable[] actors = new Variable[actors_num];
		String[] nodes = new String[nodes_num];

		//collect Variables
		for(int i=0; i< actors_num; i++ ) {
			actors[i] = new Variable("actor" + i);
			addVariable(actors[i]);
		}	
		for (int i = 0; i< nodes_num ; i++) 
			nodes[i] = "node" + i;
		Domain nodesList = new Domain(nodes);

		for (Variable var : getVariables())
			setDomain(var, nodesList);		

		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i =0; i< actors_num; i++) {
			list.add(i);
		}
		
		Variable actor1 , actor2, actor3, actor4;
		Random rand = new Random();
		 Map<Integer, Integer> separateMap = new HashMap<Integer, Integer>();
		 Map<Integer, Integer> collocateMap = new HashMap<Integer, Integer>();
		 
		 
//		int sepConstraints_num = constraints_num;
//		//Separate constraints for actors    
//		while( sepConstraints_num >0) {
//			Integer actor1_num = rand.nextInt(list.size());
//			Integer actor2_num = rand.nextInt(list.size());			
//			 //System.out.println("actor1_num= " + actor1_num);
//			 //System.out.println("actor2_num= " + actor2_num);			 
//				actor1 =actors[ actor1_num]; // select one actor 				       
//				actor2 = actors[actor2_num];    //select second actor
//			
//				if (actor1_num != actor2_num){
//					separateMap.put(actor1_num, actor2_num);
//					System.out.println( actor1_num +","  + actor2_num + " Separate");
//					addConstraint(new NotEqualConstraint(actor1, actor2));				
//					//System.out.println("sepConstraints_num= "+sepConstraints_num);
//					sepConstraints_num--;
//				}
//		}
		System.out.println("---------------------------");
		
		//Collocate constraints for actors    
		int colConstraints_num = constraints_num;
		while( colConstraints_num >0) {
			Integer actor3_num = rand.nextInt(list.size());
			Integer actor4_num = rand.nextInt(list.size());
			actor3 =actors[ actor3_num]; // select third actor	
			actor4 = actors[actor4_num];    //select  forth actor			
				if (actor3_num != actor4_num) {
					collocateMap.put(actor3_num, actor4_num);
					System.out.println( actor3_num +","  + actor4_num + " collocate");
					addConstraint(new EqualConstraint(actor3, actor4));				
					//System.out.println("colConstraints_num= "+colConstraints_num);
					colConstraints_num--;
				}
		}		
//		checkConflict(  separateMap,  collocateMap);//check the conflicts
		
	}
	
	 
}