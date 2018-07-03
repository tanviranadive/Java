package ast3;

// Class Variable represents a variable e.g x, y
// toString method returns string representation of the variable.
public class Variable {
	String var;
	public Variable(String x){
		this.var = x;
	}
	
	@Override
	public String toString(){
		return this.var;
	}
	
}
