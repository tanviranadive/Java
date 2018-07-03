package q2Queue;

/**
* A generic queue
*/
public interface IQueue<T> {

 /**
 * add an element to the head of the queue
 * @param t
 * @return true if t added successfully else false
 */
boolean add(T t);

 /**
  * remove an element from the end of the queue. Returns null if queue is empty
 * @return t element which was removed
 */
T remove();

 /**
  * returns the head of the queue. Returns null if queue is empty
 * @return t element at the head
 */
T peek();
}