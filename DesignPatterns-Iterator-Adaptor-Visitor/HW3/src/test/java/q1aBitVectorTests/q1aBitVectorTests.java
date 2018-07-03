package q1aBitVectorTests;

import static org.junit.Assert.*;
import org.junit.Test;
import q1aBitVector.BitVector;

/**
 * Unit test for BitVector.
 */
public class q1aBitVectorTests 
{

    /**
     * Rigorous Test
     */
    @Test
    public void set_bits_checkIfSet()
    {
    	BitVector bv = new BitVector();
    	bv.set(1);
    	bv.set(31);
    	bv.set(32);
        assertEquals(true, bv.get(32));
    }
    
    
    @Test
    public void set_bits_check()
    {
    	BitVector bv = new BitVector();
    	bv.set(210);
    	bv.set(67);
        assertEquals(true,bv.get(210));
        assertEquals(true,bv.get(67));
    }
    
    
    @Test
    public void size_setBits_checkSize()
    {
    	BitVector bv = new BitVector();
    	bv.set(62);
    	bv.set(34);
    	bv.set(102);
        assertEquals(3,bv.size());
    }
    
    @Test
    public void get_checkBitNotSet_shouldReturnFalse()
    {
    	BitVector bv = new BitVector();
    	bv.set(62);
    	bv.set(34);
        assertEquals(false,bv.get(30));
    }
    
    @Test
    public void size_NoBitsSet_ShouldReturnZero()
    {
    	BitVector bv = new BitVector();
        assertEquals(0,bv.size());
    }
    
    @Test
	public void copy_setBits_shouldSetBitsInCaller(){
		BitVector bv1 = new BitVector();
    	bv1.set(1);
    	bv1.set(31);
    	BitVector bv2 = new BitVector();
    	bv2.set(70);
    	bv2.set(2);
    	bv1.copy(bv2);
    	assertEquals(4,bv1.size());
    	assertEquals(true,bv1.get(70));
    	assertEquals(true,bv1.get(2));
	}
    
    @Test
	public void clear_getBits_shouldClearTheBit(){
		BitVector bv = new BitVector();
    	bv.set(62);
    	bv.set(10);
    	bv.clear(10);
    	assertEquals(false,bv.get(10));
	}
    
}
