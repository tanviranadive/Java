package ast;

// Interface Expression extends the interface Node.
// Implemented by its subclasses which are types of Expression.
// InfixExpression, PrefixExpression, NumberExpression, StringExpression, Variable Expression
public interface Expression extends Node{
	String textRepresentation();
}
