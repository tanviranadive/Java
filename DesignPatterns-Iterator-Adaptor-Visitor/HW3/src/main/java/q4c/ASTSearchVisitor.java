package q4c;

/**
 * ASTSearchVisitor searches for matching declarations and assignments for given variable or string
 * @author Tanvi
 *
 */
public class ASTSearchVisitor implements ASTVisitor{

	private String searchVar;
	private NodeSet nset = new NodeSet();
	
	public ASTSearchVisitor(){
	}
	
	public void setSearchVar(String s){
		this.searchVar = s;
	}
	
	public void setSearchVar(Variable v){
		this.searchVar = v.toString();
	}
	
	public void visit(Declaration d){
		String str = d.textRepresentation();
		if(str.substring(4,str.length()-1).trim().equals(searchVar.trim())){
			this.nset.add(d);
		}
	}
	
	public void visit(Assignment assign){
		String str = assign.textRepresentation();
		int startIndex = str.indexOf('"');
		if(startIndex>-1){
			int endIndex = startIndex + str.substring(startIndex+1).indexOf('"');
			String temp = str.substring(startIndex+1, endIndex+1);
			String updated = str.replace(temp," ");
			if(updated.contains(searchVar)){
				this.nset.add(assign);
			}
		}
		
		else{
			if(str.contains(searchVar)){
				this.nset.add(assign);
			}
		}
	}
	
	public void visit(Sequence seq)
	{
		
	}
	public void visit(NumberExpression numexp){
		
	}
	public void visit(StringExpression stringexp){
		
	}
	
	public void visit(VariableExpression varexp){
		
	}
	
	public void visit(InfixExpression inexp){
		
	}
	
	public void visit(PrefixExpression preexp){
		
	}
	
	public NodeSet getMatches(){
		return this.nset;
	}
}
