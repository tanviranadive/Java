package ast;

// Infix expression implements the Expression interface and method textRepresentation.
// Takes an operator and two expressions and creates an infix expression of them.
public class InfixExpression implements Expression{

	Operator op;
	Expression e1;
	Expression e2;
	
	public InfixExpression(Operator o, Expression exp1, Expression exp2){
		this.op = o;
		this.e1 = exp1;
		this.e2 = exp2;
	}
	
	// Implement textRepresentation declared by interface.
	// Returns string representation of the infix expression created
	// by concatenating and formatting string value of operator and expressions.
	public String textRepresentation(){
		return (this.e1.textRepresentation() + " " + this.op.toString() + " " + this.e2.textRepresentation());
	}
}
