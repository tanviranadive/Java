package ASTSearchVisitorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import q4c.*;

public class ASTSearchVisitorTests {

	NodeFactory nfactory = new NodeFactory();
	Variable x = new Variable("x");
	Variable y = new Variable("y");
	Operator plus = new Operator("+");
	
	@Test
	public void test(){
		NodeSet nset = new NodeSet();
		Declaration decl = new Declaration(x);
		nset.add(decl);
		assertEquals(1,nset.size());
		assertEquals(1,decl.getId());
		NumberExpression numex = new NumberExpression(2);
		nset.add(numex);
		assertEquals(2,nset.size());
		nset.remove(numex);
		assertEquals(1,nset.size());
		
		NodeSet n = new NodeSet();
		Declaration d = new Declaration(y);
		n.add(d);
		NumberExpression numex1 = new NumberExpression(2);
		StringExpression stringex1 = new StringExpression("Hellooo");
		n.add(numex1);
		n.add(stringex1);
		nset.addAll(n);
		Iterator<Node> in = nset.iterator();
		if(in.hasAnotherElement()){
			Node nm = in.nextElement();
			assertEquals(decl,nm);
		}
		
		assertEquals("var x;\nvar y;\n2\n\"Hellooo\"\n",nset.toString());
		assertEquals(4, nset.size());
	}
	
	
	@Test
	public void test2(){
		
		Declaration decl = new Declaration(x);
		Declaration decl1 = new Declaration(y);
		NumberExpression numex1 = new NumberExpression(2);
		Assignment assign = new Assignment(x, numex1);
		ASTSearchVisitor avisitor = new ASTSearchVisitor();
		avisitor.setSearchVar("x");
		decl.accept(avisitor);
		decl1.accept(avisitor);
		numex1.accept(avisitor);
		assign.accept(avisitor);
		NodeSet nset = avisitor.getMatches();
		Iterator<Node> it = nset.iterator();
		assertEquals("var x;\nx = 2;\n",nset.toString());
		if(it.hasAnotherElement()){
			Node n = it.nextElement();
			assertEquals(decl,n);
		}
		if(it.hasAnotherElement()){
			Node n = it.nextElement();
			assertEquals(assign,n);
		}
		
	}
	
	@Test
	public void test3(){
		
		Variable v = new Variable("xyz");
		Declaration decl = new Declaration(v);
		Declaration decl1 = new Declaration(y);
		NumberExpression numex1 = new NumberExpression(2);
		StringExpression stringex1 = new StringExpression("xyz");
		InfixExpression infix = new InfixExpression(plus, numex1, stringex1);
		Assignment assign = new Assignment(y, infix);
		ASTSearchVisitor avisitor = new ASTSearchVisitor();
		avisitor.setSearchVar("xyz");
		decl.accept(avisitor);
		decl1.accept(avisitor);
		numex1.accept(avisitor);
		stringex1.accept(avisitor);
		assign.accept(avisitor);
		NodeSet nset = avisitor.getMatches();
		Iterator<Node> it = nset.iterator();
		if(it.hasAnotherElement()){
			Node n = it.nextElement();
			assertEquals(decl,n);
		}
		
		assertEquals("var xyz;\n",nset.toString());
	}
	
	@Test
	public void test4(){
		
		Variable v = new Variable("xyz");
		Declaration decl = new Declaration(v);
		NumberExpression numex1 = new NumberExpression(2);
		VariableExpression varex1 = new VariableExpression(v);
		StringExpression stringex1 = new StringExpression("xyz");
		InfixExpression infix = new InfixExpression(plus, numex1, stringex1);
		Assignment assign = new Assignment(y, infix);
		ASTSearchVisitor avisitor = new ASTSearchVisitor();
		avisitor.setSearchVar(v);
		decl.accept(avisitor);
		numex1.accept(avisitor);
		varex1.accept(avisitor);
		assign.accept(avisitor);
		NodeSet nset = avisitor.getMatches();
		Iterator<Node> it = nset.iterator();
		if(it.hasAnotherElement()){
			Node n = it.nextElement();
			assertEquals(decl,n);
		}
		
		assertEquals("var xyz;\n",nset.toString());
	}

	
}
