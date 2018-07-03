package q3bASTNodeSetTests;

import static org.junit.Assert.*;

import org.junit.Test;

import q3bASTNodeSet.*;

public class q3bASTTests {
	

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
		if(in.hasAnotherElement()){
			Node nm = in.nextElement();
			assertEquals(d,nm);
		}
		if(in.hasAnotherElement()){
			Node nm = in.nextElement();
			assertEquals(numex1,nm);
		}
		
		assertEquals("var x;\nvar y;\n2\n\"Hellooo\"\n",nset.toString());
		assertEquals(4, nset.size());
	}
	

}
