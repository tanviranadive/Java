package ast;

// Interface Statement implemented by Declaration, Assignment and Sequence.
public interface Statement extends Node {
	String textRepresentation();
}
