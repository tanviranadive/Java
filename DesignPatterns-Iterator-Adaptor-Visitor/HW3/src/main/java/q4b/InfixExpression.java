package q4b;

// Infix expression implements the Expression interface and method textRepresentation.
// Takes an operator and two expressions and creates an infix expression of them.
public class InfixExpression extends Expression{

	Operator operator;
	Expression expression1;
	Expression expression2;
	private int id;
	
	public InfixExpression(Operator o, Expression exp1, Expression exp2){
		this.operator = o;
		this.expression1 = exp1;
		this.expression2 = exp2;
		this.id = counter;
		//setNodelist(this, this.id);
		counter++;
	}
	
	// Implement textRepresentation declared by interface.
	// Returns string representation of the infix expression created
	// by concatenating and formatting string value of operator and expressions.
	public String textRepresentation(){
		return (this.expression1.textRepresentation() + " " + this.operator.toString() + " " + this.expression2.textRepresentation());
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
