package sorters;

/**
 * Program adapted from https://www.geeksforgeeks.org/iterative-quick-sort/ for Iterative quicksort
 * for reference
 * 
 * Class QuickSorter implements the interface Sorter<T> where T is a generic data type.
 * It implements the sort method from the interface Sorter and uses quicksort technique to
 * sort the elements provided as input in sort method
 */
public class QuickSorter<T extends Comparable<T>> implements Sorter<T>{

	/**
	 *  The array of elements to be sorted and its length
	 */
	private T array[];
	private int n;
	
	/**
	 * Method implemented from interface Sorter, sorts the input array of elements
	 * @param T[] list
	 */
	public void sort(T[] list) {
		  n=list.length;
	      array=list;
	      
	      // call quickSort if there are elements to be sorted
	      if(n>1)
	    	  quickSort(0,n-1);
	}
	
	/**
	 * Method quickSort sorts the elements by partitioning and sorting by considering pivot element
	 * @param p
	 * @param q
	 * p is the lower index(start) and q is the higher index(end) for the partition to be sorted 
	 */
	private void quickSort(int low, int high){
		
		/*
		 * Initialize a stack array to store the start and end indices of partitions
		 */
		int stack[] = new int[high-low+1];
		int top = -1;
		
		// Insert start and end indices into the stack intially
		stack[++top] = low;
		stack[++top] = high;
		
		// While there are elements in the stack, i.e partitions to be processed, sort the partitions
		while(top>=0){
			high = stack[top--];
			low = stack[top--];
			
			// Call the partition method to get the partition index
			int j = partition(low,high);
			
			// partition array around the partition index and insert the indices into stack
			if(j-1>low){
				stack[++top] = low;
				stack[++top] = j-1;
			}
			
			if(j+1 < high){
				stack[++top] = j+1;
				stack[++top] = high;
			}
		}
		
	}
	 
	/**
	 * Method returns partition index around which array is to be partitioned
	 * @param p
	 * @param q
	 * @return the partition index as integer
	 */
	private int partition(int p, int q){
		T pivot = array[q];
		int i = p-1;
		
		// Compare elements and partition by intermediate sorting
		for(int j = p; j<q; j++){
			
			// Compare method checks if element is smaller than pivot, and swaps them
			if(compare(array[j],pivot)<0){
				i=i+1;
				T temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				}
			}
		i=i+1;
		T temp=array[i]; array[i]=array[q]; array[q]=temp;
		return i;
		}
	    
	/**
	 * Method compares the two elements given as input to check if first is smaller than second
	 * @param a
	 * @param b
	 * @return -1 if first element is smaller than second, 1 otherwise
	 */
	    private int compare(T a, T b){
	    	
	    	
	    	//handling null so that null is considered to be smaller of the two elements.
	    	if(a == null)
	    		return -1;
	    	else if(b == null)
	    		return 1;
	    	else
	    		return a.compareTo(b);
	    }
	
}
