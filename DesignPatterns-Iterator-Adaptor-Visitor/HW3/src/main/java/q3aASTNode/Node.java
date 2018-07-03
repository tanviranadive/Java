package q3aASTNode;

import java.util.NoSuchElementException;

abstract class Node {
	
	private static int counter = 0;
	private static Node[] nodelist = new Node[100];
	
	/**
	 * @return id of Node
	 */
	public abstract int getId();
	public abstract String textRepresentation();
	
	/**
	 * Reverse mapping from Nodes to their unique identifiers
	 * @param id
	 * @return Node with identifier id
	 * @throws NoSuchElementException
	 */
	public static Node getNode(int id) throws NoSuchElementException {
		if(nodelist[id]!=null){
			return nodelist[id];
		}

		else
			throw new NoSuchElementException();
	}
	
	
	/**
	 * Sets the given node at the specified index
	 * @param node
	 * @param index
	 */
	public static void setNodelist(Node node,int index){
		nodelist[index] = node;
	}
	
	
	public void incrementCounter(){
		this.counter++;
	}
	
	public int getCounter(){
		return this.counter;
	}
	
	public void clear(){
		this.counter = 0;
	}
	
}
