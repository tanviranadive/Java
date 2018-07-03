package ast2;

// Class VariableExpression defines a type of variable expression
// Takes a Variable as input and textRepresentation returns a string
// representation of the variable.
public class VariableExpression implements Expression {

	private Variable var;
	
	public VariableExpression(Variable v){
		this.var = v;
	}
	
	public String textRepresentation(){
		return this.var.toString();
	}
	
}
