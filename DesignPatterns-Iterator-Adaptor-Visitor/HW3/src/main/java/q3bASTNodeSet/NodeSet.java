package q3bASTNodeSet;

import q4b.ASTNodeCountVisitor;

public class NodeSet implements Set<Node>{

	private Node[] nodelist;
	
	public NodeSet(){
		nodelist = new Node[100];
		adaptee = new BitVector();
	}
	

	/**
	 * Adds node to the set of nodes
	 * @param t
	 */
	@Override
	public void add(Node t) {
		nodelist[t.getId()] = t;
		adaptee.set(t.getId());
	}

	/**
	 * Adds all node from the given set of nodes
	 * @param s
	 */
	@Override
	public void addAll(Set<Node> s) {
		
		Iterator<Node> i = s.iterator();
		while(i.hasAnotherElement()){
			Node next = i.nextElement();
			add(next);
		}
	}

	/**
	 * Checks if node set contains the given node
	 * @param t
	 * @return true id t is present else false
	 */
	@Override
	public boolean contains(Node t) {
		int id = t.getId();
		return (adaptee.get(id));
	}

	/**
	 * Removes if node set contains the given node
	 * @param t
	 */
	@Override
	public void remove(Node t) {
		int id = t.getId();
		nodelist[id] = null;
		adaptee.clear(id);
	}

	/**
	 * Returns number of nodes in node set
	 * @return number of nodes in the set
	 */
	@Override
	public int size() {
		return adaptee.size();
	}

	/**
	 * @return Iterator over the node set
	 */
	@Override
	public Iterator<Node> iterator() {
		return new SetIteratorClass();
	}
	
	/**
	 * @return string representation of node set
	 */
	@Override public String toString(){
		StringBuilder res= new StringBuilder("");
		Iterator<Node> myIter = iterator();
		while(myIter.hasAnotherElement()){
			res.append(myIter.nextElement().textRepresentation()+"\n");
		}
		
		return res.toString();
	}
	
	/**
	 * BitVector to represent the nodes
	 */
	private BitVector adaptee;
	
	/**
	 * Class iterator to iterate over the node set
	 * @author Tanvi
	 *
	 */
	private class SetIteratorClass implements Iterator<Node> {

		int row;
		int col;
		int rowSize;
		int countReturned;
		int totalElements;

		public SetIteratorClass() {
			row = 0;
			rowSize = 31;
			col = rowSize+1;
			countReturned = 0;
			totalElements = size();
		}

		/**
		 * @return true if any more element is present in the set else false
		 */
		@Override
		public boolean hasAnotherElement() {
			return (countReturned < totalElements);
		}

		/**
		 * @return the next node
		 */
		@Override
		public Node nextElement() {
			for (int r = row; r < adaptee.getBits().length; r++) {
				StringBuilder binary = new StringBuilder(String.format("%32s", Integer.toBinaryString(adaptee.getBits()[r])));
				int start = (r == row) ? col - 1 : rowSize;
				for (int c = start; c > 0; c--) {
					if (binary.charAt(c) == '1') {
						col = c;
						row = r;
						countReturned++;
						return nodelist[(row * rowSize + (rowSize - col) + 1)];
					}
				}
			}
			
			return null;
		}
		
	}
	

}
