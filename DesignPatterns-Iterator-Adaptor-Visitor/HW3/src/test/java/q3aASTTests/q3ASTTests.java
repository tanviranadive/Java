package q3aASTTests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import q3aASTNode.Expression;
import q3aASTNode.NodeFactory;
import q3aASTNode.NumberExpression;
import q3aASTNode.Operator;
import q3aASTNode.Statement;
import q3aASTNode.StringExpression;
import q3aASTNode.Variable;

public class q3ASTTests {

	NodeFactory nfactory = new NodeFactory();
	Variable x = new Variable("x");
	Variable y = new Variable("y");
	Operator plus = new Operator("+");
	
	@Test(expected = java.util.NoSuchElementException.class)
	public void getId_addNode_ShouldReturnIdOfNode(){
		Expression numEx = nfactory.makeNumberExpression(2);
		Expression numEx1 = nfactory.makeNumberExpression(4);
		Expression stringEx = nfactory.makeStringExpression("Hello");
		Statement assign = nfactory.makeAssignment(x, numEx);
		int numExId = numEx.getId();
		int numEx1Id = numEx1.getId();
		int stringExId = stringEx.getId();
		int assignId = assign.getId();
		assertEquals(numEx, numEx.getNode(numExId));
		assertEquals(numEx1, numEx.getNode(numEx1Id));
		assertEquals(stringEx, numEx.getNode(stringExId));
		assertEquals(assign, numEx.getNode(assignId));		
		numEx.getNode(20);
	}
	
	@Test(expected = java.util.NoSuchElementException.class)
	public void getNode_removed_ShouldThrowException(){
		Expression stringEx = nfactory.makeStringExpression("Hello");
		int stringExId = stringEx.getId();
		stringEx.getNode(stringExId+1);
	}
	
	
}
