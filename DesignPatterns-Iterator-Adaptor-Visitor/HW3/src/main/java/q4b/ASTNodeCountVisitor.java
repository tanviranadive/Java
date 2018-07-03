package q4b;

public class ASTNodeCountVisitor implements ASTVisitor{

	private int totalDeclarationCount;
	private int totalAssignmentCount;
	private int totalSequenceCount;
	private int totalNumExpressionCount;
	private int totalStringExpressionCount;
	private int totalVarExpressionCount;
	private int totalInfixExpressionCount;
	private int totalPrefixExpressionCount;
	
	public ASTNodeCountVisitor(){
		totalDeclarationCount = 0;
		totalAssignmentCount = 0;
		totalSequenceCount = 0;
		totalNumExpressionCount = 0;
		totalStringExpressionCount = 0;
		totalVarExpressionCount = 0;
		totalInfixExpressionCount = 0;
		totalPrefixExpressionCount = 0;
	}
	
	public void visit(Declaration d){
		totalDeclarationCount++;
	}
	public void visit(Assignment assign){
		totalAssignmentCount++;
	}
	public void visit(Sequence seq){
		totalSequenceCount++;
	}
	public void visit(NumberExpression numexp){
		totalNumExpressionCount++;
	}
	public void visit(StringExpression stringexp){
		totalStringExpressionCount++;
	}
	public void visit(VariableExpression varexp){
		totalVarExpressionCount++;
	}
	public void visit(InfixExpression inexp){
		totalInfixExpressionCount++;
	}
	public void visit(PrefixExpression preexp){
		totalPrefixExpressionCount++;
	}
	
	public int getDeclarationCount(){
		return totalDeclarationCount;
	}
	
	public int getAssignmentCount(){
		return totalAssignmentCount;
	}
	public int getSequenceCount(){
		return totalSequenceCount;
	}
	public int getNumExpressionCount(){
		return totalNumExpressionCount;
	}
	public int getStringExpressionCount(){
		return totalStringExpressionCount;
	}
	public int getVarExpressionCount(){
		return totalVarExpressionCount;
	}
	public int getInfixExpressionCount(){
		return totalInfixExpressionCount;
	}
	public int getPrefixExpressionCount(){
		return totalPrefixExpressionCount;
	}
}
