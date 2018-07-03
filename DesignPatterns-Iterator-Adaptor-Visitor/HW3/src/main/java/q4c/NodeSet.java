package q4c;

public class NodeSet implements Set<Node>{

	private Node[] nodelist;
	
	public NodeSet(){
		nodelist = new Node[100];
		adaptee = new BitVector();
	}
	

	@Override
	public void add(Node t) {
		nodelist[t.getId()] = t;
		adaptee.set(t.getId());
	}

	@Override
	public void addAll(Set<Node> s) {
		
		Iterator<Node> i = s.iterator();
		while(i.hasAnotherElement()){
			Node next = i.nextElement();
			add(next);
		}
	}

	@Override
	public boolean contains(Node t) {
		int id = t.getId();
		return (adaptee.get(id));
	}

	@Override
	public void remove(Node t) {
		int id = t.getId();
		nodelist[id] = null;
		adaptee.clear(id);
	}

	@Override
	public int size() {
		return adaptee.size();
	}

	@Override
	public Iterator<Node> iterator() {
		return new SetIteratorClass();
	}
	
	@Override public String toString(){
		StringBuilder res= new StringBuilder("");
		Iterator<Node> myIter = iterator();
		while(myIter.hasAnotherElement()){
			res.append(myIter.nextElement().textRepresentation()+"\n");
		}
		
		return res.toString();
	}
	
	private BitVector adaptee;
	
	
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

		public boolean hasAnotherElement() {
			return (countReturned < totalElements);
		}

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
