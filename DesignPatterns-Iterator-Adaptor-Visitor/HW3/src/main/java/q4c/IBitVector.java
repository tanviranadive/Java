package q4c;

public interface IBitVector {

	/**
	 * Determine if the bit at position i is set.
	 */
	public boolean get(int i);
	/**
	 * Set the bit at position i.
	 */
	public void set(int i);
	/**
	 * Clear the bit at position i.
	 */
	public void clear(int i);
	/**
	 * Set the bits in the argument BitVector b.
	 */
	public void copy(BitVector b);
	/**
	 * Determine the number of non-zero bits in the BitVector.
	 */
	public int size();
	/**
	 * Iterator over the Integer values represented by this BitVector.
	3
	 */
	public Iterator<Integer> iterator();

}
