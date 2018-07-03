package q4b;

public class BitVector implements IBitVector {

	private int[] bits;
	int rowSize = 31;
	int count;

	public BitVector() {
		bits = new int[100];
		count = 0;
	}
	
	public BitVector(int n){
		bits = new int[n];
		count = 0;
	}
	
	public int[] getBits(){
		return this.bits;
	}

	public boolean get(int i) {
		int num = i - 1;
		int row = num / rowSize;
		int col = num % rowSize;
		String value = String.format("%32s", Integer.toBinaryString(this.bits[row])).replace(" ", "0");
		char val = value.charAt(31 - col);
		return (val == '1');
	}

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

	public int size() {
		return this.count;
	}

	public Iterator<Integer> iterator() {
		return new IteratorClass();
	}

	private class IteratorClass implements Iterator<Integer> {

		int row;
		int col;
		int countReturned;
		int totalElements;

		public IteratorClass() {
			row = 0;
			col = rowSize+1;
			countReturned = 0;
			totalElements = size();
		}

		public boolean hasAnotherElement() {
			return (countReturned < totalElements);
		}

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
