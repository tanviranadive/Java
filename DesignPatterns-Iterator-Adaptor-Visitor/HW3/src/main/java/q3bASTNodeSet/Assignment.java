package q3bASTNodeSet;

// class used for Assignment operation. Implements Statement interface.
// Takes a Variable and Expression as input and assigns the expression to the variable.
// textRepresentation method returns a string value of the assignment.
public class Assignment extends Statement{
	private Variable var;
	private Expression exp;
	private int id;
	
	public Assignment(){
	}
	
	public Assignment(Variable x, Expression e){
		this.var = x;
		this.exp = e;
		this.id = counter;
		counter++;
	}
	
	/** 
	* Implement textRepresentation method of the interface.
	*Concatenates and formats the variable and expression value in a string
	*@return string textRepresentation
	*/
	public String textRepresentation(){
		return (this.var.toString() + " = " +  this.exp.textRepresentation() + ";");
	}
	
	/**
	 * getter for id of Node
	 */
	public int getId(){
		return this.id;
	}
	
}

