package q3aASTNode;

// Class VariableExpression defines a type of variable expression
// Takes a Variable as input and textRepresentation returns a string
// representation of the variable.
public class VariableExpression extends Expression {

	private Variable var;
	private int id;
	
	public VariableExpression(Variable v){
		this.var = v;
		this.id = getCounter();
		setNodelist(this, this.id);
		incrementCounter();
	}
	
	/** method returns a string representing the expression.
	* @return string textRepresentation
	*/
	public String textRepresentation(){
		return this.var.toString();
	}

	/**
	 * getter for id of Node
	 */
	@Override
	public int getId() {
		return this.id;
	}
	
}
