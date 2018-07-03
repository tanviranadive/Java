package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sorters.HeapSorter;
import sorters.Sorter;
import sorters.Person;

public class Tests {

	 /**
     * Method for creating a HeapSorter.
     * @return HeapSorter of type T
     */
    private static <T extends Comparable<T>> Sorter<T> createSorter(){
      return new HeapSorter<T>();
    }
 // -----------------------------------------------
    // sort an array with multiple elements
    
    @Test
  	public void TestManyElementsArray() {
      	Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {8,4,9,3,1,2};
  		sorter.sort(arr);
  		Integer[] res = {1,2,3,4,8,9};
  		assertArrayEquals(res,arr);
  	}

    // -----------------------------------------------
    // Test an already sorted array
    
  	@Test
  	public void TestAlreadySorted_array() {
  		Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {1,2,3,4,8,9};
  		sorter.sort(arr);
  		Integer[] res = {1,2,3,4,8,9};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an empty array of string
  	
  	@Test
  	public void TestEmpty_array() {
  		Sorter<String> sorter = createSorter();
  		String[] arr = {};
  		sorter.sort(arr);
  		String[] res = {};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an empty array of inte
  	
   	@Test
   	public void TestEmptyIntegerArray() {
   		Sorter<Integer> sorter = createSorter();
   		Integer[] arr = {};
   		sorter.sort(arr);
   		Integer[] res = {};
   		assertArrayEquals(res,arr);
   	}
  	
    // -----------------------------------------------
   	// sort an empty array of int
  	
   	@Test
   	public void TestEmpty_IntegerArray() {
   		Sorter<Integer> sorter = createSorter();
   		Integer[] arr = {};
   		sorter.sort(arr);
   		Integer[] res = {};
   		assertArrayEquals(res,arr);
   	}
  	
    // -----------------------------------------------
  	// sort an array of integers
   	
  	@Test
  	public void TestInts_array() {
  		Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {2,3,1,7,0};
  		sorter.sort(arr);
  		Integer[] res = {0,1,2,3,7};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of floats
  	
  	@Test
  	public void TestFloat_array() {
  		Sorter<Float> sorter = createSorter();
  		Float[] arr = {-1.7f,3.8f,3.89f,0.0f};
  		sorter.sort(arr);
  		Float[] res = {-1.7f,0.0f,3.8f,3.89f};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of doubles
  	
  	@Test
  	public void TestDoubleArray_array() {
  		Sorter<Double> sorter = createSorter();
  		Double[] arr = {-1.7,3.8,3.89,0.0,3.0};
  		sorter.sort(arr);
  		Double[] res = {-1.7,0.0,3.0,3.8,3.89};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of Strings
  	
  	@Test
  	public void TestStringArray_array() {
  		Sorter<String> sorter = createSorter();
  		String[] arr = { "dog", "cat", "pig", "cow", "horse"};
  		sorter.sort(arr);
  		String[] res = {"cat", "cow", "dog", "horse", "pig"};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of User Defined type
  	
  	@Test
  	  public void TestOneUserDefinedArray(){
  	    Sorter<Person> sorter = createSorter();
  	    Person[] people = { new Person("Tanvi") };
  	    sorter.sort(people);
  	    Person[] sorted = { new Person("Tanvi") };
  	    assertArrayEquals(people, sorted);
  	  }
  	
    // -----------------------------------------------
  	// sort an array of null of user defined type
  	
  	@Test
  	  public void TestUserDefinedNull(){
  	    Sorter<Person> sorter = createSorter();
  	    Person[] people = {null};
  	    sorter.sort(people);
  	    Person[] sorted = {null};
  	    assertArrayEquals(people, sorted);
  	  }
  	
    // -----------------------------------------------
  	// sort an array with many nulls
  	
  	@Test
  	  public void TestManyNulls(){
  	    Sorter<Integer> sorter = createSorter();
  	    Integer[] arr = {null,2,7,100,65,null,97};
  	    sorter.sort(arr);
  	    Integer[] sorted = {null,null,2,7,65,97,100};
  	    assertArrayEquals(arr, sorted);
  	  }
  	   
    // -----------------------------------------------
  	// sort an array of positives and negative integers
  	
  	@Test
  	public void TestPositiveNegative_array() {
  		Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {-1,2,3,-4,-8,9};
  		sorter.sort(arr);
  		Integer[] res = {-8,-4,-1,2,3,9};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of all negative integers
  	
  	@Test
  	public void TestAllNegative_array() {
  		Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {-1,-2,-3,-4,-8,-9};
  		sorter.sort(arr);
  		Integer[] res = {-9,-8,-4,-3,-2,-1};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of same integers (negative)
  	
  	@Test
  	public void TestSameElements_negativeArray() {
  		Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {-1,-1,-1};
  		sorter.sort(arr);
  		Integer[] res = {-1,-1,-1};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of same Strings
  	
  	@Test
  	public void TestSameElements_StringArray() {
  		Sorter<String> sorter = createSorter();
  		String[] arr = {"hello","hello","hello"};
  		sorter.sort(arr);
  		String[] res = {"hello","hello","hello"};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of one element
  	@Test
  	public void TestOneElement_array() {
  		Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {0};
  		sorter.sort(arr);
  		Integer[] res = {0};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// sort an array of min and max integers
  	
  	@Test
  	public void TestMaxMinValue_array() {
  		Sorter<Integer> sorter = createSorter();
  		Integer[] arr = {-1,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
  		sorter.sort(arr);
  		Integer[] res = {Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	// Sort an String array with null 
  	
  	@Test
  	public void TestNulls() {
  		Sorter<String> sorter = createSorter();
  		String[] arr = {"hello","test",null,""};
  		sorter.sort(arr);
  		String[] res = {null,"","hello","test"};
  		assertArrayEquals(res,arr);
  	}
  	
    // -----------------------------------------------
  	//sort an array with large numbers
  	@Test
  	public void TestLargeNumbersIntegerArray(){
  		Sorter<Integer> sorter = createSorter();
  		int n = 100000;
  		Integer[] numbers = new Integer[n];
  	    Integer[] sorted = new Integer[n];
  	    for (int i=0; i < n; i++){
  	      sorted[i] = i;
  	      numbers[n-i-1] = i;
  	    }
  	    sorter.sort(numbers);
  	    assertArrayEquals(sorted,numbers);
  	}
	
}

