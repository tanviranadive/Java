package q2Queue;

import java.util.ArrayList;

// Class Queue implements a generic type of queue
public class Queue<T> implements IQueue<T>{

	private ArrayList<T> list;
	private int index;
	
	/**
	 * Constructor initializes queue list and start index
	 */
	public Queue() {
		list = new ArrayList<>();
		index = 0;
	}
	
	/**
	 * Method adds element t of generic type T to the queue
	 * @params t
	 * @return true if element added successfully else false
	 */
	@Override
	public boolean add(T t) {
		list.add(t);
		index++;
		return true;
	}

	/**
	 * Method removes element at the tail
	 * @return t element that was removed
	 */
	@Override
	public T remove() {
		if(!list.isEmpty()) {
			T t = list.get(0);
			list.remove(0);
			index--;
			return t;
		} else {
			return null;
		}
	}

	/**
	 * Method returns the element at the head
	 * @return t the last element added to queue, null if queue is empty
	 */
	@Override
	public T peek() {
		if(!list.isEmpty()) {
			return list.get(index-1);
			
		} else {
			return null;
		}
	}
}
