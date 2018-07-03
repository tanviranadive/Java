package q4b;

import java.util.NoSuchElementException;

public abstract class Node {
	
	public static int counter = 1;
	//int[] index = new int[100];
	private static Node[] nodelist = new Node[100];
	
	/**
	 * Returns unique identifier for each node.
	 */
	//public int getId(){}
	abstract public int getId();
	abstract public String textRepresentation();
	public abstract void accept(ASTNodeCountVisitor avisitor);
	/**
	 * Reverse mapping from Nodes to their unique identifiers
	 */
	public static Node getNode(int id) throws NoSuchElementException {
		if(nodelist[id]!=null){
			return nodelist[id];
		}

		else
			throw new NoSuchElementException();
	}
	

}
