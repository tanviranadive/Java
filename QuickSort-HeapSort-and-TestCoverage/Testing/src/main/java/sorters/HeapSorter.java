package sorters;

/**
 * Program adapted from http://javaingrab.blogspot.com/2013/05/implementation-of-heapsort-algorithm.html
 * for reference
 * 
 * Class HeapSorter implements the interface Sorter<T> where T is a generic data type.
 * It implements the sort method from the interface Sorter and uses heap sort using max heap technique to
 * sort the elements provided as input in sort method
 * @param <T>
 */
public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {

	/**
	 * array of elements and heap size
	 */
	private T array[];
	private int heapSize;
	
	/**
	 * Method implemented from interface Sorter, sorts the input array of elements
	 * @param T[] list
	 */
	public void sort(T[] list) {
		array = list;
		buildMaxHeap();
		
		for(int i=array.length-1;i>=0;i--){
			// swap element at i with first element and then reheapify with that element as first
			swap(0,i);
			heapSize--;
			heapify(0);
		}
		
	}
	
	/**
	 * Method builds the heap as a max heap
	 */
	private void buildMaxHeap(){
		heapSize = array.length -1;
		for(int i=heapSize/2;i>=0;i--){
			
			// reheapify with ith element
			heapify(i);
		}
	}
	
	/**
	 * Method reheapifies with index i
	 * @param i
	 */
	private void heapify(int i){
		// left and right elements
		int left = 2*i;
		int right = 2*i + 1;
		
		int max;
		// compare left element and i th element 
		if(left<=heapSize && compare(array[left],array[i])>0){
			max = left;
		}
		else
			max = i;
		
		// compare right element and max element 
		if(right<=heapSize && compare(array[right],array[max])>0){
			max = right;
		}
		
		// if max and i are not the same, then swap
		if(max!=i){
			swap(max,i);
			heapify(max);
		}
	}
	
	/**
	 * Method swaps the two elements at given indices i and j
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j){
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * Method compares two elements and checks if first is smaller than second
	 * @param a
	 * @param b
	 * @return -1 if first element is less than second, else 1
	 */
	private int compare(T a, T b){
		// handle null so that null is smaller than other elements
		 if(a == null)
			 return -1;
		 else if(b == null)
			 return 1;
		 else return a.compareTo(b);
	 }
}
