package sorters;

/**
 * Class Person has field name and overrides the compareTo method to compare two
 * person objects on the basis on name
 * @author Tanvi
 *
 */
public class Person implements Comparable<Person>{
	String name;
	public Person(String s){
		this.name = s;
	}
	
	/**
	 * Method compares two person on the basis of name
	 * @param p
	 * @return 1 or -1 after comparing the person object on name
	 */
	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);
	}
	
	/**
	 * Method equals checks if two objects are equal for person
	 * @param p
	 * @return true if p is equal to current object else false
	 */
	 @Override
	    public boolean equals(Object p) {
		 return (this.name.equals(((Person)p).name));
	    }
	
}

