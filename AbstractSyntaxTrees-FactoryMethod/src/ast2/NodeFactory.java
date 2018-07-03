package ast2;

// Node Factory creates different instances of nodes depending on which
// type of creation method is called.
public class NodeFactory {

	// creates new declaration instance
	public Statement makeDeclaration(Variable x){
		return new Declaration(x);
	}
	
	// creates new assignment instance
	public Statement makeAssignment(Variable x, Expression e){
		return new Assignment(x,e);
	}
	
	// creates new statement instance
	public Statement makeSequence(Statement...st){
		return new Sequence(st);
	}
	
	// creates new number expression instance
	public Expression makeNumberExpression(Number n){
		return new NumberExpression(n);
	}
	
	// creates new string expression instance
	public Expression makeStringExpression(String s){
		return new StringExpression(s);
	}
	
	// creates new variable expression instance
	public Expression makeVariableExpression(Variable v){
		return new VariableExpression(v);
	}
	
	// creates new infix expression instance
	public Expression makeInfixExpression(Operator o, Expression e1, Expression e2){
		return new InfixExpression(o,e1,e2);
	}
	
	// creates new prefix expression instance
	public Expression makePrefixExpression(Operator o, Expression e1, Expression e2){
		return new PrefixExpression(o,e1,e2);
	}
}
