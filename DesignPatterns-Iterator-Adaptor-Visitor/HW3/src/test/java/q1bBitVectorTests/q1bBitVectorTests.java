package q1bBitVectorTests;

import static org.junit.Assert.*;
import org.junit.Test;

import q1bBitVector.BitVector;
import q1bBitVector.Iterator;;


/**
 * Unit test for simple BitVector with Iterator.
 */
public class q1bBitVectorTests
{

    /**
     * Rigourous Test
     */
    @Test
    public void iterator_iterateOverBitVector_shouldReturnNextElement()
    {
    	BitVector bv = new BitVector();
    	bv.set(1);
    	bv.set(31);
    	bv.set(32);
    	bv.set(64);
    	Iterator<Integer> i = bv.iterator();
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)1,next);
    	}
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)31,next);
    	}
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)32,next);
    	}
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)64,next);
    	}
    }
    
    @Test
    public void iterator_hasNext_shouldReturnFalseIfNoNextElement(){
    	BitVector bv = new BitVector();
    	bv.set(1);
    	Iterator<Integer> i = bv.iterator();
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)1,next);
    	}
    	assertEquals(false, i.hasAnotherElement());
    }
    
    @Test
    public void iterator_hasNext_shouldReturnFalseIfNoElements(){
    	BitVector bv = new BitVector();
    	Iterator<Integer> i = bv.iterator();
    	assertEquals(false, i.hasAnotherElement());
    }
    
    @Test
    public void iterator_hasNext_shouldReturnFalseIfNextElementCleared(){
    	BitVector bv = new BitVector();
    	bv.set(10);
    	bv.set(29);
    	bv.clear(29);
    	Iterator<Integer> i = bv.iterator();
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)10,next);
    	}
    	assertEquals(false, i.hasAnotherElement());
    }
    
    @Test
    public void iterator_hasNext_shouldReturnTrueIfElementInBetweenTwoElementsCleared(){
    	BitVector bv = new BitVector();
    	bv.set(10);
    	bv.set(29);
    	bv.set(45);
    	bv.clear(29);
    	Iterator<Integer> i = bv.iterator();
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)10,next);
    	}
    	assertEquals(true, i.hasAnotherElement());
    }
    
    @Test
    public void hasNext_shouldReturnTrue_ElementInBetweenTwoElementsCleared(){
    	BitVector bv = new BitVector();
    	bv.set(10);
    	bv.set(29);
    	bv.set(45);
    	bv.clear(29);
    	Iterator<Integer> i = bv.iterator();
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)10,next);
    	}
    	assertEquals((Integer)45, i.nextElement());
    }
    
    @Test
    public void nextElement_ShouldReturnNull_CalledDirectlyNoElementPresent(){
    	BitVector bv = new BitVector();
    	bv.set(10);
    	bv.set(29);
    	bv.clear(29);
    	Iterator<Integer> i = bv.iterator();
    	if(i.hasAnotherElement()){
    		Integer next = i.nextElement();
    		assertEquals((Integer)10,next);
    	}
    	assertEquals(null, i.nextElement());
    }
}
