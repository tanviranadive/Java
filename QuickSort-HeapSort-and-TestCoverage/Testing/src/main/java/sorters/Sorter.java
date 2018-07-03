package sorters;

 /**
 * Generic interface for sorting an array of elements in-place.
 */
 public interface Sorter<T extends Comparable<T>> {
	 
	 /**
	  * Method for sorting input array of generic type
	  * @param list
	  */
	 void sort(T[] list);
}
