package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import ast2.Assignment;
import ast2.Expression;
import ast2.Operator;
import ast2.Sequence;
import ast2.Statement;
import ast2.Variable;
import ast2.NodeFactory;

public class AST2Tests {
	
	NodeFactory nfactory = new NodeFactory();
	Variable x = new Variable("x");
	Variable y = new Variable("y");
	Operator plus = new Operator("+");
	
	@Test
	public void test1(){
		
		Statement assign = nfactory
				.makeAssignment(x, 
						nfactory.makeInfixExpression(plus, 
								nfactory.makeNumberExpression(1), 
								nfactory.makeNumberExpression(2)));
		Statement seq = nfactory.makeSequence(nfactory.makeDeclaration(x),
											  assign);
		assertEquals("var x; x = 1 + 2;", seq.textRepresentation());
		}
	
	
	
	
	@Test
	public void test2(){
		
		Statement assign = nfactory.makeAssignment(
									x,
									nfactory.makeInfixExpression(
											plus,
											nfactory.makeNumberExpression(1),
											nfactory.makeVariableExpression(y)));
		
		Statement seq = nfactory.makeSequence(nfactory.makeDeclaration(x),assign);
		assertEquals("var x; x = 1 + y;", seq.textRepresentation());
		}

	@Test
	public void test3(){

		Statement assign = nfactory.makeAssignment(
									x,
									nfactory.makePrefixExpression(
											plus,
											nfactory.makeNumberExpression(1),
											nfactory.makeNumberExpression(2)));
		Statement seq = nfactory.makeSequence(nfactory.makeDeclaration(x),assign);
		assertEquals("var x; x = + 1 2;", seq.textRepresentation());
		}
	
	@Test
	public void test4(){
		
		Statement assign = nfactory.makeAssignment(
									x, 
									nfactory.makePrefixExpression(
											plus,
											nfactory.makeNumberExpression(1),
											nfactory.makeNumberExpression(2)));
		
		Operator divide = new Operator("/");
		Statement assign1 = nfactory.makeAssignment(
										y,
										nfactory.makePrefixExpression(divide,
												nfactory.makeNumberExpression(3),
												nfactory.makeNumberExpression(4)));
		
		Statement seq = nfactory.makeSequence(nfactory.makeDeclaration(x),assign,
											  nfactory.makeDeclaration(y),assign1);
		assertEquals("var x; x = + 1 2; var y; y = / 3 4;", seq.textRepresentation());
		}
	
	@Test
	public void test5(){
		Statement assign = nfactory.makeAssignment(x,
									nfactory.makeStringExpression("Hello"));
		Statement seq = new Sequence(nfactory.makeDeclaration(x),assign);
		assertEquals("var x; x = \"Hello\";", seq.textRepresentation());
		}
	
	@Test
	public void test6(){

		Statement assign = nfactory.makeAssignment(x,
									nfactory.makePrefixExpression(plus,
											nfactory.makeStringExpression("Hello"), 
											nfactory.makeNumberExpression(2)));
		Statement seq = new Sequence(nfactory.makeDeclaration(x),assign);
		assertEquals("var x; x = + \"Hello\" 2;", seq.textRepresentation());
		}
	
	@Test
	public void test7(){

		Statement assign = nfactory.makeAssignment(x,
				nfactory.makePrefixExpression(plus,
						nfactory.makeNumberExpression(1), 
						nfactory.makeNumberExpression(2)));
		Statement seq = new Sequence(nfactory.makeDeclaration(x),assign);
		assertNotEquals("var x;x = * 1 2;", seq.textRepresentation());
		}
	
	@Test
	public void test8(){

		Operator multiply = new Operator("*");
		Expression exp = nfactory.makePrefixExpression(multiply, 
									nfactory.makeNumberExpression(1),
									nfactory.makeNumberExpression(2));
		Variable z = new Variable("z");
		Expression exp1 = nfactory.makePrefixExpression(plus, 
				exp, 
				nfactory.makeVariableExpression(z));
		Statement assign = nfactory.makeAssignment(x, exp1);
		Statement seq = nfactory.makeSequence(nfactory.makeDeclaration(x),assign);
		assertEquals("var x; x = + * 1 2 z;", seq.textRepresentation());
		}
	
	@Test
	public void test9(){
		
		Statement assign = new Assignment(x, 
								nfactory.makeVariableExpression(y));
		Statement seq = new Sequence(nfactory.makeDeclaration(x),assign);
		assertEquals("var x; x = y;", seq.textRepresentation());
		}
	
	@Test
	public void test10(){

		Statement seq = nfactory.makeSequence(nfactory.makeDeclaration(x),
											nfactory.makeDeclaration(y));
		assertEquals("var x; var y;", seq.textRepresentation());
		}
}
