package ast2;

import ast2.Expression;
import ast2.Statement;
import ast2.Variable;

// class used for Assignment operation. Implements Statement interface.
// Takes a Variable and Expression as input and assigns the expression to the variable.
// textRepresentation method returns a string value of the assignment.
public class Assignment implements Statement{
	private Variable var;
	private Expression exp;
	public Assignment(){
	}
	
	public Assignment(Variable x, Expression e){
		this.var = x;
		this.exp = e;
	}
	
	// implement textRepresentation method of the interface.
	// Concatenates and formats the variable and expression value in a string
	public String textRepresentation(){
		return (this.var.toString() + " = " +  this.exp.textRepresentation() + ";");
	}
	
}

