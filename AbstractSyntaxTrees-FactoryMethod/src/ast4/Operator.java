package ast4;

// Class Operator represents any operator e.g +,-,*,/
// Takes a string as input and returns it as an operator string
public class Operator {
	String op;
	
	public Operator(String o){
		this.op = o;
	}
	
	// return string representation of operator.
	@Override
	public String toString(){
		return op;
	}
	
}
