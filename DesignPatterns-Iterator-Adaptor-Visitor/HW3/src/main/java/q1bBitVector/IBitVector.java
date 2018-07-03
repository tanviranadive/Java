package q1bBitVector;

public interface IBitVector {

	/**
	 * Determine if the bit at position i is set.
	 * @param i
	 * @return
	 */
	public boolean get(int i);
	
	/**
	 * Set the bit at position i.
	 * @param i
	 */
	public void set(int i);
	
	/**
	 *  Clear the bit at position i.
	 * @param i
	 */
	public void clear(int i);
	
	/**
	 * Set the bits in the argument BitVector b.
	 * @param b
	 */
	public void copy(BitVector b);
	
	/**
	 *  Determine the number of non-zero bits in the BitVector.
	 * @return
	 */
	public int size();
	
	/**
	 * Iterator over the Integer values represented by this BitVector.
	 * @return
	 */
	public Iterator<Integer> iterator();

}
