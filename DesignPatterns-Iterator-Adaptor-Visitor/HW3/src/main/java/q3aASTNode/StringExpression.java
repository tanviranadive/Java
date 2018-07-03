package q3aASTNode;

// Class for String expressions. Returns the string expression as String
// in textRepresentation method. String represented by "StringExpression".
public class StringExpression extends Expression{
	private String st;
	private int id;
	public StringExpression(String s){
		this.st = s;
		this.id = getCounter();
		setNodelist(this, this.id);
		incrementCounter();
	}
	
	/** method returns a string representing the expression. 
	* @return string textRepresentation
	*/
	public String textRepresentation(){
		return "\""+this.st+"\"";
	}
	
	/**
	 * getter for id of Node
	 */
	@Override
	public int getId() {
		return this.id;
	}
}
