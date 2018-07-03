package q3aASTNode;

import q1bBitVector.Iterator;

public interface Set<T> {

	/**
	 * Add an element to set
	 * @param t
	 */
	void add(T t);

	 /**
	 * Add all elements in the argument set
	 * @param s
	 */
	void addAll(Set<T> s);
	
	 /**
	 * Check if an element occurs in the set
	 * @param t
	 * @return true if element t occurs in set else false
	 */
	boolean contains(T t);
	
	 /**
	 * Remove an element
	 * @param t
	 */
	void remove(T t);

	 /**
	 *  Return the number of arguments in the set
	 * @return size of the set
	 */
	int size(); 
	
	 /**
	 * @return iterator over set
	 */
	Iterator<T> iterator();
}
