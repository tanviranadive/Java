package q4c;

//class used for Declaration operation. Implements Statement interface.
//Takes a Variable as input and returns its string representation.
public class Declaration extends Statement{
	private Variable var;
	private int id;
	
	public Declaration(Variable v){
		var = v;
		this.id = counter;
		counter++;
	}
	
	// implement textRepresentation method of the interface.
	// Concatenates and formats the variable value in a string.
	public String textRepresentation(){
		return "var "+ var+ ";";
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void accept(ASTVisitor avisitor) {
		
		avisitor.visit(this);
		
	}
	
}
