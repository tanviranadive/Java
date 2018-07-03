package q3bASTNodeSet;

//class used for Declaration operation. Implements Statement interface.
//Takes a Variable as input and returns its string representation.
public class Declaration extends Statement{
	private Variable var;
	private int id;
	
	public Declaration(Variable v){
		var = v;
		this.id = counter;
		counter++;
	}
	
	/** 
	* Implement textRepresentation method of the interface.
	*Concatenates and formats the variable value in a string
	*@return string textRepresentation
	*/
	public String textRepresentation(){
		return "var "+ var+ ";";
	}

	/**
	 * getter for id of Node
	 */
	@Override
	public int getId() {
		return this.id;
	}
	
}
