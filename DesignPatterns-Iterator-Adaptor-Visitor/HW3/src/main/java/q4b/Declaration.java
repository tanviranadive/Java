package q4b;

//class used for Declaration operation. Implements Statement interface.
//Takes a Variable as input and returns its string representation.
public class Declaration extends Statement{
	private Variable var;
	private int id;
	
	//private static Declaration _theDeclaration = null;
	
	public Declaration(Variable v){
		var = v;
		this.id = counter;
		//setNodelist(this, this.id);
		counter++;
	}
	
	/*public static Declaration instance(){
		if(_theDeclaration == null){
			_theDeclaration = new Declaration();
		}
		
		return _theDeclaration;
	}*/
	
	// implement textRepresentation method of the interface.
	// Concatenates and formats the variable value in a string.
	public String textRepresentation(){
		return "var "+ var+ ";";
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
