package ASTNodeCountVisitorTests;
import static org.junit.Assert.*;

import org.junit.Test;

import q4b.*;

public class ASTNodeCountVisitorTests {
	
	NodeFactory nfactory = new NodeFactory();
	Variable x = new Variable("x");
	Variable y = new Variable("y");
	Operator plus = new Operator("+");
	
	@Test
	public void add_remove_NodesInNodeSet(){
		NodeSet nset = new NodeSet();
		Statement decl = nfactory.makeDeclaration(x);
		nset.add(decl);
		assertEquals(1,nset.size());
		Expression numex = nfactory.makeNumberExpression(2);
		nset.add(numex);
		assertEquals(2,nset.size());
	}
	
	@Test
	public void remove_NodeFromNodeSet_checkSize(){
		NodeSet nset1 = new NodeSet();
		Statement decl = nfactory.makeDeclaration(x);
		nset1.add(decl);
		assertEquals(1,nset1.size());
		Expression numex = nfactory.makeNumberExpression(2);
		nset1.add(numex);
		assertEquals(2,nset1.size());
		nset1.remove(numex);
		assertEquals(1,nset1.size());
	}
	
	@Test
	public void addAll_fromNodeSet(){
		NodeSet nset = new NodeSet();
		Statement decl = nfactory.makeDeclaration(x);
		nset.add(decl);
		
		NodeSet n = new NodeSet();
		Declaration d = new Declaration(y);
		Expression numex = nfactory.makeNumberExpression(2);
		Expression stringex = nfactory.makeStringExpression("Hellooo");
		n.add(d);
		n.add(numex);
		n.add(stringex);
		nset.addAll(n);
		Iterator<Node> in = nset.iterator();
		
		if(in.hasAnotherElement()){
			Node nm = in.nextElement();
			assertEquals(decl, nm);
		}
		if(in.hasAnotherElement()){
			Node nm = in.nextElement();
			assertEquals(d, nm);
		}

		assertEquals(4, nset.size());	
	}
	
	@Test
	public void toString_AddAllNodes_TextRepresentation(){
		NodeSet nset = new NodeSet();
		
		Statement decl1 = nfactory.makeDeclaration(x);
		Statement decl2 = nfactory.makeDeclaration(y);
		Expression numex = nfactory.makeNumberExpression(2);
		Expression stringex = nfactory.makeStringExpression("Hellooo");
		
		nset.add(decl1);
		nset.add(decl2);
		nset.add(numex);
		nset.add(stringex);

		assertEquals("var x;\nvar y;\n2\n\"Hellooo\"\n",nset.toString());
	}
	
	@Test
	public void getDeclarationCount_ShouldReturnNumberOfDeclarations(){
		ASTNodeCountVisitor avisitor = new ASTNodeCountVisitor();
		Statement declx = nfactory.makeDeclaration(x);
		Statement decly = nfactory.makeDeclaration(y);
		Expression numex = nfactory.makeNumberExpression(2);
		declx.accept(avisitor);
		decly.accept(avisitor);
		numex.accept(avisitor);
		assertEquals(2,avisitor.getDeclarationCount());
		assertEquals(1,avisitor.getNumExpressionCount());
	}
	
	@Test
	public void getNumExpressionCount_ShouldReturnNumberOfNumExpressions(){
		ASTNodeCountVisitor avisitor = new ASTNodeCountVisitor();
		Expression numex = nfactory.makeNumberExpression(2);
		Expression stringex = nfactory.makeStringExpression("Hellooo");
		numex.accept(avisitor);
		stringex.accept(avisitor);
		assertEquals(1,avisitor.getNumExpressionCount());
		assertEquals(1,avisitor.getStringExpressionCount());
	}
	
	@Test
	public void getStringExpressionCount_ShouldReturnNumberOfStringExpressions(){
		ASTNodeCountVisitor avisitor = new ASTNodeCountVisitor();
		Expression stringex1 = nfactory.makeStringExpression("Hellooo");
		Expression stringex2 = nfactory.makeStringExpression("World");
		stringex1.accept(avisitor);
		stringex2.accept(avisitor);
		assertEquals(2,avisitor.getStringExpressionCount());
	}

}
