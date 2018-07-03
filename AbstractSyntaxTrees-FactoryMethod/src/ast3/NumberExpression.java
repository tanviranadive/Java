package ast3;

// Number expression implements the Expression interface and method textRepresentation.
// Takes a Number and creates an expression out of it in the form of a number string.
public class NumberExpression implements Expression{
	Number num;
	public NumberExpression(Number n){
		this.num = n;
	}
	
	// Implement textRepresentation declared by interface.
	// Returns string representation of the number expression
	public String textRepresentation(){
		return this.num.toString();
	}
}
