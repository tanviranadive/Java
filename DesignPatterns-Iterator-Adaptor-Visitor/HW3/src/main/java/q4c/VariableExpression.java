package q4c;

// Class VariableExpression defines a type of variable expression
// Takes a Variable as input and textRepresentation returns a string
// representation of the variable.
public class VariableExpression extends Expression {

	private Variable var;
	private int id;
	
	public VariableExpression(Variable v){
		this.var = v;
		this.id = counter;
		counter++;
	}
	
	public String textRepresentation(){
		return this.var.toString();
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
