package q4b;

import java.util.ArrayList;
import java.util.List;

// Class Sequence implements the Statement interface and textRepresentation method.
// Takes any number of arguments and returns a sequence representing the statements
// separated by spaces.
public class Sequence extends Statement{

	private List<Statement> statements = new ArrayList<>();
	private int id;

	// Constructor can take any number of statements as arguments
	public Sequence(Statement... ls){
		for(Statement s : ls){
			this.statements.add(s);
			this.id = counter;
			//setNodelist(this, this.id);
			counter++;
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

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void accept(ASTNodeCountVisitor avisitor) {
		// TODO Auto-generated method stub
		avisitor.visit(this);
	}
}
