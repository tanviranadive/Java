package q1aBitVector;

// Class BitVector stores an array of integers for compact representation of bits
public class BitVector implements IBitVector{

	/**
	 * The bits is the integer array
	 */
	private int[] bits;
	
	/**
	 * rowSize is the number of bits that are represented in one integer element of bits array
	 */
	private int rowSize = 31;
	
	/**
	 * The count stores number of set bits in BitVector array
	 */
	private int count;

	/**
	 * Constructor for BitVector, initializes bits array and
	 * count variable for keeping track of set bits.
	 */
	public BitVector() {
		bits = new int[100];
		count = 0;
	}

	/**
	 * Method get takes input integer i and returns if the bit is set or not.
	 * @param i
	 * @return true if bit i is set else false
	 */
	@Override
	public boolean get(int i) {
		int num = i - 1;
		int row = num / rowSize;
		int col = num % rowSize;
		String value = String.format("%32s", Integer.toBinaryString(this.bits[row])).replace(" ", "0");
		char val = value.charAt(31 - col);
		return (val == '1');
	}

	/**
	 * Method set takes input integer i and sets the bit at position i.
	 * @param i
	 */
	@Override
	public void set(int i) {
		int num = i - 1;
		int row = num / rowSize;
		int col = num % rowSize;
		StringBuilder toBin = new StringBuilder(
				String.format("%32s", Integer.toBinaryString(this.bits[row])).replace(" ", "0"));
		toBin.setCharAt(31 - col, '1');
		this.bits[row] = Integer.parseInt(toBin.toString(), 2);
		count++;
	}

	/**
	 * Method clear takes input integer i and clears the bit at position i.
	 * @param i
	 */
	@Override
	public void clear(int i) {
		int num = i - 1;
		int row = num / rowSize;
		int col = num % rowSize;
		StringBuilder toBin = new StringBuilder(
				String.format("%32s", Integer.toBinaryString(this.bits[row])).replace(" ", "0"));
		toBin.setCharAt(31 - col, '0');
		this.bits[row] = Integer.parseInt(toBin.toString(), 2);
		count--;
	}

	/**
	 * Method copy takes input BitVector b and sets the bits of b in current BitVector.
	 * @param b
	 */
	@Override
	public void copy(BitVector b) {
		for (int i = 0; i < this.bits.length; i++) {
			StringBuilder binary = new StringBuilder(
					String.format("%32s", Integer.toBinaryString(b.bits[i])).replace(" ", "0"));
			StringBuilder binary1 = new StringBuilder(
					String.format("%32s", Integer.toBinaryString(this.bits[i])).replace(" ", "0"));
			for (int j = 0; j < binary1.toString().length(); j++) {
				if (binary1.charAt(j) != '1' && binary.charAt(j) == '1') {
					binary1.setCharAt(j, '1');
					count++;
				}
			}

			bits[i] = Integer.parseInt(binary1.toString(), 2);

		}
	}

	/**
	 * Method returns the number of bits that are set in BitVector.
	 * @return count
	 */
	@Override
	public int size() {
		return this.count;
	}

	/**
	 * Iterator for BitVector. To be implemented
	 */
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
