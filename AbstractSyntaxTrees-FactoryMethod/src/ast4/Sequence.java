package ast4;

import java.util.ArrayList;
import java.util.List;

// Class Sequence implements the Statement interface and textRepresentation method.
// Takes any number of arguments and returns a sequence representing the statements
// separated by spaces.
public class Sequence implements Statement{

	List<Statement> statements = new ArrayList<>();

	// Constructor can take any number of statements as arguments
	public Sequence(Statement... ls){
		for(Statement s : ls){
			this.statements.add(s);
		}
	}
	
	// method returns a string representing the statements. Statements can be declarations
	// or Assignments.
	public String textRepresentation(){
		StringBuilder res = new StringBuilder();
		for(Statement i:this.statements){
			res.append(" "+ i.textRepresentation());
		}
		
		return res.toString().trim();
	}
}
