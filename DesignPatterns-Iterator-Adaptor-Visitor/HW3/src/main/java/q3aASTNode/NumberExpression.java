package q3aASTNode;

// Number expression implements the Expression interface and method textRepresentation.
// Takes a Number and creates an expression out of it in the form of a number string.
public class NumberExpression extends Expression{
	private Number num;
	private int id;
	
	public NumberExpression(Number n){
		this.num = n;
		this.id = getCounter();
		setNodelist(this, this.id);
		incrementCounter();
	}
	
	// Implement textRepresentation declared by interface.
	// Returns string representation of the number expression
	public String textRepresentation(){
		return this.num.toString();
	}

	/**
	 * getter for id of Node
	 */
	@Override
	public int getId() {
		return this.id;
	}
}
