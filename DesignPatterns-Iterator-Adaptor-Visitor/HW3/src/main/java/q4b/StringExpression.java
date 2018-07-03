package q4b;

// Class for String expressions. Returns the string expression as String
// in textRepresentation method. String represented by "StringExpression".
public class StringExpression extends Expression{
	private String st;
	private int id;
	public StringExpression(String s){
		this.st = s;
		this.id = counter;
		//setNodelist(this, this.id);
		counter++;
	}
	
	// method implemented from interface. Returns string representation
	// of given expression.
	public String textRepresentation(){
		return "\""+this.st+"\"";
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
