package q3aASTNode;

//Prefix expression implements the Expression interface and method textRepresentation.
//Takes an operator and two expressions and creates a prefix expression of them.
public class PrefixExpression extends Expression{

	private Operator op;
	private Expression e1;
	private Expression e2;
	private int id;
	
	public PrefixExpression(Operator o, Expression exp1, Expression exp2){
		this.op = o;
		this.e1 = exp1;
		this.e2 = exp2;
		this.id = getCounter();
		setNodelist(this, this.id);
		incrementCounter();
	}
	
	/** Implement textRepresentation declared by interface.
	* Returns string representation of the prefix expression created
	* by concatenating and formatting string value of operator and expressions.
	* @return string textRepresentation
	*/
	public String textRepresentation(){
		return (this.op.toString() + " " + this.e1.textRepresentation() + " " + this.e2.textRepresentation());
	}

	/**
	 * getter for id of Node
	 */
	@Override
	public int getId() {
		return this.id;
	}
}
