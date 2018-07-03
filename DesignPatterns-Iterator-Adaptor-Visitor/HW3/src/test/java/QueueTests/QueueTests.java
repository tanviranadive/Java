package QueueTests;

import org.junit.Test;
import q2Queue.Queue;
import static org.junit.Assert.*;

public class QueueTests {

    /**
     * Rigorous Test
     */
    @Test
    public void add_AddElement_ShouldBeAddedInQueue()
    {
    	Queue<Integer> q = new Queue<Integer>();
    	assertEquals(true, q.add(5));
    	assertEquals(true, q.add(10));
    	assertEquals(true, q.add(26));
    }
    
    @Test
    public void peek_PeekElement_ShouldReturnLastAddedElement()
    {
    	Queue<Integer> q = new Queue<Integer>();
    	assertEquals(true, q.add(5));
    	assertEquals(true, q.add(10));
    	assertEquals(true, q.add(26));
    	assertEquals((Integer)26, q.peek());
    	
    }
    
    @Test
    public void remove_removeElementAtHead_ShouldReturnRemovedElement()
    {
    	Queue<Integer> q = new Queue<Integer>();
    	assertEquals(true, q.add(5));
    	assertEquals(true, q.add(10));
    	assertEquals(true, q.add(26));
    	assertEquals((Integer)5, q.remove());
    }
    
    @Test
    public void peek_removeOnlyElement_ShouldReturnNull()
    {
    	Queue<Integer> q = new Queue<Integer>();
    	assertEquals(true, q.add(5));
    	assertEquals((Integer)5, q.remove());
    	assertEquals(null,q.peek());
    }
    
    @Test
    public void remove_NoElementInQueue_ShouldReturnNull()
    {
    	Queue<Integer> q = new Queue<Integer>();
    	assertEquals(null, q.remove());
    }
    
    @Test
    public void add_remove_QueueTypeString()
    {
    	Queue<String> q = new Queue<String>();
    	assertEquals(true, q.add("Hello"));
    	assertEquals(true, q.add("World"));
    	assertEquals("World", q.peek());
    	assertEquals(true, q.add("Program"));
    	assertEquals("Hello", q.remove());
    	assertEquals("Program", q.peek());
    	assertEquals("World", q.remove());
    	
    }
    
}
