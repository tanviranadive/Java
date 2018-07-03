package tests;

import ast.*;

import static org.junit.Assert.*;

import org.junit.Test;

// Tests for ast
public class ASTTests {

	// Sample test provided
	@Test
	public void test1(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl,assign);
		assertEquals("var x; x = 1 + 2;", seq.textRepresentation());
		}
	
	@Test
	public void test2(){
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Expression one = new NumberExpression(1);
		Expression two = new VariableExpression(y);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl,assign);
		assertEquals("var x; x = 1 + y;", seq.textRepresentation());
		}
	
	@Test
	public void test3(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator multiply = new Operator("*");
		Expression exp = new PrefixExpression(multiply, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl,assign);
		assertEquals("var x; x = * 1 2;", seq.textRepresentation());
		}
	
	@Test
	public void test4(){
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator multiply = new Operator("*");
		Expression exp = new PrefixExpression(multiply, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		
		Expression three = new NumberExpression(3);
		Expression four = new NumberExpression(4);
		Operator divide = new Operator("/");
		Expression exp1 = new PrefixExpression(divide, three, four);
		Statement decl1 = new Declaration(y);
		Statement assign1 = new Assignment(y, exp1);
		
		Statement seq = new Sequence(decl,assign,decl1,assign1);
		assertEquals("var x; x = * 1 2; var y; y = / 3 4;", seq.textRepresentation());
		}
	
	@Test
	public void test5(){
		Variable x = new Variable("x");
		Expression one = new StringExpression("Hello");
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, one);
		Statement seq = new Sequence(decl,assign);
		assertEquals("var x; x = \"Hello\";", seq.textRepresentation());
		}
	
	@Test
	public void test6(){
		Variable x = new Variable("x");
		Expression one = new StringExpression("Hello");
		Expression two = new NumberExpression(2);
		Operator multiply = new Operator("*");
		Expression exp = new PrefixExpression(multiply, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl,assign);
		assertEquals("var x; x = * \"Hello\" 2;", seq.textRepresentation());
		}
	
	@Test
	public void test7(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator multiply = new Operator("*");
		Expression exp = new PrefixExpression(multiply, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl,assign);
		assertNotEquals("var x;x = * 1 2;", seq.textRepresentation());
		}

	@Test
	public void test8(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator multiply = new Operator("*");
		Expression exp = new PrefixExpression(multiply, one, two);
		Variable z = new Variable("z");
		Expression four = new VariableExpression(z);
		Operator add = new Operator("+");
		Expression exp1 = new PrefixExpression(add, exp, four);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp1);
		Statement seq = new Sequence(decl,assign);
		assertEquals("var x; x = + * 1 2 z;", seq.textRepresentation());
		}
	
	@Test
	public void test9(){
		Variable x = new Variable("x");	
		Variable y = new Variable("y");
		Expression exp1 = new VariableExpression(y);	
		Statement declx = new Declaration(x);
		Statement assign = new Assignment(x, exp1);
		Statement seq = new Sequence(declx,assign);
		assertEquals("var x; x = y;", seq.textRepresentation());
		}
	
	@Test
	public void test10(){
		Variable x = new Variable("x");	
		Variable y = new Variable("y");
		Statement declx = new Declaration(x);
		Statement decly = new Declaration(y);
		Statement seq = new Sequence(declx,decly);
		assertEquals("var x; var y;", seq.textRepresentation());
		}

}
