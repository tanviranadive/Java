package ast;

//class used for Declaration operation. Implements Statement interface.
//Takes a Variable as input and returns its string representation.
public class Declaration implements Statement{
	private Variable var;
	public Declaration(Variable v){
		var = v;
	}
	
	// implement textRepresentation method of the interface.
	// Concatenates and formats the variable value in a string.
	public String textRepresentation(){
		return "var "+ var+ ";";
	}
}
