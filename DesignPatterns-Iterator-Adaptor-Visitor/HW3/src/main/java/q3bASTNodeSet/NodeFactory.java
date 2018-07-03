package q3bASTNodeSet;

import java.util.logging.Level;
import java.util.logging.Logger;

//Node Factory creates different instances of nodes depending on which
//type of creation method is called.
//Maintains counts of different types of nodes.
public class NodeFactory {
	
	public static final Logger LOGGER = Logger.getLogger(NodeFactory.class.getName());

	private int declarationCount;
	private int assignmentCount;
	private int sequenceCount;
	private int numExpCount;
	private int stringExpCount;
	private int varExpCount;
	private int infixCount;
	private int prefixCount;

	public NodeFactory(){
		this.declarationCount = 0;
		this.assignmentCount = 0;
		this.sequenceCount = 0;
		this.numExpCount = 0;
		this.stringExpCount = 0;
		this.varExpCount = 0;
		this.infixCount = 0;
		this.prefixCount = 0;
	}
	
	// creates new declaration instance
	public Statement makeDeclaration(Variable x){
		this.declarationCount++;
		return new Declaration(x);
	}
	
	// creates new assignment instance
	public Statement makeAssignment(Variable x, Expression e){
		this.assignmentCount++;
		return new Assignment(x,e);
	}
	
	// creates new sequence instance
	public Statement makeSequence(Statement...st){
		this.sequenceCount++;
		return new Sequence(st);
	}
	
	// creates new number expression instance
	public Expression makeNumberExpression(Number n){
		this.numExpCount++;
		return new NumberExpression(n);
	}
	
	// creates new string expression instance
	public Expression makeStringExpression(String s){
		this.stringExpCount++;
		return new StringExpression(s);
	}
	
	// creates new variable expression instance
	public Expression makeVariableExpression(Variable v){
		this.varExpCount++;
		return new VariableExpression(v);
	}
	
	// creates new infix expression instance
	public Expression makeInfixExpression(Operator o, Expression e1, Expression e2){
		this.infixCount++;
		return new InfixExpression(o,e1,e2);
	}
	
	// creates new prefix expression instance
	public Expression makePrefixExpression(Operator o, Expression e1, Expression e2){
		this.prefixCount++;
		return new PrefixExpression(o,e1,e2);
	}
	
	//report method called gives count for each node created using a logger
	public void report(){
		
		int expressionCount = this.numExpCount+this.stringExpCount+this.varExpCount+this.infixCount+this.prefixCount;
		int statementCount = this.assignmentCount + this.declarationCount + this.sequenceCount;
		String message = "\n --------------------------------------------------";
		Logger.getGlobal().info(message);
		LOGGER.log(Level.INFO,"\n Declarations : {0} \n Assignments : {1} \n Sequences : {2} \n Statements : {3} \n Expressions : {4} \n NumberExpressions : {5} \n StringExpressions : {6} \n Variable Expressions : {7} \n Infix Expressions : {8} \n Prefix Expressions : {9} \n" , 
								new Object[]{this.declarationCount, 
										this.assignmentCount, 
										this.sequenceCount, 
										statementCount, 
										expressionCount, 
										this.numExpCount, 
										this.stringExpCount, 
										this.varExpCount, 
										this.infixCount, 
										this.prefixCount});
		
	}
}
