package q4b;

// Class VariableExpression defines a type of variable expression
// Takes a Variable as input and textRepresentation returns a string
// representation of the variable.
public class VariableExpression extends Expression {

	private Variable var;
	private int id;
	
	public VariableExpression(Variable v){
		this.var = v;
		this.id = counter;
		//setNodelist(this, this.id);
		counter++;
	}
	
	public String textRepresentation(){
		return this.var.toString();
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
