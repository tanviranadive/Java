package q4c;

public interface Iterator<T> {
	/**
	* Check if there are more elements
	*/
	 boolean hasAnotherElement();
	 /**
	* Return the next element
	*/
	 T nextElement();
}
