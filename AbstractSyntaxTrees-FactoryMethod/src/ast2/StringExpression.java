package ast2;

// Class for String expressions. Returns the string expression as String
// in textRepresentation method. String represented by "StringExpression".
public class StringExpression implements Expression{
	String st;
	public StringExpression(String s){
		this.st = s;
	}
	
	// method implemented from interface. Returns string representation
	// of given expression.
	public String textRepresentation(){
		return "\""+this.st+"\"";
	}
}
