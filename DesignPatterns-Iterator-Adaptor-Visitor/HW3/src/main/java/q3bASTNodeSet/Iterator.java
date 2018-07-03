package q3bASTNodeSet;

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
