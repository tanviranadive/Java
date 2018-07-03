package q3bASTNodeSet;

public class BitVector implements IBitVector {

	/**
	 * The bits is the integer array
	 */
	private int[] bits;
	
	/**
	 * rowSize is the number of bits that are represented in one integer element of bits array
	 */
	int rowSize = 31;
	
	/**
	 * The count stores number of set bits in BitVector array
	 */
	int count;

	public BitVector() {
		bits = new int[100];
		count = 0;
	}
	
	public BitVector(int n){
		bits = new int[n];
		count = 0;
	}
	
	/**
	 * @return bits array
	 */
	public int[] getBits(){
		return this.bits;
	}

	/**
	 * Method get takes input integer i and returns if the bit is set or not.
	 * @param i
	 * @return true if bit i is set else false
	 */
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
	public int size() {
		return this.count;
	}

	/**
	 * Iterator for BitVector.
	 */
	public Iterator<Integer> iterator() {
		return new IteratorClass();
	}

	/**
	 * @author Tanvi
	 * IteratorClass provides implementation of methods to iterate over BitVector array
	 *
	 */
	private class IteratorClass implements Iterator<Integer> {


		/**
		 * Keep track of index in integer array and index within the bits of integer
		 */
		int row;
		int col;
		
		/**
		 * Keep track of number of elements returned till now and total number of elements.
		 */
		int countReturned;
		int totalElements;

		/**
		 * Constructor initialize variables.
		 */
		public IteratorClass() {
			row = 0;
			col = rowSize+1;
			countReturned = 0;
			totalElements = size();
		}

		/**
		 * Method returns if the BitVector iterated over has another element
		 * @return true if there exists another element else false
		 */
		public boolean hasAnotherElement() {
			return (countReturned < totalElements);
		}

		/**
		 * Method returns the next element in the BitVector
		 * @return next integer which is set in BitVector, if none return null
		 */
		public Integer nextElement() {
			for (int r = row; r < bits.length; r++) {
				StringBuilder binary = new StringBuilder(String.format("%32s", Integer.toBinaryString(bits[r])));
				int start = (r == row) ? col - 1 : rowSize;
				for (int c = start; c > 0; c--) {
					if (binary.charAt(c) == '1') {
						col = c;
						row = r;
						countReturned++;
						return (row * rowSize + (rowSize - col) + 1);
					}
				}
			}
			
			return null;
		}
	}
}
