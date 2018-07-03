package q4c;

import java.util.NoSuchElementException;

public abstract class Node {
	
	public static int counter = 1;
	private static Node[] nodelist = new Node[100];
	
	/**
	 * Returns unique identifier for each node.
	 */
	abstract public int getId();
	abstract public String textRepresentation();
	abstract void accept(ASTVisitor avisitor);
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
