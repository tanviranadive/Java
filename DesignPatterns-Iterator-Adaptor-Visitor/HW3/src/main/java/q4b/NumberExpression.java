package q4b;

// Number expression implements the Expression interface and method textRepresentation.
// Takes a Number and creates an expression out of it in the form of a number string.
public class NumberExpression extends Expression{
	private Number num;
	private int id;
	public NumberExpression(Number n){
		this.num = n;
		this.id = counter;
		//setNodelist(this, this.id);
		counter++;
	}
	
	// Implement textRepresentation declared by interface.
	// Returns string representation of the number expression
	public String textRepresentation(){
		return this.num.toString();
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
