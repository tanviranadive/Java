package q4b;

public interface ASTVisitor {

	public void visit(Declaration d);
	public void visit(Assignment assign);
	public void visit(Sequence seq);
	public void visit(NumberExpression numexp);
	public void visit(StringExpression stringexp);
	public void visit(VariableExpression varexp);
	public void visit(InfixExpression inexp);
	public void visit(PrefixExpression preexp);
}
