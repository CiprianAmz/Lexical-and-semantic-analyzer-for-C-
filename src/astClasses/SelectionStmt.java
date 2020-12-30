package astClasses;

import symbolTable.Symbol;

public class SelectionStmt extends AbstractSyntaxTreeNode {
	Expression e;
	Statement s1;
	Statement s2;
	
	public SelectionStmt(Expression e, Statement s1,Statement s2){
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
		
		this.addNode(e);
		this.addNode(s1);
		this.addNode(s2);
	}
	
	public SelectionStmt(Expression e, Statement s1){
		this.e = e;
		this.s1 = s1;
		
		this.addNode(e);
		this.addNode(s1);
	}
	
	public void print(){
		System.out.println("SelectionStmt");
		
		e.print();
		s1.print();
		if(s2 != null){
			s2.print();
		}
	}

	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "SelectionStmt";
	}

	@Override
	public boolean checkSemantic(Symbol context) {
		if(e.checkSemantic(context) == false) {
			semanticErrors.add("Error: Invalid IF contition."); 
		}
		
		s1.checkSemantic(context);
		
		if(s2 != null) {
			s2.checkSemantic(context);
		}
		
		return false;
	}

}
